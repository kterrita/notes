package ru.beleychev.notes.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.beleychev.notes.server.domain.Role;

/**
 * Yeap. My Project)
 * Created by ilya on 05.07.2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
