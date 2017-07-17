package ru.beleychev.notes.server.service;

import ru.beleychev.notes.server.domain.User;

/**
 * Yeap. My Project)
 * Created by ilya on 05.07.2017.
 */
public interface UserRepositoryCustom {
	User findUserByName(String username);
}
