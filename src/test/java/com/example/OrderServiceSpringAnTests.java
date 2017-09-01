package com.example;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.Email;
import com.example.entity.Message;
import com.example.entity.Order;
import com.example.event.EmailEvent;
import com.example.event.MessageEvent;
import com.example.service.impl.OrderServiceImpl;

/**
 * 需要配置数据源、和SimpleApplicationEventMulticaster 时间和广播器
 * Async
 * EventListener
 * @author chenh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceSpringAnTests implements ApplicationContextAware{
	private ApplicationContext applicationContext;

	@Autowired
	OrderServiceImpl orderService;


	@Test
	public void buyAndSend() {
		Order order = new Order();
		order.setName("机票订单Order");
		order.setPersion("张三");
		order.setTime(new Date());
		orderService.buy(order);

		Message message = new Message();
		message.setTitle("机票订单Message");
		message.setMsg("机票订单Message已经成功");
		message.setTime(new Date());
		applicationContext.publishEvent(new MessageEvent(message));

		Email email = new Email();
		email.setTitle("机票订单Email");
		email.setMsg("机票订单Email已经成功");
		email.setTime(new Date());
		email.setAddr("111111@qq.com");
		applicationContext.publishEvent(new EmailEvent(email));
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}