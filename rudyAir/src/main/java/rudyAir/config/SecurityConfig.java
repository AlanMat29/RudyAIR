package rudyAir.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/api/**")
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().ignoringAntMatchers("/api/**")
		.and()				
		.authorizeHttpRequests()
				.antMatchers("/api/**").permitAll()
//				.antMatchers(HttpMethod.GET, "/api/auth/search/**").permitAll()
//				.antMatchers(HttpMethod.OPTIONS,"/api/**").permitAll()
//				.antMatchers(HttpMethod.POST,"/api/auth/inscription").permitAll()
//				.antMatchers(HttpMethod.POST).hasRole("ADMIN")
//				.antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//				.antMatchers(HttpMethod.PUT).hasRole("ADMIN")
//				.antMatchers("/api/**").authenticated()
		.and()
		.httpBasic();		
		// @formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		auth.userDetailsService(userDetailsService);
		// @formatter:on
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
