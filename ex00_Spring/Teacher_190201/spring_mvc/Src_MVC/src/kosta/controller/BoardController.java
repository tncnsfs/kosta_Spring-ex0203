package kosta.controller;

import java.io.File;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kosta.model.Board;
import kosta.model.BoardDao;
import kosta.model.BoardValidator;

@Controller
public class BoardController {
	private BoardDao dao;
	private String uploadDir = "J:/upload";
	
	@Autowired
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value="/board_insert", method=RequestMethod.GET)
	public String insertForm(@ModelAttribute("boardCommand") Board board,Model model){
		model.addAttribute("title", "글쓰기2");
		return "insert_form";
	}
	
	@RequestMapping(value="/board_insert", method=RequestMethod.POST)
	public String board_insert(@ModelAttribute("boardCommand") @Valid Board board, BindingResult errors){
		
		if(errors.hasErrors()){
			System.out.println("에러 발생");
			return "insert_form";
		}
		
		MultipartFile mutipartFile = board.getUploadFile();
		if(mutipartFile != null){
			String filename = mutipartFile.getOriginalFilename();
			board.setFname(filename);
			
			try {
				mutipartFile.transferTo(new File(uploadDir, filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dao.insert(board);
		
		return "redirect:board_list";
	}
	
	@RequestMapping("/board_list")
	public String board_list(Model model){
		List<Board> list = dao.listBoard();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/board_detail{seq}")
	public String board_detail(@PathVariable int seq, Model model){
		model.addAttribute("board", dao.getBoard(seq));
		return "detail";
	}
	
	@RequestMapping("/board_download")
	public String board_download(@RequestParam("fname") String filename, 
			Model model)throws Exception{
		File file = new File(uploadDir, filename);
		model.addAttribute("downloadFile", file);
		
		return "downloadView";
	}
	
	/*@InitBinder
	protected void InitBinder(WebDataBinder binder){
		binder.setValidator(new BoardValidator());
	}*/

}







