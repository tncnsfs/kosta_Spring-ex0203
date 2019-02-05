package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	
	// 전체목록
	@GetMapping("/list")
	public void list(Criteria cri, Model model){
		
		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		//model.addAttribute("pageMaker", new PageDTO(cri, 123));
		log.info("service.getList =>" + service.getList(cri));
		int total = service.getTotal(cri);
		log.info("total: " + total);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

	
	// 등록처리 
	@GetMapping("/register")
	public void register(){
		
	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr){
		
		log.info("register: " + board);
		
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	// 조회처리
	
	/*@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model){
		log.info("/get");
		model.addAttribute("board", service.get(bno));
	}
	*/
	
	// 수정처리와 테스트
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri")
			Criteria cri, Model model){
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
		
		}
		
	// 수정처리와 테스트
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr){
		log.info("modify : " + board );
				
		if(service.modify(board)){
			rttr.addFlashAttribute("result", "success");
		}
		
		// uriComponentsBuilder 클래스 사용이후 아래 내용 필요 없음 , 자동 처리해준다고 함 , Crietia에서 정의
/*		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());*/
		
		return "redirect:/board/list" + cri.getListLink();
	}
	
	// 삭제처리와 테스트
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, 
			@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr){
		log.info("remove..." + bno);
		
		if(service.remove(bno)){
			rttr.addFlashAttribute("result", "success");
		}
		
		// uriComponentsBuilder 클래스 사용이후 아래 내용 필요 없음 , 자동 처리해준다고 함 , Crietia에서 정의
/*		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());*/
		
		return "redirect:/board/list" + cri.getListLink();
	}


}
