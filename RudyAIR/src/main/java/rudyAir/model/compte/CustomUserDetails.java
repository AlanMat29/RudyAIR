package rudyAir.model.compte;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private Compte compte;

	public CustomUserDetails(Compte compte) {
		super();
		this.compte = compte;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> role = null;
		if (compte instanceof Client) {
			role = Arrays.asList(new SimpleGrantedAuthority("ROLE_CLIENT"));
		} else {
			role = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		return role;
	}

	@Override
	public String getPassword() {
		return compte.getPassword();
	}

	@Override
	public String getUsername() {
		return compte.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
