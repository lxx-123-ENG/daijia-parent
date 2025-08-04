package com.atguigu.daijia.customer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component  // 将该类声明为Spring组件，使其能被Spring容器自动扫描和管理
@Data       // Lombok注解，自动生成getter、setter、toString、equals和hashCode等方法
@ConfigurationProperties(prefix = "wx.miniapp")  // 绑定配置文件(如application.yml)中以wx.miniapp为前缀的属性

public class WxConfigProperties {
    private String appId;
    private String secret;
}
