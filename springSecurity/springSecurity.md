===================================================================================================
스텝 1
		
	<!-- 스프링 시큐리티 라이브러리 -->	
	  <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-security</artifactId>
      </dependency>
      
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-test</artifactId>
         <scope>test</scope>
      </dependency>
      
      <!-- 스프링 부트에서는  jsp 태그를 지원 하지 않기 때문에 직접 입력 해야야함 -->
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-taglibs</artifactId>
      </dependency>

위 3개의 디펜던시를 pom.xml에 추가 시켜줌

dependency만 추가해도 Spring Security에서 제공하는 가장 기본적인 인증이 바로 적용됨

기본 로그인 화면이 가장 먼저 나올 것이다.
Username : user (기본 계정)
Password : 비밀번호는 어플리케이션 기동할때 로그로 나오는 Using generated security password 정보
Using generated security password: 0d07e7fd-0fba-403d-9eff-149ac84f4d56

This generated password is for development use only. 
Your security configuration must be updated before running your application in production.

### 스프링 시큐리티(알렉스 아저시) 인증 방식은 세션,쿠키 방식 임

==================================================================================

스텝 2
이미지(가영이)가 보이지 않는다.
우선 정적파일들은 시큐리티에 적용되지 않도록 아래와 같이 설정을 한다.
이제 더이상 리소스파일들은 스프링 시큐리티에서 관리를 하지 않는다.   


	@Override
	public void configure(WebSecurity web) throws Exception {
		// web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}
   
=====================================================================================================

스텝 3

이제 설정에서 유저를 생성한후 , 다시 한번 접속해 보자 , 로그인 창에서 아래의 이름과 비밀번호로 접속해 보자. 그럼 헬로우 월드가 보인다.
   
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("member").password("{noop}member").roles("USER").and()
			.withUser("admin").password("{noop}admin").roles("ADMIN");
	}
	
=====================================================================================================

스텝 4.

home.jsp를 제대로 만들고, 아래와 같이 설정하여 / 로 접속후 home.jsp 가 나오는것을 확인한다.

	@Override
		protected void configure(HttpSecurity http) throws Exception {
		//우선 CSRF설정을 해제한다.
		//초기 개발시만 해주는게 좋다.
		http.csrf().disable();
      
		http.authorizeRequests()
		.antMatchers("/member/**").hasAnyRole("ROLE_MEMBER") 
		.antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN")
		.antMatchers("/**").permitAll();      
		}


=====================================================================================================

스텝 5.

## 기본 로그인 폼을 사용 하기 위한 설정
	protected void configure(HttpSecurity http) throws Exception {
		//우선 CSRF설정을 해제한다.
		//초기 개발시만 해주는게 좋다.
		http.csrf().disable();
      
		http.authorizeRequests()
		.antMatchers("/user/**").hasAnyRole("USER") 
		.antMatchers("/admin/**").hasAnyRole("ADMIN")
		.antMatchers("/**").permitAll();
			      
		http.formLogin(); //스프링 시큐리티에 있는 기본 로그인 폼을 사용하겠다.
		
		
=====================================================================================================

스텝 6.

## DB 작업 및 UserMapper 생성


=====================================================================================================

스텝 7.

## 로그인 페이지 커스텀 마이징

	//로그인 폼 커스텀 마이징
	http.formLogin()
		.loginPage("/login")	//loginPage()는 말그대로 로그인할 페이지 url이고
		.usernameParameter("id")
		.usernameParameter("pw")
		.defaultSuccessUrl("/");
		
		
=====================================================================================================

스텝 8.

## 패스워드 암호화 저장

암호화 모듈 종류 참고사이트
https://velog.io/@hyeinisfree/SpringSecurity-PasswordEncoder

PasswordEncoders
Spring Security는 PasswordEncoder라는 인터페이스를 이용해 암호가 안전하게 저장될 수 있도록 암호의 단방향 변환을 지원합니다. 
PasswordEncoder라는 인터페이스의 구현체로 BCryptPasswordEncoder, Argon2PasswordEncoder, Pbkdf2PasswordEncoder, SCryptPasswordEncoder 등 많은 PasswordEncoder가 있습니다. 


	@Test
	void testInsertUser() {
		
		UserVO user = new UserVO();
		user.setUsername("admin2");
		user.setPassword(passwordEncoder.encode("admin2"));
		user.setEnabled("1");
		
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
		
		assertNotNull(user);
		
		System.out.println(user);
	}
	
	@Test
	void testMatcher() {
		
		UserVO user = userMapper.getUser("admin2");
		//$2a$10$vLzYKr1RGSZ684fO4JESzukCGEUz6OJEcvAmwi06Krehcbry8L9zC
		boolean isMatch = passwordEncoder.matches("admin2", user.getPassword());
		
		System.out.println(user.getPassword());
		assertEquals(isMatch, true);	
	}
	
	
=====================================================================================================

스텝 9.

## 이제 DB와 연결하여, 시큐리티를 커스텀 마이징 해보자.

UserDetails 와 UserDetailsService 를 구현하여 완성

	UserDetailsVO
	
		// 알렉스 아저씨가 말해주는 넣어줘야 할 포맷형식
		@Slf4j
		@Setter
		public class UserDetailsVO implements UserDetails {
		
		private String username;
		private String password;
		private List<GrantedAuthority> authorities;
		
		public UserDetailsVO(UserVO user) {
			this.username = user.getUsername();
			this.setPassword(user.getPassword());
			this.setAuthorities(user);
		}
		
		//UserVO에서 권한을 추출하여 UserDetails에서 요구하는 권한 형식으로 만들어줌 
		public void setAuthorities(UserVO userVO) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			
			for(AuthVO authVO : userVO.getAuthList()) {
				authorities.add(new SimpleGrantedAuthority(authVO.getAuthority()));
			}
			
			this.authorities = authorities;
		}
		
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
	
			return null;
		}
	
		@Override
		public String getPassword() {
	
			return this.password;
		}
	
		@Override
		public String getUsername() {
	
			return this.username;
		}
	
		// 계정이 만료 되지 않았는가?
		@Override
		public boolean isAccountNonExpired() {
	
			return true;
		}
	
		// 계정이 잠기지 않았는가?
		@Override
		public boolean isAccountNonLocked() {
	
			return true;
		}
	
		// 패스워드가 만료되지 않았는가?
		@Override
		public boolean isCredentialsNonExpired() {
	
			return true;
		}
		
		// 계정이 활성화 되었는가?
		@Override
		public boolean isEnabled() {
	
			return true;
		}
		
	}
		
	CustomUserDetailsService
	
		//알렉스 아저씨가 말하는 user 정보를 주고 받기 위한 Fax
		@Slf4j
		@Service
		public class CustomUserDetailsService implements UserDetailsService {
	
		@Autowired
		private UserMapper userMapper;
		
		
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
			log.warn("Load User By UserVO user : " + username);
			
			UserVO user = userMapper.getUser(username);
			
			log.warn("queried by UserVO mapper : " + user);
			
			return user == null? null:new UserDetailsVO(user);
			
		}
		
	}




