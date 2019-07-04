package org.akj.springboot.stream.rabbit;

import org.akj.springboot.stream.rabbit.model.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@SpringBootApplication
@EnableBinding(Sink.class)
public class Application {
	// 监听 binding 为 Sink.INPUT 的消息
	@StreamListener(Sink.INPUT)
	public void input(Message<Order> message) {
		Order order = message.getPayload();
		System.out.println("----------Order details---------");
		System.out.println("order id: " + order.getId());
		System.out.println("order summary: " + order.getSummary());
		System.out.println("order payment: " + order.getAmount() + " " + order.getCurrency());
		System.out.println("order created date: " + order.getCreateDate());
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
