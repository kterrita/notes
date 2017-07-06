package ru.beleychev.notes.service;

import ru.beleychev.notes.domain.User;

/**
 * Yeap. My Project)
 * Created by ilya on 05.07.2017.
 */
public interface UserRepositoryCustom {
	User findUserByName(String username);
}
