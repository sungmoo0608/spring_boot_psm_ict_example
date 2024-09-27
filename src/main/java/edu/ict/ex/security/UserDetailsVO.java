package edu.ict.ex.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.ict.ex.vo.AuthVO;
import edu.ict.ex.vo.CartVO;
import edu.ict.ex.vo.UserVO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

// 알렉스 아저씨가 말해주는 넣어줘야 할 포맷형식
@Slf4j
@Setter
public class UserDetailsVO implements UserDetails {

	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	
	private CartVO cart;

	public UserDetailsVO(UserVO user) {
		this.username = user.getUsername();
		this.setPassword(user.getPassword());
		this.setAuthorities(user);      
	}
	
	public UserDetailsVO(UserVO user,CartVO cart) {
		this.username = user.getUsername();
		this.setPassword(user.getPassword());
		this.setAuthorities(user);      
		
		this.cart = cart;
	}
	
	public CartVO getCart() {
		return cart;
	}


	//UserVO 에서 권한을 추출하여 UserDetails에서 요구 하는 권한 형식으로 만들어줌
	public void setAuthorities(UserVO userVO) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for(AuthVO authVO : userVO.getAuthList()) {
			authorities.add(new SimpleGrantedAuthority(authVO.getAuthority()));
		}

		this.authorities = authorities;      
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return this.authorities;
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
