package com.rojay.wxshop.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Shiro登录的配置文件
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年12月01日  11:36:30
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String ,String > pattern = new HashMap<>();
        pattern.put("/api/code", "anon");
        pattern.put("/api/login", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(pattern);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建核心securityManager
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //限制安全行为在某个确定的域中进行
        //securityManager.setRealm();

        //缓存管理器，判断是否为同一用户，后期可以换成分布式的
        securityManager.setCacheManager(new MemoryConstrainedCacheManager());
        //默认情况下在cookie中进行session的设置
        securityManager.setSessionManager(new DefaultSessionManager());
        return securityManager;
    }

    public static class ShiroRealm extends AuthorizingRealm {

        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
            return null;
        }

        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
            return null;
        }
    }
}
