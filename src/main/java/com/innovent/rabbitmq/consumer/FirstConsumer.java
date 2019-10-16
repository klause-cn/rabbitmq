package com.innovent.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FirstConsumer
 * @Description
 * @Author klause
 * @Date 2019/10/16 10:23
 */
@Component
@RabbitListener(queues = "FIRST_QUEUE")
public class FirstConsumer {
    @RabbitHandler
    public void process(String msg){
        System.out.println("消费者一收到消息:" + msg);
    }
}
