package com.example.demo.board;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "BOARD")
public class BoardDto {
	@Id
	private int boardId;
	private String writer;
	private String title;
	private String content;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp regDate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp updateDate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp deleteDate;
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public Timestamp getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Timestamp deleteDate) {
		this.deleteDate = deleteDate;
	} 
}
