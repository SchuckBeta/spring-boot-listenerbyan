package com.example.event;

import org.springframework.context.ApplicationEvent;

import com.example.entity.Email;

public class EmailEvent extends ApplicationEvent{

	public EmailEvent(Email email) {
		super(email);
	}
}
