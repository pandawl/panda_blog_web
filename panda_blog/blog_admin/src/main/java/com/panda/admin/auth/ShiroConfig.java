package com.panda.admin.auth;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @Auther: wl
 * @Date: 2019/11/14 11:46
 * @Description:
 */
@Configuration
@Slf4j
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        log.info("------------------shiro filter-----------------------");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置 securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 在 Shiro过滤器链上加入 JWTFilter
      //  LinkedHashMap<String, Filter> filters = new LinkedHashMap<>();
        /**
         * anon:无需认证
         * authc:必须认证才能访问
         * user:使用remeberme功能可以直接访问
         *perms:该资源必须得到资源权限才能访问
         * role:得到角色权限才能访问
         */
        LinkedHashMap<String, String> filters = new LinkedHashMap<>();
        //拦截其他所以接口
        filters.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filters);

        return shiroFilterFactoryBean;


    }

    /**
     * 配置安全管理器
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }


    public ShiroRealm shiroRealm(){
        return new ShiroRealm();
    }
}
