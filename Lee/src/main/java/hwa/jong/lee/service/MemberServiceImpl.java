package hwa.jong.lee.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import hwa.jong.lee.dao.MemberDAO;
import hwa.jong.lee.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
 
    @Inject
    private MemberDAO dao;
    
    private static final Logger log =
			LoggerFactory.getLogger(MemberServiceImpl.class);
    
    @Override
    public List<MemberVO> selectMember() throws Exception {
    	log.info("read1() 호출" );
    	
        return dao.selectMember();
    }

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		log.info("login {}", vo);
		return dao.login(vo);
	}
 
	@Override
	public void insertId(MemberVO vo) throws Exception{
		dao.insertId(vo);
	}

	@Override
	public MemberVO idCheck(String id) throws Exception {
		return dao.idCheck(id);
	}
}
