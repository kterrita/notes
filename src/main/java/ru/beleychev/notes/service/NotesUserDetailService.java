package ru.beleychev.notes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.beleychev.notes.domain.Role;
import ru.beleychev.notes.domain.User;
import ru.beleychev.notes.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author beleychev.ilya 06.07.2017   14:02
 */
@Service
public class NotesUserDetailService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(NotesUserDetailService.class);
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByName(username);

		if (user == null) {
			logger.info("User with username [{}] not found", username);
			throw new UsernameNotFoundException("User not found");
		}
		logger.info("User details: {}", user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				true, true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

		for (Role role : user.getRoles()) {
			logger.info("Role : {}", role);
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		}
		logger.info("authorities : {}", grantedAuthorities);
		return grantedAuthorities;
	}
}
