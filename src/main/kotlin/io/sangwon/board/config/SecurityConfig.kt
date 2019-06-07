package io.sangwon.board.config

import org.springframework.beans.factory.annotation.Configurable
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository

/**
 * Created by Sangwon Hyun on 2019-06-07.
 * bizblocks.io
 */

@Configurable
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter(){

    override fun configure(http: HttpSecurity) {
        http
                .cors() //Cross-Site Http Request를 가능하게 하는 표준 규약
                .and()
                .csrf() //CSRF(Cross Stie Request Forgery) : 사이트간 요청 위조
                .csrfTokenRepository(HttpSessionCsrfTokenRepository())
                .ignoringAntMatchers(("/graphql"))
                .and()

                .authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .anyRequest().permitAll()
                .and()

                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/user/list") // 로그인 성공후 이동할 url
                .permitAll()
                .and()

                .sessionManagement()
                .maximumSessions(1) //Session 허용 개수
                .maxSessionsPreventsLogin(true) /*
                중복로그인 불가능, 디폴트가 false, false일 경우 누군가 로그인 하면
                기존 로그인 유저는 로그아웃이 된다.
                */
    }

}