package ru.beleychev.notes.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.beleychev.notes.client.dto.UserDTO;

import java.util.List;

/**
 * TODO: comment
 * @author beleychev.ilya 17.07.2017   16:35
 */
public interface NotesGwtServiceAsync {
	void listUsers(AsyncCallback<List<UserDTO>> callback);
}
