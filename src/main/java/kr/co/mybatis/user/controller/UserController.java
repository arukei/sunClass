package kr.co.mybatis.user.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import kr.co.mybatis.DbConn.DbConnection;
import kr.co.mybatis.board.dto.Board;
import kr.co.mybatis.user.dto.User;
import kr.co.mybatis.user.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	UserService service;

	@Autowired
	DbConnection conn;
	
	@RequestMapping("/")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("/movereguser")
	public ModelAndView movereguser() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("reguser");
		
		return mv;
	}
	
	@RequestMapping("reguser")
	public ModelAndView reguser(User userVo) throws Exception {
		ModelAndView mv = new ModelAndView();

		String result = service.reguser(userVo);
		
		mv.addObject("msg",result);
		mv.setViewName("home");
		
		return mv;
	}
	
	
	@RequestMapping("moveuserlogin")
	public ModelAndView moveuserlogin() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("userlogin");
		
		return mv;
	}
	
	@RequestMapping("logincheck")
	public ModelAndView userlogin(HttpSession session, User userVo) throws Exception {
		
		String returnURL = "";
		
		ModelAndView mv = new ModelAndView();

		//로그인이 성공하면 유저정도를 담음
		User user = service.login(userVo);
		
		// 로그인 성공 시
		if(user != null) {
			// user라는 이름으로 user정보를 담는다.
			session.setAttribute("user", user);
			// 로그인 성공시 게시글 목록페이지로 바로 이동
			returnURL ="redirect:/listPage";
			// 로그인 실패 시
		}else {
			// 로그인 폼으로 다시 가도록 함
			returnURL ="redirect:/";
		}
		mv.addObject("user", user);
		mv.setViewName(returnURL);
		return mv;
	}

	@RequestMapping(value = "/movemoduserinfo")
	public ModelAndView movemoduserinfo(@ModelAttribute("user") User userVo) throws Exception {
		ModelAndView mv = new ModelAndView("moduserinfo");
		
		User user = service.findmoduserinfo(userVo);
		
		mv.addObject("user", user);
		
		return mv;
	}
	
	@RequestMapping("/moduserinfo")
	//public ModelAndView moduserinfo(String password, String email,  String nickname, String id) throws Exception {
	public ModelAndView moduserinfo(@ModelAttribute("user") User userVo)throws Exception {	

		//String password = request.getParameter("password");
		//String email = request.getParameter("email");
		//String nickname = request.getParameter("nickname");
		//String id = request.getParameter("id");
		ModelAndView mv = new ModelAndView();
		
		service.moduserinfo(userVo);
		
		mv.setViewName("redirect:/");
		
		return mv;
	}
	
	@RequestMapping("/adminpage")
	public ModelAndView moveadminpage(@ModelAttribute("user") User userVo) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		// user정보가 없으면 자동으로 걸리는지..?
		if(userVo.getAuth() != 2 ) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		List<User> usersList = service.getUsersList();
		mv.setViewName("adminpage");
		// 회원들 정보
		mv.addObject("usersList", usersList);
		return mv;
	}
	
	// 회원등급업
	@RequestMapping(value="/upGradeAuth")
	public ModelAndView upgradeauth(@ModelAttribute("user") User userVo) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		// user정보가 없으면 자동으로 걸리는지..?
		if(userVo.getAuth() != 2 ) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		mv.setViewName("redirect:/adminpage");
		service.upGradeAuth(userVo);
		
		return mv;
	}
	// 회원등급다운 
	@RequestMapping(value="/downGradeAuth")
	public ModelAndView downGradeAuth(@ModelAttribute("user") User userVo) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		// user정보가 없으면 자동으로 걸리는지..?
		if(userVo.getAuth() != 2 ) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		mv.setViewName("redirect:/adminpage");
		service.downGradeAuth(userVo);
		
		return mv;
	}

	// 회원탈퇴
	@RequestMapping(value="/deleteUserInfo")
	public ModelAndView deleteUserInfo(@ModelAttribute("user") User userVo) throws Exception {

		ModelAndView mv = new ModelAndView();
		
		// user정보가 없으면 자동으로 걸리는지..?
		if(userVo.getAuth() != 2 ) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		mv.setViewName("redirect:/adminpage");
		service.deleteUserInfo(userVo);
		
		return mv;
	}
	// 로그아웃 하는 부분
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
    	
    	// 세션 전체를 날려버림
    	session.invalidate();
    	// 하나씩 하려면 이렇게 해도 됨.
        //session.removeAttribute("login");
    	// 로그아웃 후 로그인화면으로
        return "redirect:/";
    }

}
