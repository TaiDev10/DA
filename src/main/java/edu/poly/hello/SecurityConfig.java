//package edu.poly.hello;
//
//import java.util.NoSuchElementException;
//import java.util.stream.Collectors;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;
//
//import edu.poly.hello.entiry.Account;
//import edu.poly.hello.service.AccountService;
//@Configuration
//@EnableWebSecurity
//
//public class SecurityConfig {
//	@Autowired
//	AccountService accountService;
//	@Autowired
//	BCryptPasswordEncoder pe;
//	@Bean
//	protected AuthenticationManager  configure(AuthenticationManagerBuilder auth) throws Exception{
//	    auth.userDetailsService(username ->{
//	    	try {
//				Account user = accountService.findById(username);
//				String password = pe.encode(user.getPassword());
//				String[]roles = user.getAuthorities().stream()
//						.map(er -> er.getRole().getId())
//						.collect(Collectors.toList()).toArray(new String[0]);
//				return User.withUsername(username).password(password).roles(roles).build();
//			} catch (NoSuchElementException e) {
//				throw new UsernameNotFoundException(username + "not found!");
//			}
//	    });
//		return auth.build();
//	}
//	@Bean
//	public SecurityFilterChain  filterChain(HttpSecurity http) throws Exception {
//	    http.csrf()
//	      .disable()
//	      .authorizeRequests()
//	      .requestMatchers("/order/**").authenticated()
//	      .requestMatchers("/admin/**").hasAnyRole("STAF","DIRE")
//	      .requestMatchers("/rest/authorities").hasRole("RIDE")
//	      .anyRequest().permitAll();
//
//	    http.formLogin()
//	    .loginPage("security/login/form")
//	    .loginProcessingUrl("/security/logi")
//	    .defaultSuccessUrl("security/login/success" , false)
//	    .failureUrl("/security/login/error");
//
//	    http.rememberMe()
//	    .tokenValiditySeconds(86400);
//
//	    http.exceptionHandling()
//	    .accessDeniedPage("/security/anauthoried");
//
//	    http.logout()
//	    .logoutUrl("/security/logoff")
//	    .logoutSuccessUrl("/security/logoff/success");
//		return http.build();
//
//	}
//	@Bean
//	BCryptPasswordEncoder getBCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	@Bean
//	public void cofigure(WebSecurity web) throws Exception{
//		web.ignoring().requestMatchers(HttpMethod.OPTIONS,"/**");
//	}
//
//}
