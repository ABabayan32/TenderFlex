package com.example.tenderflex.config;


import com.example.tenderflex.controller.filter.CustomAuthenticationFilter;
import com.example.tenderflex.controller.filter.CustomAuthorizationFilter;
import com.example.tenderflex.repository.UserRepository;
import com.example.tenderflex.service.UserService;
import com.example.tenderflex.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.tenderflex.util.Constants.LOGIN_URL;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
@RequiredArgsConstructor
public class Config {

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
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager);
        customAuthenticationFilter.setFilterProcessesUrl(LOGIN_URL);
       return http.csrf().disable()
               .sessionManagement().sessionCreationPolicy(STATELESS)
               .and().authorizeHttpRequests().requestMatchers(LOGIN_URL).permitAll().and()
               .authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/user/save/**").hasAnyAuthority("ROLE_ADMIN").and()
               .authorizeHttpRequests().anyRequest().authenticated()
               .and().addFilter(customAuthenticationFilter)
               .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
               .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web)->{
            web.ignoring().requestMatchers("/v3/api-docs/**",
                    "/configuration/ui",
                    "/swagger-resources/**",
                    "/configuration/security",
                    "/swagger-ui.html",
                    "/swagger-ui/**",
                    "/webjars/**");
        };
    }
}