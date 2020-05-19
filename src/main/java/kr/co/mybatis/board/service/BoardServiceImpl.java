package kr.co.mybatis.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mybatis.board.dao.BoardDao;
import kr.co.mybatis.board.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao dao;

	@Override
	public List<Board> getBoardList() throws Exception {
		
		return dao.getBoardList();
	}

	@Override
	public Board getBoardContent(Board boardVo) throws Exception {
		return dao.getBoardContent(boardVo);
	}

	@Override
	public void writeBoard(Board boardVo) throws Exception {
		 dao.writeBoard(boardVo);
	}

	@Override
	public List<Board> getMyBoardList(Board boardVo) throws Exception {
		
		return dao.getMyBoardList(boardVo);
	}

	@Override
	public Board modBoardContent(Board boardVo) throws Exception {
		
		return dao.modBoardContent(boardVo);
	}

	@Override
	public void modBoardContentAcion(Board boardVo) throws Exception {
		dao.modBoardContentAcion(boardVo);
	}

}
