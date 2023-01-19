package com.example.tenderflex.config;


import com.example.tenderflex.controller.filter.CustomAuthenticationFilter;
import com.example.tenderflex.repository.UserRepository;
import com.example.tenderflex.service.UserService;
import com.example.tenderflex.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public UserService userService( UserRepository userRepository, PasswordEncoder passwordEncoder){
        return new UserServiceImpl(userRepository, passwordEncoder);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Autowired
    public AuthenticationManager authenticationManager(HttpSecurity http, UserService userService)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    @Autowired
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager, UserService userService) throws Exception {
       return http.userDetailsService(userService).cors().and().csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeHttpRequests().anyRequest().permitAll()
               .and().addFilter(new CustomAuthenticationFilter(authenticationManager))
               .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web)->{
        };
    }
}