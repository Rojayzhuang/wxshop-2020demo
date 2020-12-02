package com.rojay.wxshop.service;

/**
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年12月01日  16:23:00
 */
public interface SmsCodeService {
    /**
     * 向一个指定手机号码发送验证码，返回正确答案
     * @param tel 目标手机号
     * @return 正确答案
     */
    String sendSmsCode(String tel);

}
