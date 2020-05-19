package kr.co.mybatis.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mybatis.DbConn.DbConnection;
import kr.co.mybatis.board.dto.Board;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	DbConnection conn;

	@Override
	public List<Board> getBoardList() throws Exception {
		
		String sql = " select * from board ";

		PreparedStatement ps = conn.DbConnect().prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		
		List<Board> boardList = new ArrayList<Board>();
		
		while (rs.next()) {
			
			Board board = new Board();
			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("content"));
			board.setView_cnt(rs.getInt("view_cnt"));
			board.setId(rs.getString("id"));
			board.setReg_date(rs.getString("reg_date"));
			
			boardList.add(board);
		}
		
		return boardList;
	}

	@Override
	public Board getBoardContent(Board boardVo) throws Exception {
		
		String title = boardVo.getTitle();
		
		String sql = "select * from board where title = ?";
		String sql1 = "update board set view_cnt = view_cnt + 1 where title = ?";
		
		PreparedStatement ps = conn.DbConnect().prepareStatement(sql);
		PreparedStatement ps1 = conn.DbConnect().prepareStatement(sql1);
		
		ps.setString(1, title);
		ps1.setString(1, title);
		
		ps1.executeUpdate();
		
		ResultSet rs = ps.executeQuery();
		
		rs.last();
		
		Board boardContentInfo = new Board();
		
		boardContentInfo.setNo(rs.getInt("no"));
		boardContentInfo.setTitle(rs.getString("title"));
		boardContentInfo.setContent(rs.getString("content"));
		boardContentInfo.setView_cnt(rs.getInt("view_cnt"));
		boardContentInfo.setId(rs.getString("id"));
		boardContentInfo.setReg_date(rs.getString("reg_date"));
			
		return boardContentInfo;
	}

	@Override
	public void writeBoard(Board boardVo) throws Exception {

		String id = boardVo.getId();
		String title = boardVo.getTitle();
		String content = boardVo.getContent();

		String sql = "insert into board(id, title, content) values(?, ?, ?)";
		
		PreparedStatement ps = conn.DbConnect().prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, title);
		ps.setString(3, content);
		
		ps.executeUpdate();
		
	}

	@Override
	public List<Board> getMyBoardList(Board boardVo) throws Exception {
		
		String id = boardVo.getId();
		
		String sql = "select * from board where id = ?";

		PreparedStatement ps = conn.DbConnect().prepareStatement(sql);

		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		
		List<Board>MyBoardLists = new ArrayList<Board>();

		while(rs.next()) {
			Board MyBoardList = new Board();
			
			MyBoardList.setNo(rs.getInt("no"));
			MyBoardList.setTitle(rs.getString("title"));
			MyBoardList.setContent(rs.getString("content"));
			MyBoardList.setView_cnt(rs.getInt("view_cnt"));
			MyBoardList.setId(rs.getString("id"));
			MyBoardList.setReg_date(rs.getString("reg_date"));
			
			System.out.println(MyBoardList);
			
			MyBoardLists.add(MyBoardList);
		}

		return MyBoardLists;
	}

	@Override
	public Board modBoardContent(Board boardVo) throws Exception {
		int no = boardVo.getNo();
		
		String sql = "select * from board where no = ?";

		PreparedStatement ps = conn.DbConnect().prepareStatement(sql);

		ps.setInt(1, no);

		ResultSet rs = ps.executeQuery();
		
		Board modBoardContent = new Board();

		rs.last();
			
			modBoardContent.setNo(rs.getInt("no"));
			modBoardContent.setTitle(rs.getString("title"));
			modBoardContent.setContent(rs.getString("content"));
			modBoardContent.setView_cnt(rs.getInt("view_cnt"));
			modBoardContent.setId(rs.getString("id"));
			modBoardContent.setReg_date(rs.getString("reg_date"));
			

		return modBoardContent;

	}

	@Override
	public void modBoardContentAcion(Board boardVo) throws Exception {
		
		String title = boardVo.getTitle();
		String content = boardVo.getContent();
		int no = boardVo.getNo();

		// 회원정보수정페이지에서 넘겨받은 정보를 DB에 업데이트
		String sql = "update board set title = ? , content = ? where no = ? ";

		PreparedStatement ps = conn.DbConnect().prepareStatement(sql);

		ps.setString(1, title);
		ps.setString(2, content);
		ps.setInt(3, no);

		ps.executeUpdate();

	}

}
