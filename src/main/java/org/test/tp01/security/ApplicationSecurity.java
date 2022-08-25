package org.test.tp01.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurity(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/index.html","/css/**").permitAll()
                .antMatchers("/api/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/products/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.DELETE,"/api/products/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails admin = User
                .builder()
                .username("Admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails manager = User
                .builder()
                .username("Manager")
                .password(passwordEncoder.encode("manager"))
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(
                admin, manager
        );
    }
}
