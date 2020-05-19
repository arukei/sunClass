package kr.co.mybatis.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kr.co.mybatis.DbConn.DbConnection;
import kr.co.mybatis.user.dto.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	DbConnection db;

	@Override
	public int reguser(User userVo)throws SQLException, ClassNotFoundException {

		String id = userVo.getId();
		String password = userVo.getPassword();
		String emailId = userVo.getEmailId();
		String emailAddress = userVo.getEmailAddress();
		String email = emailId +"@" +emailAddress; 
		String nickname = userVo.getNickname();
		String gender = userVo.getGender();
		
		// 회원가입페이지에서 유저정보를 받아서 DB에 입력
		String sql = "insert into user_info(id,password,email,nickname,gender) values(?,?,?,?,?)";

		Connection conn = db.DbConnect();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, password);
		ps.setString(3, email);
		ps.setString(4, nickname);
		ps.setString(5, gender);

		int result = ps.executeUpdate();
		

		return result;
	}

	@Override
	public User findmoduserinfo(User userVo) throws Exception {

		String id = userVo.getId();
		// 메인페이지에서 유저Id정보를 받아서 해당 Id정보를 DB에서 받음
		String sql = "select *  from user_info where id = ?";

		Connection conn = db.DbConnect();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();

		User user = new User();

		// DB에서 받은 정보를 User 객체에 담음
		rs.last();
		
		user.setEmail(rs.getString("email"));
		user.setGender(rs.getString("gender"));
		user.setId(rs.getString("id"));
		user.setNickname(rs.getString("nickname"));
		user.setPassword(rs.getString("password"));

		return user;
	}

	@Override
	public void moduserinfo(User userVo) throws Exception {
		
		String password = userVo.getPassword();
		String email = userVo.getEmail();
		String nickname = userVo.getNickname();
		String id = userVo.getId();

		// 회원정보수정페이지에서 넘겨받은 정보를 DB에 업데이트
		String sql = "update user_info set password = ? , email = ?, nickname = ? where id =? ";

		Connection conn = db.DbConnect();

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, password);
		ps.setString(2, email);
		ps.setString(3, nickname);
		ps.setString(4, id);

		ps.executeUpdate();

	}

	@Override
	public User login(User userVo) throws Exception {
		
		String id = userVo.getId();
		String password = userVo.getPassword();
		
		String sql = "select * from user_info where id = ? and password = ?";

		Connection conn = db.DbConnect();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, id);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();
		
		User user = new User();
		rs.last();
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setNickname(rs.getString("nickname"));
			user.setGender(rs.getString("gender"));
			user.setAuth(rs.getInt("auth"));
			user.setReg_date(rs.getString("reg_date"));

		return user;
	}

	@Override
	public List<User> getUsersList() throws Exception {
		
		String sql = "select id, nickname, gender, auth, reg_date from user_info";

		Connection conn = db.DbConnect();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<User>userList =  new ArrayList<User>();
		
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setNickname(rs.getString("nickname"));
			user.setGender(rs.getString("gender"));
			user.setAuth(rs.getInt("auth"));
			user.setReg_date(rs.getString("reg_date"));
			
			userList.add(user);
		}
		return userList;
	}

	@Override
	public void upGradeAuth(User userVo) throws SQLException, ClassNotFoundException {
		String id = userVo.getId();

		// 회원정보수정페이지에서 넘겨받은 정보를 DB에 업데이트
		String sql = "update user_info set auth = 1 where id =? ";

		Connection conn = db.DbConnect();

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);

		ps.executeUpdate();

	}

	@Override
	public void downGradeAuth(User userVo) throws Exception {
		String id = userVo.getId();

		// 회원정보수정페이지에서 넘겨받은 정보를 DB에 업데이트
		String sql = "update user_info set auth = 0 where id =? ";

		Connection conn = db.DbConnect();

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);

		ps.executeUpdate();

	}

	@Override
	public void deleteUserInfo(User userVo) throws Exception {
		String id = userVo.getId();

		// 회원정보수정페이지에서 넘겨받은 정보를 DB에 업데이트
		String sql = "DELETE FROM user_info WHERE id =? ";

		Connection conn = db.DbConnect();

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);

		ps.executeUpdate();
		
	}
}
