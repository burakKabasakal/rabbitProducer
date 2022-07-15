package com.course.producer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class RabbitProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private int counter;

    public void sendHello(String name){
        rabbitTemplate.convertAndSend("course.hello","Hello"+name);
    }

    @Scheduled(fixedRate = 500L)
    public void fixedRateMessage(){
        System.out.println("counter:" + ++counter);
        rabbitTemplate.convertAndSend("course.fixedrate", counter);
    }
}
