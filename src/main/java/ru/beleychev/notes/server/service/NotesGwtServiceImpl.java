package ru.beleychev.notes.server.service;

import org.springframework.context.ApplicationContext;
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

    private final ApplicationContext applicationContext = AppContextManager.getApplicationContext();

	@Override
	public List<UserDTO> listUsers() {
		return null;
	}
}
