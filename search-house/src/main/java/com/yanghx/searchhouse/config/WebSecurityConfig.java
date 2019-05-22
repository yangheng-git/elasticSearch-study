package com.yanghx.searchhouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * security配置类
 * <p>
 * WebSecurityConfigurerAdapter security配置适配器
 *
 * @author yangHX
 * createTime  2019/5/22 9:34
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String SYS_ROLE_ADMIN = "ADMIN";
    private static final String SYS_ROLE_USER = "USER";


    /**
     * http权限控制
     *
     * @param http http
     * @throws Exception 异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/login").permitAll() //管理员登陆入口
                .antMatchers("/static/**").permitAll()//静态资源
                .antMatchers("/user/login").permitAll() //用户登陆入口
                .antMatchers("/admin/**").hasRole(SYS_ROLE_ADMIN)
                .antMatchers("user/**").hasAnyRole(SYS_ROLE_ADMIN, SYS_ROLE_USER)
                .antMatchers("/api/user/**").hasAnyRole(SYS_ROLE_ADMIN, SYS_ROLE_USER)
                .and()
                .formLogin()
                .loginProcessingUrl("/login") //配置角色登陆处理入口
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout/page")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
        //跨域
        http.csrf().disable();
        //frame页面的地址只能为同源域名下的页面
        //https://www.jianshu.com/p/9ec724f4e3ae
        http.headers().frameOptions().sameOrigin();
    }




}
