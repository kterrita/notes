package ru.beleychev.notes.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.beleychev.notes.shared.dto.UserDTO;

import java.util.List;

/**
 * GWT service class. It serves for integrating Spring services with GWT, though.
 * @author beleychev.ilya 17.07.2017   15:09
 * @since 17.07.2017
 * @version 1.0
 */
@RemoteServiceRelativePath("notes.rpc")
public interface NotesGwtService extends RemoteService {
	/**
	 * Wrapper for {@link ru.beleychev.notes.server.repository.UserRepository}
	 * @return all users from system, {@code null} if there is no users in DB
	 */
	List<UserDTO> listUsers();
}
