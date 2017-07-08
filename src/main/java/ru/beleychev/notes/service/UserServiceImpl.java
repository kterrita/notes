package ru.beleychev.notes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.beleychev.notes.domain.Role;
import ru.beleychev.notes.domain.User;
import ru.beleychev.notes.repository.RoleRepository;
import ru.beleychev.notes.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Yeap. My Project)
 * Created by ilya on 08.07.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveNewUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role defaultRole = roleRepository.findOne(1L);
        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);
        user.setRoles(roles);
        userRepository.save(user);
        logger.info("User saved successfully, user details: [{}]", user);
    }
}
