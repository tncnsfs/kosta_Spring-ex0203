package kosta;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class Main {
	
	public static void main(String[] args) {
		Resource resource = 
				new ClassPathResource("applicationContext.xml"); // xml 객체 생성 
		
		// 스프링 컨테이너를 생성했다. 객체가져오기 
//		 		<bean id="oracleDao" class="kosta.OracleDao"/>
//				<bean id="service" class="kosta.WriteService">

//		BeanFactory factory = 
//				new GenericXmlApplicationContext(resource); // 명시적 (스프링컨테이너)
		
		/*ApplicationContext factory = 
				new GenericXmlApplicationContext(resource);*/ // 자동적(스프링컨테이너)
		
		// 이것이 스프링컨테이너임 // 자바에서 메서드로 설정한것 (스프링컨테이너)
/*		ApplicationContext factory = 
				new AnnotationConfigApplicationContext(Factory.class);*/
		
		String[] cofig = {
				"applicationContext.xml",
				"commonConcern.xml"
		};
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext(cofig);
		
		// xml 에서 id 명 service , java 클래스는 메소드 명 service 
		// service 객체임  
		Service service = (Service)factory.getBean("service");
		service.insert();	// 스프링 컨테이너에서 DI가 수행 , DAO가 수행 
		
	}
}



