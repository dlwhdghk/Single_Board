package hwa.jong.lee.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hwa.jong.lee.dto.MemberVO;
import hwa.jong.lee.service.MemberService;

@Controller
public class UserController {
	private static final Logger log =
			LoggerFactory.getLogger(UserController.class);
	
	@Autowired private MemberService userService;
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void signin(String target, Model model) {
		log.info("sigin(target={}) GET 호출", target);
		
		model.addAttribute("msg", "사용자 id 혹은 패스워드가 일치하지 않습니다.");
		
		if (target != null && !target.equals("")) {
			model.addAttribute("target", target);
			// 로그인 성공 후에 이동할 페이지를 저장해둠
		}
	} // end signin()

	@RequestMapping(value = "sign", method = RequestMethod.POST)
	public String signin(MemberVO vo, Model model) throws Exception {
		log.info("signin({})", vo.getId());
		
		// UserService의 메소드를 사용해서 로그인 처리(성공/실패)
		MemberVO signinUser = userService.login(vo);
		log.info("signinUser: {}", signinUser);
		
		// model 객체에 로그인 정보(signinId)를 attribute로 추가
		model.addAttribute("member", signinUser);
		
		
		return "home";
		
	} // end signin(user)
	
} // end class UserController













