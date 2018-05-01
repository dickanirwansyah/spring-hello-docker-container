package com.docker.app.springdocker.sender;

import com.docker.app.springdocker.broker.ConfigRabbitmq;
import com.docker.app.springdocker.entity.Orders;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersMessageSender {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public OrdersMessageSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper){
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendOrders(Orders orders){
        this.rabbitTemplate.convertAndSend(ConfigRabbitmq.QUEUE_ORDERS, orders);
    }
}
