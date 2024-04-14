package com.kjh.job.test;

import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class MQListener {
    private static final String QUEUE_NAME = "queue";
    private Status status = Status.IDLE;


    public enum Status {
        ING, IDLE
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void getCommandMessage(Message<String> message) {
        this.setStatus(Status.ING);

        while (true){
            if(status.name().equals(Status.IDLE)) break;
        }
    }
}
