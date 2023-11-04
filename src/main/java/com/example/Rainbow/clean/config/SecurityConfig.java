package com.example.Rainbow.clean.config;

import com.example.Rainbow.clean.repo.UserRepository;
import com.example.Rainbow.clean.service.impl.RainbowUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(
                authorizeRequest -> authorizeRequest
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/register", "/login","/login-error").permitAll()
                        .anyRequest().authenticated()
                ).formLogin(
                        formLogin -> {
                            formLogin
                                    .loginPage("/login")
                                    .usernameParameter("email")
                                    .passwordParameter("password")
                                    .defaultSuccessUrl("/")
                                    .failureForwardUrl("/login-error");
                        }

                ).logout(
                        logout -> {
                            logout.logoutUrl("/logout")
                                    .logoutSuccessUrl("/")
                                    .invalidateHttpSession(true);
                        }
                ).build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        return new RainbowUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
