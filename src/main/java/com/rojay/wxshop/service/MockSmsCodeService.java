package com.rojay.wxshop.service;

import org.springframework.stereotype.Service;

/**
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年12月01日  16:24:01
 */
@Service
public class MockSmsCodeService implements SmsCodeService {

    @Override
    public String sendSmsCode(String  tel) {
        return "00000";
    }

}
