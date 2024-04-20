package com.kjh.job.test;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
@Setter
public class MQListener {
    private static final String QUEUE_NAME = "a";
    private final RabbitTemplate rabbitTemplate;
    private Status status = Status.IDLE;

    public enum Status {
        ING, IDLE
    }

    @Scheduled(fixedDelay = 5000)
    public void getMessage() { if(status.equals(Status.ING)) return;
        Object message = rabbitTemplate.receiveAndConvert(QUEUE_NAME);
        if(message == null) return;
        this.setStatus(Status.ING);

        while (true){
            if(status.equals(Status.IDLE)) {
                break;
            }
        }
    }
}
