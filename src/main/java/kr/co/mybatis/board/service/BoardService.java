package kr.co.mybatis.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.mybatis.board.dto.Board;
import kr.co.mybatis.user.dto.User;

public interface BoardService {
	
	public List<Board> getBoardList()throws Exception;
	public Board getBoardContent(Board boardVo)throws Exception;
	public void writeBoard(Board boardVo)throws Exception;
	public List<Board> getMyBoardList(Board boardVo)throws Exception;
	public Board modBoardContent(Board boardVo)throws Exception;
	public void modBoardContentAcion(Board boardVo)throws Exception;
	
	

}
