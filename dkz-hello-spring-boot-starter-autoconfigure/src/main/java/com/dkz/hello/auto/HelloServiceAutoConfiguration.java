package com.dkz.hello.auto;

import com.dkz.hello.beans.HelloProperties;
import com.dkz.hello.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 这是一个配置类
@ConditionalOnMissingBean(HelloService.class) // 容器中没有 才放这个bean , 增加灵活性 用户可以使用自己的覆盖默认的
@EnableConfigurationProperties(HelloProperties.class)// 默认将这个文件放到容器当中 // 就会自动和 ConfigurationProperties 绑定 , 之前的那个错误也不会有了
public class HelloServiceAutoConfiguration {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
