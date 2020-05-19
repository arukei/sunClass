package kr.co.mybatis.board.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.mybatis.board.dto.Board;

public interface BoardDao {
	public List<Board> getBoardList()throws Exception;
	public Board getBoardContent(Board boardVo)throws Exception;
	public void writeBoard(Board boardVo)throws Exception;
	public List<Board> getMyBoardList(Board boardVo)throws Exception;
	public Board modBoardContent(Board boardVo)throws Exception;
	public void modBoardContentAcion(Board boardVo)throws Exception;
	
}
