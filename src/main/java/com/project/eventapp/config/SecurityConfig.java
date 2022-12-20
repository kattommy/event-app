package com.project.eventapp.config;

//
//@Configuration
//@AllArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserService userService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//       http.formLogin()
//               .loginPage("/login")
//               .and()
//               .logout()
//               .logoutSuccessUrl("/")
//               .and()
//               .authorizeRequests()
//               .antMatchers("/*")
//               .hasRole("USER")
//               .antMatchers("/*")
//               .hasRole("ADMIN")
//               .anyRequest()
//               .authenticated();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//}
