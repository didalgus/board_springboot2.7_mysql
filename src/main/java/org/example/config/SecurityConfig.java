package org.example.config;

import org.example.common.Sha256PasswordEncoder;
import org.example.handler.CustomLoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests()
                .requestMatchers("/board/**").hasAnyAuthority("ROLE_MEMBER")
                .anyRequest().permitAll();

        http.headers()
                .defaultsDisabled()
                .frameOptions().sameOrigin()
                .cacheControl().disable();

        http.csrf();

        http.formLogin();
//                .loginProcessingUrl("/login/process")
//                .usernameParameter("id")
//                .passwordParameter("pwd")
//                .successHandler(new CustomLoginSuccessHandler());

        http.logout();
//                .logoutUrl("/auth/logout")
//                .deleteCookies("SESSION");

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Sha256PasswordEncoder();
    }
}
