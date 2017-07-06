package ru.beleychev.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.beleychev.notes.domain.Role;

/**
 * Yeap. My Project)
 * Created by ilya on 05.07.2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
