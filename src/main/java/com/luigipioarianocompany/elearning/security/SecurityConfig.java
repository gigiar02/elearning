package com.luigipioarianocompany.elearning.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;

    public SecurityConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/","/login","/error/**","/access-denied",
                                "/js/**","/css/**","/images/**","/fonts/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                )

                .authenticationProvider(authenticationProvider)

                .formLogin(form -> form
                        .loginPage("/login").permitAll()
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .successHandler(roleBasedSuccessHandler())
                        .failureUrl("/login?error")
                )

                //Logout da fare
                .exceptionHandling(ex -> ex
                        .accessDeniedPage("/access-denied")
                );

        return http.build();


    }

    private AuthenticationSuccessHandler roleBasedSuccessHandler() {
        return (request, response, authentication) -> {
            var auths = authentication.getAuthorities();
            boolean isAdmin = auths.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
            boolean isStudente = auths.stream().anyMatch(a -> a.getAuthority().equals("ROLE_STUDENTE"));
            boolean isDocente = auths.stream().anyMatch(a -> a.getAuthority().equals("ROLE_DOCENTE"));


            if(isAdmin) {response.sendRedirect("/admin/home");}
            else if(isStudente) {response.sendRedirect("/");}
            else if(isDocente)  {response.sendRedirect("/login");}
            else {response.sendRedirect("/login?error");}
        };
    }
}
