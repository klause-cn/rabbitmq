package com.innovent.rabbitmq.config;

import com.rabbitmq.client.impl.ChannelN;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName RabbitConfig
 * @Description
 * @Author klause
 * @Date 2019/10/16 9:56
 */
@Configuration
public class RabbitConfig {

    /**
     * 直连交换机
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        DirectExchange directExchange = new DirectExchange("DIRECT_EXCHANGE");

        Map<String, Object> argss = new HashMap<String, Object>();
        argss.put("x-message-ttl",6000); // TTL，6秒后没有被消费则被发送到DLX
        return new DirectExchange("DIRECT_EXCHANGE");
    }

    /**
     * 主题交换机
     * @return
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("TOPIC_EXCHANGE");
    }

    /**
     * 广播交换机
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("FANOUT_EXCHANGE");
    }

    //定义四个队列
    @Bean
    public Queue firstQueue(){
        return new Queue("FIRST_QUEUE");
    }

    @Bean
    public Queue secondQueue(){
        return new Queue("SECOND_QUEUE");
    }

    @Bean
    public Queue thirdQueue(){
        return new Queue("THIRD_QUEUE");
    }

    @Bean
    public Queue fourthQueue(){
        return new Queue("FOURTH_QUEUE");
    }

    @Bean
    public Binding bindFirst(@Qualifier("firstQueue") Queue queue,
                             @Qualifier("directExchange") DirectExchange directExchange){

        return BindingBuilder.bind(queue).to(directExchange).with("innovent.test");
    }

    @Bean
    public Binding bindSecond(@Qualifier("secondQueue") Queue queue,
                              @Qualifier("topicExchange") TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("*.innovent.*");
    }

    @Bean
    public Binding bingThird(@Qualifier("thirdQueue") Queue queue,
                             @Qualifier("fanoutExchange") FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding bingFourth(@Qualifier("fourthQueue") Queue queue,
                             @Qualifier("fanoutExchange") FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}
