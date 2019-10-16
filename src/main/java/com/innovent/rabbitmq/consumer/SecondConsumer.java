package com.innovent.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName SecondConsumer
 * @Description
 * @Author klause
 * @Date 2019/10/16 10:28
 */
@Component
@RabbitListener(queues = "SECOND_QUEUE")
public class SecondConsumer {
    @RabbitHandler
    public void proce(String msg){
        System.out.println("消费者二收到消息:" + msg);
    }
}
