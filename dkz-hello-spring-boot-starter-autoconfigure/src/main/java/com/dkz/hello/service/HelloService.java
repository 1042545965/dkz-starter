package com.dkz.hello.service;

import com.dkz.hello.beans.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 不确定是不是要放到容器当中 ， 通过一个自动配置类来配置
 */
public class HelloService {


    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String userName){
        return helloProperties.getPrefix() + userName + helloProperties.getSuffix();
    }

}
