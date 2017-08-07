package ru.beleychev.notes.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.beleychev.notes.shared.dto.NoteDTO;
import ru.beleychev.notes.shared.dto.UserDTO;

import java.util.List;

/**
 * Async interface for {@link NotesGwtService}
 * @author beleychev.ilya 17.07.2017   16:35
 */
public interface NotesGwtServiceAsync {
	void listUsers(AsyncCallback<List<UserDTO>> callback) throws Exception;

	void getCurrentUser(AsyncCallback<UserDTO> callback) throws Exception;

	void getNotes(Long id, AsyncCallback<NoteDTO> callback) throws Exception;
}
