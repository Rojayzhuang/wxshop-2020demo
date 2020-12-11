package com.rojay.wxshop.service;

import com.rojay.wxshop.generate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 验全服务
 *
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年12月01日  16:38:38
 */
@Service
public class AuthService {
    private final UserService userService;
    private final VerificationCodeCheckService verificationCodeCheckService;
    //调用发验证码的接口
    private final SmsCodeService smsCodeService;

    @Autowired
    public AuthService(UserService userService,
                       VerificationCodeCheckService verificationCodeCheckService,
                       SmsCodeService smsCodeService) {
        this.userService = userService;
        this.verificationCodeCheckService = verificationCodeCheckService;
        this.smsCodeService = smsCodeService;
    }

    public void sendVerificationCode(String tel) {
        userService.createUserIfNotExist(tel);
        String correctCode = smsCodeService.sendSmsCode(tel);
        verificationCodeCheckService.addCode(tel, correctCode);
    }
}
