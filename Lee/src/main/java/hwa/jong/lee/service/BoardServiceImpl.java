package hwa.jong.lee.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import hwa.jong.lee.dao.BoardDAO;
import hwa.jong.lee.dto.BoardVO;
import hwa.jong.lee.dto.CommentVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardDAO dao;
	
	@Override
	public List<BoardVO> list() throws Exception {
		return dao.list();
	}

	@Override
	public void insert(BoardVO vo) throws Exception {
		dao.insert(vo);
		
	}
	

	@Override
	public BoardVO read(int bno) throws Exception {		
		return dao.read(bno);
	}
	
	@Override
	public void viewCnt(int bno, HttpSession session)throws Exception{
		long update_time = 0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time = (long)session.getAttribute("update_time_"+bno);
		}
		
		long current_time = System.currentTimeMillis();
		
		if(current_time - update_time > 5*1000) {
			dao.viewCnt(bno);
			session.setAttribute("update_time_" + bno, current_time);
		}
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		dao.update(vo);
		
	}

	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
		
	}

	@Override
	public List<CommentVO> commentList(int bno) throws Exception {
		return dao.commentList(bno);
	}

	@Override
	public void insertComment(CommentVO vo) throws Exception {
		dao.insertComment(vo);
		
	}


}
