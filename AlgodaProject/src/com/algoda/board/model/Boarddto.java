package com.algoda.board.model;

import java.sql.Date;

public class Boarddto {

	private String title ;
	
	private String writer;
	private String update_pwd;  
	private String content;
	private Date postdate;
	private int   visitcount;
	private String   ID;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getUpdate_pwd() {
		return update_pwd;
	}
	public void setUpdate_pwd(String update_pwd) {
		this.update_pwd = update_pwd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public int getVisitcount() {
		return visitcount;
	}
	public void setVisitcount(int visitcount) {
		this.visitcount = visitcount;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}  
	
	
	
}
