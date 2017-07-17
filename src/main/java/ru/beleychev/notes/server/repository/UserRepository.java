package ru.beleychev.notes.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.beleychev.notes.server.domain.User;
import ru.beleychev.notes.server.service.UserRepositoryCustom;

/**
 * Yeap. My Project)
 * Created by ilya on 05.07.2017.
 */
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
