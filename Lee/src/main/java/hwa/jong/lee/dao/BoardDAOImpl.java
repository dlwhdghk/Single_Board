package hwa.jong.lee.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import hwa.jong.lee.dto.BoardVO;
import hwa.jong.lee.dto.CommentVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "hwa.jong.lee.mappers.boardMapper";
	
	@Override
	public List<BoardVO> list() throws Exception {
		
		return sqlSession.selectList(Namespace + ".list");
	}

	@Override
	public void insert(BoardVO vo) throws Exception {
		sqlSession.insert(Namespace + ".insert", vo);
		
	}
	
	@Override
	public BoardVO read(int bno) throws Exception{
		return sqlSession.selectOne(Namespace+".detailBoard", bno);
	}
	
	@Override
	public void viewCnt(int bno) throws Exception{
		sqlSession.update(Namespace+".viewCnt", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		sqlSession.update(Namespace+".update", vo);
		
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete(Namespace+".delete", bno);
		
	}
	
	@Override
	public List<CommentVO> commentList(int bno) throws Exception{
		return sqlSession.selectList(Namespace + ".commentList", bno);
	}

	@Override
	public void insertComment(CommentVO vo) throws Exception {
		sqlSession.insert(Namespace + ".insertComment", vo);
	}

}
