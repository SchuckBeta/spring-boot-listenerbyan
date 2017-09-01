package com.example.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息
 * @author chenh
 *
 */
public class Message implements Serializable{
	private String title;
	private String msg;
	private Date time;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
