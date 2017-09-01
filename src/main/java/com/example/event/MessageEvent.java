package com.example.event;

import org.springframework.context.ApplicationEvent;

import com.example.entity.Message;

public class MessageEvent extends ApplicationEvent {

	public MessageEvent(Message message) {
		super(message);
	}

}
