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
	void listUsers(AsyncCallback<List<UserDTO>> callback);

	void getCurrentUser(AsyncCallback<UserDTO> callback);

	void getCurrentUserNotes(AsyncCallback<List<NoteDTO>> callback);

	void getFavoriteNotes(AsyncCallback<List<NoteDTO>> callback);

	void getImportantNotes(AsyncCallback<List<NoteDTO>> callback);

	void getDeletedNotes(AsyncCallback<List<NoteDTO>> callback);

	void saveNote(NoteDTO noteDTO, AsyncCallback<Void> callback);
}
