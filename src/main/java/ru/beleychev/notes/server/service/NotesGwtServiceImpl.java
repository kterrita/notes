package ru.beleychev.notes.server.service;

import ru.beleychev.notes.client.NotesGwtService;
import ru.beleychev.notes.shared.dto.RoleDTO;
import ru.beleychev.notes.shared.dto.UserDTO;
import ru.beleychev.notes.server.domain.Role;
import ru.beleychev.notes.server.domain.User;
import ru.beleychev.notes.server.repository.UserRepository;
import ru.beleychev.notes.shared.AppContextManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implementation of {@link NotesGwtService}
 *
 * @author beleychev.ilya 17.07.2017   15:10
 */
public class NotesGwtServiceImpl implements NotesGwtService {
    @Override
    public List<UserDTO> listUsers() {
        UserRepository userRepository = AppContextManager.getApplicationContext().getBean(UserRepository.class);
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>(users != null ? users.size() : 0);
        if (users != null) {
            for (User user : users) {
                userDTOs.add(createUserDTO(user));
            }
        }
        return userDTOs;
    }

    private UserDTO createUserDTO(User user) {
        Set<Role> roles = user.getRoles();
        Set<RoleDTO> roleDTOs = new HashSet<>(roles != null ? roles.size() : 0);
        if (roles != null) {
            for (Role role : roles) {
                roleDTOs.add(createRoleDTO(role));
            }
        }
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(), roleDTOs);
    }

    private RoleDTO createRoleDTO(Role role) {
        return new RoleDTO(role.getId(), role.getRoleName());
    }
}
