package com.docker.app.springdocker.controller;

import com.docker.app.springdocker.entity.Orders;
import com.docker.app.springdocker.sender.OrdersMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloDocker {

    private final OrdersMessageSender ordersMessageSender;

    @Autowired
    public HalloDocker(OrdersMessageSender ordersMessageSender){
        this.ordersMessageSender = ordersMessageSender;
    }

    @PostMapping(value = "/sendmsg")
    public ResponseEntity<?> sendMessages(@RequestBody Orders orders){
        ordersMessageSender.sendOrders(orders);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @GetMapping(value = "/hello")
    public String getGreetingDocker(){
        return "Hallo Spring boot & Docker Container";
    }
}
