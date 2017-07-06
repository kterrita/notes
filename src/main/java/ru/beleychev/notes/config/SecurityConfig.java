package ru.beleychev.notes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Yeap. My Project)
 * Created by ilya on 05.07.2017.
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").hasRole("DBA")

                .and()

                .formLogin().loginPage("/login").permitAll()

                .and()

                .logout().permitAll();
    }
}
