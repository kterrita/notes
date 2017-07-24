package ru.beleychev.notes.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * Yeap. My Project)
 * Created by ilya on 05.07.2017.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private PersistentTokenRepository persistentTokenRepository;


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
				.antMatchers("/api/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/**").anonymous()
					.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.usernameParameter("username")
				.passwordParameter("password")
					.and()
				.logout().permitAll()
					.and()
				.rememberMe().tokenRepository(persistentTokenRepository)
				.tokenValiditySeconds(3600);
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl jd = new JdbcTokenRepositoryImpl();
		jd.setDataSource(dataSource);
		return jd;
	}
}
