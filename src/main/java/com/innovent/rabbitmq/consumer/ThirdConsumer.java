package com.innovent.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName ThirdConsumer
 * @Description
 * @Author klause
 * @Date 2019/10/16 10:30
 */
@Component
@RabbitListener(queues = "THIRD_QUEUE")
public class ThirdConsumer {
    @RabbitHandler
    public void process(String msg){
        System.out.println("消费者三收到消息:" + msg);
    }
}
