package com.example.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.SerializationUtils;

import com.example.entity.Email;
import com.example.entity.Message;
import com.example.event.EmailEvent;
import com.example.event.MessageEvent;
import com.example.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public void sendEmail(Email email) {
		try {
			FileCopyUtils.copy(SerializationUtils.serialize(email), new File(Class.class.getClass().getResource("/").getPath() + "/email/"+email.getTitle()));
		} catch (IOException e) {
			throw new RuntimeException("Email 邮件服务器发生异常！"+e.getMessage());
		}
	}

	/**
	 * 同步事件监听.
	 * @param event
	 */
	@EventListener
	public void doSendEmail(EmailEvent event) {
		sendEmail((Email) event.getSource());
	}

	/**
	 * 异步事件监听.
	 * 注释@EnableAsync
	 * @param event
	 */
	@Async
	@EventListener
	public void doAsyncSendEmail(EmailEvent event) {
		sendEmail((Email) event.getSource());
	}
}
