package hwa.jong.lee.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hwa.jong.lee.dao.MemberDAO;
import hwa.jong.lee.dto.MemberVO;
import hwa.jong.lee.service.MemberService;
import jdk.internal.org.jline.utils.Log;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
    
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Inject
    MemberService memberService;
     
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) throws Exception{
    	
        logger.info("home");       
        
        return "home";
    }
    
    
    
    // 로그인 처리
    @RequestMapping(value = "login", method= RequestMethod.POST)
    public String login(String target, MemberVO vo, Model model) throws Exception {
    	logger.info("post login");        	
		
		if (target != null && !target.equals("")) {
			model.addAttribute("target", target);
			// 로그인 성공 후에 이동할 페이지를 저장해둠
		}
    	
    	MemberVO login = memberService.login(vo);
    
    	
    	if(login != null) {
    		logger.info("controller vo : {}", login.getId());        	
        	model.addAttribute("member", login);
    	}else {
    		model.addAttribute("msg", false);
    	}    	
    	return "home";
    	
    }    	
    
    // 로그아웃 처리
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) throws Exception {
     logger.info("get logout");
     
     session.invalidate();
       
     return "redirect:/";
    }
  
    // 회원 가입 페이지  
    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
	public String signUp(Locale locale, Model model) {
		
    	
		return "/sign_up";
	}
    
    // 회원 가입 처리 
    @RequestMapping(value = "/sign_up/insertId", method = RequestMethod.POST)
    public String insertId(MemberVO vo) throws Exception{
    	memberService.insertId(vo);
    	return "redirect:/";
    }
    
 // 회원 확인
    @ResponseBody
    @RequestMapping(value = "/sign_up/idCheck", method = RequestMethod.POST)
    public int postIdCheck(HttpServletRequest req) throws Exception {
     logger.info("post idCheck");
     
     String id = req.getParameter("id");     
     MemberVO idCheck =  memberService.idCheck(id);
     
     int result = 0;
     
     if(idCheck != null) {
      result = 1;
     } 
     
     return result;
    }
    
}



