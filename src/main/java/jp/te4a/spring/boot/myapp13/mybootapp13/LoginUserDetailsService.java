package jp.te4a.spring.boot.myapp13.mybootapp13;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {
@Autowired
 UserRepository userRepository;
 private Collection<GrantedAuthority> getAuthorities(UserBean userBean){  
    return AuthorityUtils.createAuthorityList("ROLE_USER");
}
 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 Optional<UserBean> opt = userRepository.findById(username);
 UserBean user = opt.orElseThrow(() -> new UsernameNotFoundException("The requested user is not found."));
 return new LoginUserDetails(user, true, true, true, getAuthorities(user));
 }

}
