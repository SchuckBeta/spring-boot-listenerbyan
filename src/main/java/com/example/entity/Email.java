package com.example.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮件
 * @author chenh
 *
 */
public class Email implements Serializable{
	private String title;
	private String msg;
	private Date time;
	private String addr;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
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
