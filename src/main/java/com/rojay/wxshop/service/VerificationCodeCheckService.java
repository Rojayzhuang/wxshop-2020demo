package com.rojay.wxshop.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 验全登录服务
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年12月01日  16:44:28
 */
@Service
public class VerificationCodeCheckService {
    private Map<String , String > telNumberToCorrectCode = new ConcurrentHashMap<>();

    public void addCode(String tel, String correctCode) {
        telNumberToCorrectCode.put(tel, correctCode);
    }

    public String getCorrectCode(String tel) {
        return telNumberToCorrectCode.get(tel);
    }
}
