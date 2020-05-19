package kr.co.mybatis.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mybatis.board.dto.Board;
import kr.co.mybatis.board.service.BoardService;
import kr.co.mybatis.user.dto.User;

@Controller
@SessionAttributes("user")
public class BoardController {
	
	
	@Autowired
	BoardService service;
	
	
	@RequestMapping("/listPage")
	public ModelAndView getBoardList(HttpSession session , User userVo) throws Exception {
		
		userVo = (User) session.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		
		if(userVo == null) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		List<Board> boardList = service.getBoardList();
		mv.setViewName("board");
		// 게시판 정보
		mv.addObject("boardList", boardList);
		return mv;
	}

	@RequestMapping("/getBoardContent")
	public ModelAndView getBoardContent(@ModelAttribute(value="user") User userVo, Board boardVo) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(userVo == null) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		Board boardContent = service.getBoardContent(boardVo);

		mv.setViewName("detailboardcontent");
		mv.addObject("boardContent", boardContent);
		
		return mv;
	}
	
	@RequestMapping("/movewriteboard")
	public ModelAndView movewriteboard(@ModelAttribute(value="user") User userVo, Board boardVo) {
		ModelAndView mv = new ModelAndView();

		if(userVo == null) {
			mv.setViewName("redirect:/");
			return mv;
		}
		mv.setViewName("writeboardcontent");
		
		return mv;
	}
	
	@RequestMapping("/writeBoard")
	public ModelAndView writeBoard(@ModelAttribute(value="user") User userVo, Board boardVo) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(userVo == null) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		 service.writeBoard(boardVo);
		
		mv.setViewName("redirect:/listPage");
		
		return mv;
	}

	@RequestMapping("/getMyBoardList")
	public ModelAndView getMyBoardList(@ModelAttribute(value="user") User userVo, Board boardVo) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(userVo == null) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		List<Board> myBoardList = service.getMyBoardList(boardVo);
		
		mv.setViewName("board");
		mv.addObject("boardList", myBoardList);
		
		return mv;
	}

	@RequestMapping("/modBoardContent")
	public ModelAndView modBoardContent(@ModelAttribute(value="user") User userVo, Board boardVo) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(userVo == null) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		Board modBoardContent = service.modBoardContent(boardVo);
		
		mv.setViewName("modboardcontent");
		mv.addObject("modBoardContent", modBoardContent);
		
		return mv;
	}

	@RequestMapping("/modBoardContentAcion")
	public ModelAndView modBoardContentAcion(@ModelAttribute(value="user") User userVo, Board boardVo) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(userVo == null) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		service.modBoardContentAcion(boardVo);
		
		mv.setViewName("redirect:/listPage");
		
		
		return mv;
	}
	
	


}
