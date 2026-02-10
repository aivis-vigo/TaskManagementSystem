package org.example.taskmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/error/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/tasks").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET, "/tasks/create/new").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/tasks/create").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/tasks/create").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/tasks/edit/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/tasks/delete/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                )
        .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
        .logout(LogoutConfigurer::permitAll)
        .exceptionHandling(e -> e.accessDeniedPage("/error/403"));

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}