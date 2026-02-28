package com.rajkhatri.dev.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        System.out.println(">>> Custom SecurityConfig loaded <<<");

        http.csrf(crsf -> crsf.disable())
                .authorizeHttpRequests(request -> request.requestMatchers( "/login", "/css/**", "/images/**", "/actuator/**").permitAll()
                        .anyRequest().authenticated())

                .oauth2Login(login -> login.loginPage("/login").defaultSuccessUrl("/UserHome"))
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?").invalidateHttpSession(true).clearAuthentication(true).deleteCookies());
        return http.build();


    }

}
