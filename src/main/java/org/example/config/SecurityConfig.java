package org.example.config;

import org.example.common.Sha256PasswordEncoder;
import org.example.handler.CustomLoginSuccessHandler;
import org.example.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests()
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/board/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .requestMatchers("/project/**").authenticated()
                .requestMatchers("/board/**").permitAll()
                .requestMatchers("/user/**").permitAll()
                .requestMatchers("/swagger-ui/**").permitAll()
                .anyRequest().permitAll();

        http.headers()
                .defaultsDisabled()
                .frameOptions().sameOrigin()
                .cacheControl().disable()
                .xssProtection().headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK);

        http.csrf().disable();      // Post 전송시 csrf 항목 추가해주지 않는경우 disable()  해줘야 함.
        // Cross Site Request Fogery: 사이트간 요청 위조

        http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);

        http.formLogin();
//                .loginProcessingUrl("/login/process")
//                .usernameParameter("id")
//                .passwordParameter("pwd")
//                .successHandler(new CustomLoginSuccessHandler());

        http.logout();
//                .logoutUrl("/auth/logout")
//                .deleteCookies("SESSION");

        return http.build();

/*
        return http
            .authorizeHttpRequests()
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/private-project/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MEMBER")
                .requestMatchers("/project/**").authenticated()
                .anyRequest().permitAll()
                .and()
            .requiresChannel()
                .requestMatchers("/admin/**").requiresSecure()
                .requestMatchers("/private-project/**").requiresSecure()
                .requestMatchers("/project/**").requiresSecure()
                .anyRequest().requiresInsecure()
                .and()
            .formLogin()
                .and()
            .logout()
                .and()
            .headers()
                .defaultsDisabled()
                .cacheControl()
                    .and()
                .contentTypeOptions()
                    .and()
                .xssProtection()
                    .headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK)
                    .and()
                .frameOptions()
                    .sameOrigin()
                .and()
            .csrf()
                .disable()
            .sessionManagement()
                .maximumSessions(1)
                    .maxSessionsPreventsLogin(true)
                    .and()
                .and()
            .build();
*/
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(CustomUserDetailsService customUserDetailsService) {

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);

        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder noOpPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
