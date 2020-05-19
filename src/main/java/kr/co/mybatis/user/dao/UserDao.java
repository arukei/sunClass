package kr.co.mybatis.user.dao;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.mybatis.user.dto.User;

public interface UserDao {
	
	public int reguser(User userVo)throws Exception;
	public User login(User userVo)throws Exception;
	public User findmoduserinfo(User userVo)throws Exception;
	public void moduserinfo(User userVo)throws Exception;
	public List<User> getUsersList()throws Exception;
	public void upGradeAuth(User userVo)throws Exception;
	public void downGradeAuth(User userVo)throws Exception;
	public void deleteUserInfo(User userVo)throws Exception;

}
