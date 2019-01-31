package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
// 샘플의 파라미터를 수집함 
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	// 메소드 호출 
	@RequestMapping("")
	public void basic(){

		log.info("basic...");
	}
	
	// GET, POST 방식으로 파라미터로 전달하는 방식 
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet(){
		
		log.info("basic get....");
	}
	
	
	// 파라미터가 없이 메소드를 호출 
	@GetMapping("/basicOnlyGet")
	public void basicGet2(){
		
		log.info("basic get only get...");
	}
	
	
	
	// 파라미터 타입  값을 넣어서 전달할때 
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto){
		
		log.info("" + dto);
		
		return "ex01";
	}
	
	
	// 타입변환 과 파라미터 수집 
	// 파라미터 타입을 정의 할때 사용하는 방식 
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,
			@RequestParam("age") int age){
			
		log.info("name: " + name);
		log.info("age :" + age);
				return "ex02";
	}
	
	
	// 리스트를 처리할 경우 
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids){
		
		log.info("ids: " + ids);
		return "ex02List";
		
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids){
		
		log.info("array ids: " + Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list){
		
		log.info("list dtos: " + list);
		
		return "ex02Bean";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}

	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo){
		log.info("todo: " + todo);
		
		return "ex03";
	}
	
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page){
		log.info("dto: " + dto);
		log.info("page :" + page );
		
		return "/sample/ex04";
	}
	
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06(){
		log.info("/ex06...");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
}
