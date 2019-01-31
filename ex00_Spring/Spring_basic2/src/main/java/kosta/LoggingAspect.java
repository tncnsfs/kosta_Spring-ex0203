package kosta;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {

	private Log log = LogFactory.getLog(getClass());
	
	// 공통관심 메서드 
	// 언제 => advice : around() => 이전(핵심)이후
	// around 사용시 반드시 사용되는 메소드 ProceedingJoinPoint joinPoint
	public Object logging(ProceedingJoinPoint joinPoint)throws Throwable{
		
		log.info("로그시작");
		StopWatch stoWatch = new StopWatch();
		
		try {
			stoWatch.start();
			// 핵심관심사항 로직 호출 
			// proceed(); 메소드 호출되는 시점 이전과 이후로 나눔 
			Object obj = joinPoint.proceed(); // insert() 호출 
			return obj;
		} catch (Exception e) {
			throw e;
		}finally {
			stoWatch.stop();
			log.info("로그종료");
			log.info(joinPoint.getSignature().getName() + "메서드 실행시"
				+ stoWatch.getTotalTimeMillis());
		}
	}
	
}





