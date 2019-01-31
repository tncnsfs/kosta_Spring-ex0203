package kosta;

import org.springframework.stereotype.Repository;

//@Controller, @Service @Repository, @Conponent 선언하여 표시한것을 스캔함 , 자동으로 객체가 생성  
//@Repository
public class MySql implements Dao {

	@Override
	public void insertBoard() {
		// TODO Auto-generated method stub
		System.out.println("MySql insertBoard()호출");

	}
}
