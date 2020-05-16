package hwa.jong.lee.dao;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import hwa.jong.lee.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
 
    @Inject
    private SqlSession sqlSession;
    
    private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
    
    private static final String Namespace = "hwa.jong.lee.mappers.memberMapper";
    
    @Override
    public List<MemberVO> selectMember() throws Exception {
    	log.info("read2() 호출");
    	
        return sqlSession.selectList(Namespace+".selectMember");
    }

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		log.info("loginDao {}", vo);
		return sqlSession.selectOne(Namespace +".login", vo);
	}
	
	@Override
	public void insertId(MemberVO vo) throws Exception{
		sqlSession.insert(Namespace + ".insertId", vo);		
	}

	@Override
	public MemberVO idCheck(String id) throws Exception {
		return sqlSession.selectOne(Namespace + ".idCheck", id);
	}
 
	
}
