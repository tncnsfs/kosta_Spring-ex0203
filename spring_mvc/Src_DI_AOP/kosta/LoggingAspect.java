package kosta;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {

	private Log log = LogFactory.getLog(getClass());
	
	//공통관심 메서드
	//언제 => advice : around() => 이전 (핵심) 이후

	public Object logging(ProceedingJoinPoint joinPoint)throws Throwable{
		log.info("로그시작");
		StopWatch stopWatch = new StopWatch();
		
		try {
			stopWatch.start();
			
			//핵심관시로직 호출
			Object obj = joinPoint.proceed();// insert()호출
			return obj;
			
		} catch (Exception e) {
			throw e;
		}finally {
			stopWatch.stop();
			log.info("로그종료");
			log.info(joinPoint.getSignature().getName() + " 메서드 실행시 "
							+ stopWatch.getTotalTimeMillis());
		}
		
	}
	
	
}










