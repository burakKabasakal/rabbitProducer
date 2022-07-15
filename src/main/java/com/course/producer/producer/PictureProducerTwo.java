package com.course.producer.producer;

import com.course.producer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PictureProducerTwo {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendMessage(Picture picture) {

      StringBuilder sb = new StringBuilder();
      /***
       * 1st word is picture source
       * 2nd word is based on picture size
       * 3rd word is picture type
       */
      sb.append(picture.getSource())
              .append(".")
              .append(picture.getSize()>4000L ? "large":"small")
              .append(".")
              .append(picture.getType());

        rabbitTemplate.convertAndSend("x.picture2", sb.toString(), objectMapper.writeValueAsBytes(picture));
    }

}
