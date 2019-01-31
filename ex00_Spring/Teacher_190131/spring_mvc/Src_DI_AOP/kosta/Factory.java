package kosta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Factory {

	@Bean
	public Dao oracleDao() {
		return new OracleDao();
	}
	
	@Bean
	public Service service() {
		return new WriteService();
	}
	
}













