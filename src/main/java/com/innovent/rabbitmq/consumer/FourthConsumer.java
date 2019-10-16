package com.innovent.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FourthConsumer
 * @Description
 * @Author klause
 * @Date 2019/10/16 10:32
 */
@Component
@RabbitListener(queues = "FOURTH_QUEUE")
public class FourthConsumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("消费者四收到消息:" + msg);
    }
}
