package com.dkz.hello.auto;

import com.dkz.hello.beans.HelloProperties;
import com.dkz.hello.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration // 这是一个配置类
@EnableConfigurationProperties(HelloProperties.class)// 默认将这个文件放到容器当中 // 就会自动和 ConfigurationProperties 绑定 , 之前的那个错误也不会有了
public class HelloServiceAutoConfiguration {

    /**
     * 将这个注解放到方法上 ， 那么 这个配置类的绑定是无论如何都会被加载到容器中的 ， 为了方便我们使用自己的 HelloService 的时候能直接 使用 HelloProperties 将
     * application.properties 当中的配置参数进行绑定 。
     * 如果放在 类上 那么 HelloService 不被加载到容器中的时候 HelloProperties 也不会被加载到容器当中 ， 这样还会报错
     */
    @ConditionalOnMissingBean(HelloService.class) // 容器中没有 才放这个bean , 增加灵活性 用户可以使用自己的覆盖默认的
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
