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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.example.tenderflex.util.Constants.*;
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
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager);
        customAuthenticationFilter.setFilterProcessesUrl(LOGIN_URL);
       return http.csrf().disable()
               .sessionManagement().sessionCreationPolicy(STATELESS)
               .and().authorizeHttpRequests().requestMatchers(LOGIN_URL).permitAll().and()
               .authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/users").hasAnyAuthority(ROLE_FOR_CLOSED_ENDPOINT).and()
               .authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/offers").hasAnyAuthority(ROLE_BIDDER).and()
               .authorizeHttpRequests().requestMatchers(HttpMethod.GET,  "/offers/me/**").hasAnyAuthority(ROLE_BIDDER).and()
               .authorizeHttpRequests().requestMatchers(HttpMethod.GET,  "/offers/{id}").hasAnyAuthority(ROLE_FOR_CLOSED_ENDPOINT).and()
               .authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/tenders").hasAnyAuthority(ROLE_CONTRACTOR).and()
               .authorizeHttpRequests().requestMatchers(HttpMethod.GET,  "/tenders").hasAnyAuthority(ROLE_BIDDER).and()
               .authorizeHttpRequests().requestMatchers(HttpMethod.GET,  "/tenders/me").hasAnyAuthority(ROLE_CONTRACTOR).and()
               .authorizeHttpRequests().requestMatchers(HttpMethod.GET,  "/tenders/me/**").hasAnyAuthority(ROLE_CONTRACTOR).and()
               .authorizeHttpRequests().requestMatchers(HttpMethod.GET,  "/tenders/{id}").hasAnyAuthority(ROLE_FOR_CLOSED_ENDPOINT).and()
               .authorizeHttpRequests().requestMatchers(HttpMethod.GET,  "/tenders/{id}/offers").hasAnyAuthority(ROLE_CONTRACTOR).and()
               .authorizeHttpRequests().anyRequest().authenticated()
               .and().addFilter(customAuthenticationFilter)
               .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
               .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web)->{
            web.ignoring().requestMatchers(HttpMethod.OPTIONS, "/**").requestMatchers("/v3/api-docs/**",
                    "/configuration/ui",
                    "/swagger-resources/**",
                    "/configuration/security",
                    "/swagger-ui.html",
                    "/swagger-ui/**",
                    "/webjars/**");
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");            }
        };
    }
}