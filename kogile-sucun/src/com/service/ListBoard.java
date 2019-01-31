package com.service;

import java.io.Serializable;

public class ListBoard implements Serializable {

	private int list_no;
	private String list_info;
	private int checked;
	private int checklist_no;
	
	public ListBoard() {
		super();
	}

	public ListBoard(int list_no, String list_info, int checked, int checklist_no) {
		super();
		this.list_no = list_no;
		this.list_info = list_info;
		this.checked = checked;
		this.checklist_no = checklist_no;
	}

	public int getList_no() {
		return list_no;
	}

	public void setList_no(int list_no) {
		this.list_no = list_no;
	}

	public String getList_info() {
		return list_info;
	}

	public void setList_info(String list_info) {
		this.list_info = list_info;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}

	public int getChecklist_no() {
		return checklist_no;
	}

	public void setChecklist_no(int checklist_no) {
		this.checklist_no = checklist_no;
	}

	@Override
	public String toString() {
		return "ListBoard [list_no=" + list_no + ", list_info=" + list_info + ", checked=" + checked + ", checklist_no="
				+ checklist_no + "]";
	}
	
	
	

	
}
