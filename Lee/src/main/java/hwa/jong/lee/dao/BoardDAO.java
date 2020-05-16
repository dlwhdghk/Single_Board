package hwa.jong.lee.dao;

import java.util.List;

import hwa.jong.lee.dto.BoardVO;
import hwa.jong.lee.dto.CommentVO;

public interface BoardDAO {
	// 게시글 전체 목록 
	public List<BoardVO> list() throws Exception;
	// 게시글 작성 
	public void insert(BoardVO vo) throws Exception;
	// 게시글 상세보기
	public BoardVO read(int bno) throws Exception;
	// 게시글 조회수
	public void viewCnt(int bno) throws Exception;
	// 게시글 수정
	public void update(BoardVO vo) throws Exception;
	// 게시글 삭제
	public void delete(int bno) throws Exception;
	// 댓글 목록
	public List<CommentVO> commentList(int bno) throws Exception;
	// 댓글 작성
	public void insertComment(CommentVO vo) throws Exception;
}
