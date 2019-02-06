package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
/*	@GetMapping("/list")
	public void list(Model model){
		log.info("list");
		model.addAttribute("list", service.getList(cri));
	}*/
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model){
		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
		
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
	public void get(@RequestParam("bno") Long bno, Model model){
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
		
		}
		
/*	// 수정처리와 테스트
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr){
		log.info("modify : " + board );
		
		
		if(service.modify(board)){
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
		
	}*/
	
	// 삭제처리와 테스트
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr){
		log.info("remove..." + bno);
		
		if(service.remove(bno)){
			rttr.addFlashAttribute("result", "success");
		}
		
		
		return "redirect:/board/list";
	}


}
