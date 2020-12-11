package com.rojay.wxshop.service;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

/**
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年12月07日  18:01:31
 */
@Service
public class ShiroRealm extends AuthorizingRealm {

    private final VerificationCodeCheckService verificationCodeCheckService;

    public ShiroRealm(VerificationCodeCheckService verificationCodeCheckService) {
        this.verificationCodeCheckService = verificationCodeCheckService;
        /**
         *
         * @param token 用户提交的身份信息
         * @param info  用户真正的身份信息
         * @return
         */
        this.setCredentialsMatcher((token, info) -> new String((char[])token.getCredentials()).equals(info.getCredentials()));
    }

    /**
     * 验证是否有权限访问该资源
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 验证身份是否匹配
     * @param token 外界用户提供的token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String tel = (String) token.getPrincipal();
        String correctCode = verificationCodeCheckService.getCorrectCode(tel);

        return new SimpleAuthenticationInfo(tel, correctCode, getName());
    }

}
