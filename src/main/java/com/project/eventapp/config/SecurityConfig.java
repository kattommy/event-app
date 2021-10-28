package com.project.eventapp.config;

import com.project.eventapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.formLogin()
               .loginPage("/login")
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
        auth.userDetailsService(userService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
