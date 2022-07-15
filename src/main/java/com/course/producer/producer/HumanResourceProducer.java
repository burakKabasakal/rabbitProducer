package com.course.producer.producer;

import com.course.producer.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HumanResourceProducer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendMessage(Employee employee) {
        rabbitTemplate.convertAndSend("x.hr","", objectMapper.writeValueAsString(employee));
    }

}
