package ru.beleychev.notes.server.service;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.beleychev.notes.client.NotesGwtService;
import ru.beleychev.notes.server.domain.Note;
import ru.beleychev.notes.server.domain.NoteState;
import ru.beleychev.notes.server.domain.NoteType;
import ru.beleychev.notes.server.domain.Role;
import ru.beleychev.notes.server.domain.User;
import ru.beleychev.notes.server.repository.NoteRepository;
import ru.beleychev.notes.server.repository.UserRepository;
import ru.beleychev.notes.shared.AppContextManager;
import ru.beleychev.notes.shared.dto.NoteDTO;
import ru.beleychev.notes.shared.dto.NoteStateDTO;
import ru.beleychev.notes.shared.dto.NoteTypeDTO;
import ru.beleychev.notes.shared.dto.RoleDTO;
import ru.beleychev.notes.shared.dto.UserDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implementation of {@link NotesGwtService}
 * @author beleychev.ilya 17.07.2017   15:10
 */
public class NotesGwtServiceImpl implements NotesGwtService {
	private static final Logger logger = LoggerFactory.getLogger(NotesGwtServiceImpl.class);
	private final ApplicationContext applicationContext = AppContextManager.getApplicationContext();
	private final SecurityContext securityContext = SecurityContextHolder.getContext();
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private NoteRepository noteRepository;

	@Override
	public List<UserDTO> listUsers() throws Exception {
		List<User> users = userRepository.findAll();
		List<UserDTO> userDTOs;
		if (CollectionUtils.isNotEmpty(users)) {
			userDTOs = new ArrayList<>(users.size());
			for (User user : users) {
				userDTOs.add(createUserDTO(user));
			}
		} else {
			return null;
		}
		return userDTOs;
	}

	@Override
	public UserDTO getCurrentUser() throws Exception {
		String currentUserName = securityContext.getAuthentication().getName();
		User currentUser = userRepository.findUserByName(currentUserName);

		return createUserDTO(currentUser);
	}

	@Override
	public List<NoteDTO> getNotes(Long id) throws Exception {
		List<Note> notes = noteRepository.getNotes(id);
		List<NoteDTO> noteDTOs;
		if (CollectionUtils.isNotEmpty(notes)) {
			noteDTOs = new ArrayList<>(notes.size());
			for (Note note : notes) {
				noteDTOs.add(createNoteDTO(note));
			}
		} else {
			return null;
		}
		return noteDTOs;
	}

	private UserDTO createUserDTO(User user) throws Exception {
		Set<Role> roles;
		if (user != null) {
			roles = user.getRoles();
		} else {
			return null;
		}
		Set<RoleDTO> roleDTOs = new HashSet<>();
		if (roles != null) {
			for (Role role : roles) {
				roleDTOs.add(createRoleDTO(role));
			}
		} else {
			logger.error("No user found in database, username: [{}]", user);
			throw new Exception("No user found in database");
		}
		return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(), roleDTOs);
	}

	private RoleDTO createRoleDTO(Role role) {
		return new RoleDTO(role.getId());
	}

	private NoteDTO createNoteDTO(Note note) throws Exception {
		return new NoteDTO(note.getId(), note.getUuid(), note.isFavorite(), note.getDateCreated(),
				note.getContent(), note.getTitle(), createNoteTypeDTO(note.getType()), createNoteStateDTO(note.getState()), createUserDTO(note.getUser()));
	}

	private NoteTypeDTO createNoteTypeDTO(NoteType noteType) {
		return new NoteTypeDTO(noteType.getId());
	}

	private NoteStateDTO createNoteStateDTO(NoteState noteState) {
		return new NoteStateDTO(noteState.getId());
	}
}
