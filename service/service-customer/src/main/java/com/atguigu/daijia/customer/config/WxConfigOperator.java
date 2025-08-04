package com.atguigu.daijia.customer.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * 微信小程序服务配置类
 * 用于创建和配置微信小程序服务实例
 */
public class WxConfigOperator {

    @Autowired  // 自动注入微信配置属性
    private WxConfigProperties wxConfigProperties;

    /**
     * 创建微信小程序服务Bean
     * @return 配置好的微信小程序服务实例
     */
    @Bean  // 声明该方法返回的对象由Spring容器管理
    public WxMaService wxMaService(){
        // 创建微信小程序默认配置实现
        WxMaDefaultConfigImpl wxMaConfig = new WxMaDefaultConfigImpl();
        // 设置小程序ID和密钥(从配置属性获取)
        wxMaConfig.setAppid(wxConfigProperties.getAppId());
        wxMaConfig.setSecret(wxConfigProperties.getSecret());

        // 创建微信小程序服务实例
        WxMaService service = new WxMaServiceImpl();
        // 为服务实例设置配置
        service.setWxMaConfig(wxMaConfig);
        return service;
    }
}

