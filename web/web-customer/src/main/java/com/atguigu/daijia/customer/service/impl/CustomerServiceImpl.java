package com.atguigu.daijia.customer.service.impl;

import com.atguigu.daijia.common.execption.GuiguException;
import com.atguigu.daijia.common.result.Result;
import com.atguigu.daijia.common.result.ResultCodeEnum;
import com.atguigu.daijia.customer.client.CustomerInfoFeignClient;
import com.atguigu.daijia.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class CustomerServiceImpl implements CustomerService {

    //注入远程调用接口
    @Autowired
    private CustomerInfoFeignClient client;

    @Override
    public String login(String code) {
        //拿着code去调用远程接口，返回用户id
        Result<Long> longResult = client.login(code);

        //判断如何返回失败，返回错误提示
        Integer codeResult = longResult.getCode();
        if(codeResult != 200){
            throw new GuiguException(ResultCodeEnum.DATA_ERROR);
        }

        //获取远程调用返回用户id
        Long custimerId=longResult. getData();

        //判断用户id是否为空，为空则抛出异常
        if(custimerId == null){
            throw new GuiguException(ResultCodeEnum.DATA_ERROR);
        }

        String token

        return custimerId.toString();
    }
}
