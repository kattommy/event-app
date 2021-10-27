package com.project.eventapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.formLogin()
               .loginPage("/")
               .and()
               .logout()
               .logoutSuccessUrl("/")
               .and()
               .authorizeRequests()
               .antMatchers("/*").permitAll()
               .antMatchers("/addEvent")
               .hasRole("ADMIN")
               .anyRequest()
               .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password("pass1")
                .roles("USER")
                .and()
                .withUser("user2")
                .password("pass2")
                .roles("USER")
                .and()
                .withUser("admin1")
                .password("pass1")
                .roles("ADMIN");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
