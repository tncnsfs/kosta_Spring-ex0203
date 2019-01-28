package kosta;

import org.springframework.stereotype.Repository;
//@Controller, @Service @Repository, @Conponent

public class MySQLDao implements Dao {

	@Override
	public void insertBoard() {
		System.out.println("MySQLDao insertBoard()호출");

	}

}
