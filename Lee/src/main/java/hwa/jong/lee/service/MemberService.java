package hwa.jong.lee.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import hwa.jong.lee.dto.MemberVO;

public interface MemberService {
    // 전체 검색
    public List<MemberVO> selectMember() throws Exception;
    
    // 로그인
    public MemberVO login(MemberVO vo) throws Exception;
    
    // 회원가입
    public void insertId(MemberVO vo) throws Exception;
    
    // 아이디 중복 체크
    public MemberVO idCheck(String id) throws Exception;
}

