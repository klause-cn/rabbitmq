package com.innovent.rabbitmq.producer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyProducer
 * @Description
 * @Author klause
 * @Date 2019/10/16 10:37
 */
@Component
public class MyProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send(){
        rabbitTemplate.convertAndSend("DIRECT_EXCHANGE", "innovent.test",
                "this is a direct msg");

        rabbitTemplate.convertAndSend("TOPIC_EXCHANGE", "kaifa.innovent.IT",
                "this is a topic msg");

        rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "",
                "这是一条广播消息");
    }
}
