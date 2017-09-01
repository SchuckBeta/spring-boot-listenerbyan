package com.example.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.SerializationUtils;

import com.example.entity.Order;
import com.example.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public void buy(Order order) {
		try {
			FileCopyUtils.copy(SerializationUtils.serialize(order), new File(Class.class.getClass().getResource("/").getPath() + "/order/" + order.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
