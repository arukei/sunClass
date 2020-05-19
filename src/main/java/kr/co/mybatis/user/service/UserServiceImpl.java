package kr.co.mybatis.user.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mybatis.user.dao.UserDao;
import kr.co.mybatis.user.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	@Override
	public String reguser(User userVo)throws Exception {
		int result = dao.reguser(userVo);
		String nickname = userVo.getNickname();
		String msg = null;
		if (result > 0) {
			msg = nickname+" 님 회원가입에 성공했습니다.";
			return msg;
		}
		msg = "회원가입에 실패했습니다.";
		return msg;
	}

	@Override
	public User findmoduserinfo(User userVo) throws Exception {
		
		return dao.findmoduserinfo(userVo);
	}

	@Override
	public void moduserinfo(User userVo) throws Exception {
		
		dao.moduserinfo(userVo);
		
	}

	@Override
	public User login(User userVo) throws Exception {
		
		return dao.login(userVo);
		
	}

	@Override
	public List<User> getUsersList() throws Exception {
		return dao.getUsersList();
	}

	@Override
	public void upGradeAuth(User userVo) throws Exception {
		
		dao.upGradeAuth(userVo);
		
	}

	@Override
	public void downGradeAuth(User userVo) throws Exception {
		dao.downGradeAuth(userVo);
	}

	@Override
	public void deleteUserInfo(User userVo) throws Exception {
		
		dao.deleteUserInfo(userVo);
		
	}

}
