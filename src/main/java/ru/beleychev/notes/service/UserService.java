package ru.beleychev.notes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.beleychev.notes.domain.User;
import ru.beleychev.notes.repository.UserRepository;

import java.util.List;

/**
 * Yeap. My Project)
 * Created by ilya on 05.07.2017.
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
