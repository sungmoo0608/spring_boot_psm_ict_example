package edu.ict.ex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration		//@Component + 설정
@EnableWebSecurity	//필터 등록 = 시큐리티 설정 파일이다 라고 알려주는 역할
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/* 정적 리소스 폴더 처리 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		//web.ignoring().regexMatchers(PathRequest.toStaticResources().atCommonLocations());
		//web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/eshopper/**");	// 해당 폴더 접근은 막지 말라는 명령
		//web.ignoring().antMatchers("/**");	// 해당 폴더 접근은 막지 말라는 명령
	}
	
	/* 테스트용 유저 등록 = 인메모리 방식 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser("user").password("{noop}user").roles("USER").and()
			.withUser("admin").password("{noop}admin").roles("ADMIN");
	}
	
	/* 권한 설정 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//우선 CSRF설정을 해제한다.
		//초기 개발시만 해주는게 좋다.
		http.csrf(csrf -> csrf.disable());
	      
		http.authorizeHttpRequests()
		.antMatchers("/board/**").hasAnyRole("USER") 
		.antMatchers("/boards/**").hasAnyRole("ADMIN")
		.antMatchers("/**").permitAll();

		//로그인 폼 커스텀 마이징
        http.formLogin()
        	.loginPage("/eshopper/login")  //loginPage() 는 말그대로 로그인할 페이지 url 이고
            .usernameParameter("id")
            .passwordParameter("pw")
            .defaultSuccessUrl("/");

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {        
		return new BCryptPasswordEncoder();
	}
	
}
