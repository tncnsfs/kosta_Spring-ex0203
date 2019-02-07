package com.service;

import java.io.Serializable;

public class Board implements Serializable {

	private int checklist_no;
	private String check_title;
	private int p_no;
	
	
	public Board() {
		super();
	}
	public Board(int checklist_no, String check_title, int p_no) {
		super();
		this.checklist_no = checklist_no;
		this.check_title = check_title;
		this.p_no = p_no;
	}
	public int getChecklist_no() {
		return checklist_no;
	}
	public void setChecklist_no(int checklist_no) {
		this.checklist_no = checklist_no;
	}
	public String getCheck_title() {
		return check_title;
	}
	public void setCheck_title(String check_title) {
		this.check_title = check_title;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	@Override
	public String toString() {
		return "Board [checklist_no=" + checklist_no + ", check_title=" + check_title + ", p_no=" + p_no + "]";
	}
	
	

	
}
