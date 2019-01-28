package kosta.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BoardValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		if(Board.class.isAssignableFrom(arg0)){
			return true;
		}
		
		return false;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		Board board = (Board)arg0;
		
		if(board.getTitle() == null || board.getTitle().length() == 0){
			errors.rejectValue("title", "require", "제목을 입력하세요.");
		}
	}

}







