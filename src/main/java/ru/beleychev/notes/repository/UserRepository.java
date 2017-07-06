package ru.beleychev.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.beleychev.notes.domain.User;

/**
 * Yeap. My Project)
 * Created by ilya on 05.07.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
