package hwa.jong.lee.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import hwa.jong.lee.dto.BoardVO;
import hwa.jong.lee.dto.CommentVO;
import hwa.jong.lee.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	BoardService service;
	
	@RequestMapping(value = "board", method = RequestMethod.GET)
	public String board(Locale locale, Model model) throws Exception {
		model.addAttribute("list",service.list());
		return "board";
	}
	
	// wirte 이동
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		
		
		return "write";
	}
	
	// write 작성
	@RequestMapping(value="/board/write/insert", method=RequestMethod.POST)
	public String insert(BoardVO vo) throws Exception {
		service.insert(vo);
		System.out.println(vo.getBoard_title());
		
		return "redirect:/board";
	}
	
	// 게시글 상세 보기, 게시글 조회수 증가 처
	@RequestMapping(value="/board/detail_board", method=RequestMethod.GET)
	public ModelAndView detailBoard(@RequestParam int board_number, HttpSession session, Model model) throws Exception {
		service.viewCnt(board_number, session);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("detail_board");
		
		mav.addObject("dto", service.read(board_number));
		mav.addObject("comment", service.commentList(board_number));
		
		return mav;
	}
	
	// 게시글 수정 
		@RequestMapping(value="/baord/detail_board/update", method=RequestMethod.POST)
		public String update(BoardVO vo) throws Exception {
			service.update(vo);
			
			return "redirect:/board";
		}

		// 게시글 삭제 
		@RequestMapping(value="/board/detail_board/delete", method=RequestMethod.POST)
		public String delete(int board_number) throws Exception {
			service.delete(board_number);
			
			return "redirect:/board";
		}
		
		// 댓글 작성 
		@ResponseBody
		@RequestMapping(value="/board/detail_board/commentWriter", method=RequestMethod.POST)
		public void insertComment(CommentVO vo, HttpServletRequest req) throws Exception {
			logger.info("post insertComment"); 
			service.insertComment(vo);
		
		}
		
		@RequestMapping("/board/detail_board/listJson.do")
		@ResponseBody
		public List<CommentVO> listJson(@RequestParam int bno) throws Exception{
			List<CommentVO> list  = service.commentList(bno);
			return list;
		}
		
	
}
