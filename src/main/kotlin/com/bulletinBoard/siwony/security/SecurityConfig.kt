package com.bulletinBoard.siwony.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy


@Configuration
@EnableWebSecurity(debug = true)
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.cors().disable() // cors 제거

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT인증방식 사용할 예정 이므로 STATELESS

        http.authorizeRequests()
            .antMatchers("/v1/hello").permitAll()
    }

    override fun configure(web: WebSecurity) {
        // Allow swagger to be accessed without authentication
        web.ignoring().antMatchers("/v2/api-docs") //
            .antMatchers("/swagger-resources/**") //
            .antMatchers("/swagger-ui.html") //
            .antMatchers("/configuration/**") //
            .antMatchers("/webjars/**") //
            .antMatchers("/public") // Un-secure H2 Database (for testing purposes, H2 console shouldn't be unprotected in production)
            .antMatchers("/h2-console/**/**")
    }
}