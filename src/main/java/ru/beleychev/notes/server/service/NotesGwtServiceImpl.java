package ru.beleychev.notes.server.service;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.beleychev.notes.client.NotesGwtService;
import ru.beleychev.notes.server.domain.*;
import ru.beleychev.notes.server.repository.NoteRepository;
import ru.beleychev.notes.server.repository.UserRepository;
import ru.beleychev.notes.shared.dto.*;

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
    private static final Logger logger = LoggerFactory.getLogger(NotesGwtServiceImpl.class);
    private UserRepository userRepository;
    private NoteRepository noteRepository;

    @Override
    public List<UserDTO> listUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs;
        if (users != null && users.size() > 0) {
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
    public UserDTO getCurrentUser() {
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findUserByName(currentUserName);

        return createUserDTO(currentUser);
    }

    @Override
    public List<NoteDTO> getCurrentUserNotes() {
        List<Note> notes = noteRepository.getNotes(getCurrentUser().getId());
        List<NoteDTO> noteDTOs;
        if (notes != null && notes.size() > 0) {
            noteDTOs = new ArrayList<>(notes.size());
            for (Note note : notes) {
                noteDTOs.add(createNoteDTO(note));
            }
        } else {
            return null;
        }
        return noteDTOs;
    }

    private UserDTO createUserDTO(User user) {
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
            return null;
        }
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(), roleDTOs);
    }

    private RoleDTO createRoleDTO(Role role) {
        return new RoleDTO(role.getId());
    }

    private NoteDTO createNoteDTO(Note note) {
        return new NoteDTO(note.getId(), note.getUuid(), note.isFavorite(), note.isImportant(), note.getDateCreated(),
                note.getContent(), note.getTitle(), note.getTypeId(), note.getStateId(), note.getUserId(), note.isDeleted(),
                createNoteTypeDTO(note.getType()), createNoteStateDTO(note.getState()), createUserDTO(note.getUser()));
    }

    private NoteTypeDTO createNoteTypeDTO(NoteType noteType) {
        return new NoteTypeDTO(noteType.getId());
    }

    private NoteStateDTO createNoteStateDTO(NoteState noteState) {
        return new NoteStateDTO(noteState.getId());
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setNoteRepository(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
}
