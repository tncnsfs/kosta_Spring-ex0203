package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SessionAspect {

	@Around("execution(public * kosta.controller.*.*exe(..))")
	public String sessionCheck(ProceedingJoinPoint joinPoint)throws Throwable{
		Object[] obj = joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest)obj[0];
		
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		
		String view = "session/session_fail";
		
		try {
			if(name == null){
				throw new Exception("no Session");
			}			
			view = (String)joinPoint.proceed();//session_exe()
			
		} catch (Exception e) {
			return view;
		}
		
		return view;
	}
}











