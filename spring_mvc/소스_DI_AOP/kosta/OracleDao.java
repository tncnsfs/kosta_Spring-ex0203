package kosta;

import org.springframework.stereotype.Repository;


public class OracleDao implements Dao {

	@Override
	public void insertBoard() {
		System.out.println("OracleDao insertBoard()호출");
	}

}
