package kr.co.mybatis.user.service;




import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.mybatis.user.dto.User;

public interface UserService {
	
	//public String reguser(String id, String password, String email1, String email2, String nickname, String gender) throws Exception;
	public String reguser(User userVo) throws Exception;
	public User login(User userVo)throws Exception;
	public User findmoduserinfo(User userVo)throws Exception;
	public void moduserinfo(User userVo)throws Exception;
	public List<User> getUsersList()throws Exception;
	public void upGradeAuth(User userVo)throws Exception;
	public void downGradeAuth(User userVo)throws Exception;
	public void deleteUserInfo(User userVo)throws Exception;
	

}
