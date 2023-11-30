package com.spring.ust.websecurity.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;



@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfiguration  extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    
        http.authorizeRequests().antMatchers("/api/v1/issue-book").permitAll().anyRequest()
        .authenticated().and().exceptionHandling()
        .authenticationEntryPoint( new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    }
    


    
}
