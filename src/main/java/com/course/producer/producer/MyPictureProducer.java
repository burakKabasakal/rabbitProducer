package com.course.producer.producer;

import com.course.producer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPictureProducer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendMessage(Picture picture) {
        rabbitTemplate.convertAndSend("x.mypicture", picture.getType(), objectMapper.writeValueAsBytes(picture));

    }

}
