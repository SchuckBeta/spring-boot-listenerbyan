package com.example.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 * @author chenh
 *
 */
public class Order implements Serializable{
	private String name;
	private String persion;
	private Date time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPersion() {
		return persion;
	}
	public void setPersion(String persion) {
		this.persion = persion;
	}
}
