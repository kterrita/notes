package ru.beleychev.notes.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.beleychev.notes.shared.dto.NoteDTO;
import ru.beleychev.notes.shared.dto.UserDTO;

import java.util.List;

/**
 * GWT service class. It serves for integrating Spring services with GWT, though.
 * @author beleychev.ilya 17.07.2017   15:09
 * @version 1.0
 * @since 17.07.2017
 */
@RemoteServiceRelativePath("notes.rpc")
public interface NotesGwtService extends RemoteService {
	/**
	 * @return all users from system, {@code null} if there is no users in DB
	 */
	List<UserDTO> listUsers();

	/**
	 * @return current authenticated User
	 */
	UserDTO getCurrentUser();

	/**
	 * Use it to get all notes for CurrentUser
	 * @return all {@link NoteDTO} by user, {@code null} if there is no notes in DB
	 */
	List<NoteDTO> getCurrentUserNotes();

	/**
	 * @return favorite {@link NoteDTO} of current user, {@code null} if there is no notes in DB
	 */
	List<NoteDTO> getFavoriteNotes();

	/**
	 * @return important {@link NoteDTO} of current user, {@code null} if there is no notes in DB
	 */
	List<NoteDTO> getImportantNotes();

	/**
	 * @return deleted {@link NoteDTO} of current user, {@code null} if there is no notes in DB
	 */
	List<NoteDTO> getDeletedNotes();

	/**
	 * saving note to DB
	 */
	void saveNote(NoteDTO noteDTO);
}
