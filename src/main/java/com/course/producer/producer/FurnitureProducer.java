package com.course.producer.producer;

import com.course.producer.entity.Furniture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FurnitureProducer {

    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(Furniture furniture) throws JsonProcessingException {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("color",furniture.getColor());
        messageProperties.setHeader("material",furniture.getMaterial());

        Message message = new Message(objectMapper.writeValueAsBytes(furniture),messageProperties);
        rabbitTemplate.convertAndSend("x.promotion","",message);
    }

}
