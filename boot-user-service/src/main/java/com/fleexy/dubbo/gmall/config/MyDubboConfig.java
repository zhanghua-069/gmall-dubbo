package com.fleexy.dubbo.gmall.config;

import com.alibaba.dubbo.config.*;
import com.fleexy.dubbo.gmall.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Slf4j
//@Configuration
public class MyDubboConfig {

    //<dubbo:application name="boot-user-service"></dubbo:application>
    @Bean
    public ApplicationConfig applicationConfig() {
        log.info("applicationConfig init...");
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service");
        return applicationConfig;
    }

    //<dubbo:registry protocol="zookeeper" address="127.0.0.1:2181" />
    @Bean
    public RegistryConfig registryConfig() {
        log.info("registryConfig init...");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

    // <dubbo:protocol name="dubbo" port="20882" />
    @Bean
    public ProtocolConfig protocolConfig() {
        log.info("protocolConfig init...");
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    /**
     *  <dubbo:service interface="com.atguigu.gmall.service.UserService"
     *      ref="userServiceImpl" timeout="1000" version="1.0.0">
     *      <dubbo:method name="getUserAddressList" timeout="1000"></dubbo:method>
     *  </dubbo:service>
     */
    @Bean
    public ServiceConfig<UserService> userServiceConfig(UserService userService,ProviderConfig providerConfig) {
        log.info("userServiceConfig init...");
        ServiceConfig<UserService> userServiceConfig = new ServiceConfig<>();
        userServiceConfig.setInterface(UserService.class);
        userServiceConfig.setRef(userService);
        userServiceConfig.setVersion("1.0.0");
        // 通过providerConfig配置注册中心，application等相关信息
        userServiceConfig.setProvider(providerConfig);

        //配置每一个method的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);
        //将method的设置关联到service配置中
        userServiceConfig.setMethods(Collections.singletonList(methodConfig));

        // 暴露及注册服务，否则service无法添加到注册中心
        userServiceConfig.export();
        return userServiceConfig;
    }

    //ProviderConfig
    @Bean
    public ProviderConfig providerConfig(ApplicationConfig applicationConfig,
                                         RegistryConfig registryConfig,
                                         ProtocolConfig protocolConfig) {
        ProviderConfig providerConfig = new ProviderConfig();
        // 配置服务注册必须的关键信息：application，registry，protocol
        providerConfig.setApplication(applicationConfig);
        providerConfig.setRegistry(registryConfig);
        providerConfig.setProtocol(protocolConfig);
        return providerConfig;
    }
    //MonitorConfig

}
