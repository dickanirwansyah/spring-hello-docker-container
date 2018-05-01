package com.docker.app.springdocker.listener;

import com.docker.app.springdocker.broker.ConfigRabbitmq;
import com.docker.app.springdocker.entity.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrdersMessageListener {

    static final Logger logger = LoggerFactory.getLogger(OrdersMessageListener.class);

    @RabbitListener(queues = ConfigRabbitmq.QUEUE_ORDERS)
    public void proccessOrders(Orders orders){
        logger.info("Orders Received : "+orders);
    }
}
