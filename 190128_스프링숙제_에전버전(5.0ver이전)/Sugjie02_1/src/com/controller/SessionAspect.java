package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SessionAspect {

	
	// 자동으로 세션체크를 하겠다고 설정 -> 지정 패키지안에 
	@Around("execution(public * com.controller.*.*exe(..))")
	// SessionController.java . reqeust 파라미터를 불러옴 ProceedingJoinPoint
	public String sessionCheck(ProceedingJoinPoint joinPoint)throws Throwable{
		// 배열 형식으로 파라미터를 가져옴 object 방식으로 
		Object[] obj =  joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest)obj[0];
		
		// request 에서 getSession 하면 session 을 얻어올수 있음 
		HttpSession session = request.getSession();
		// session , name 이라는 이름으로 값을 가지고 있는것 불러오기 
		String name = (String)session.getAttribute("name");
		
		String view = "session/session_fail";
		
		try {
			// 세션있을때는 if 문 뛰어넘기 
			if(name == null){
				throw new Exception("no Session");
			}
			
			// proceed()호출은 ,, aspect 의 공통관심사항이 적용대서 지금 호출안됨,,, 
			// 먼저  around 실행 ,,
			// session_exe()메소드 호출과 같음
			// success.jsp 가 리턴됨 
			view = (String)joinPoint.proceed();  
			// around 는 핵심사항을 기준으로 이전/이후 실행 @Around
			
		} catch (Exception e) {
			// 실패시 session_fail.jsp 
			return view; 
		}
		// 성공시 session_success.jsp 
		return view;
	}
	
}




