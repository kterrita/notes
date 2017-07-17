package ru.beleychev.notes.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * TODO: comment
 * @author beleychev.ilya 17.07.2017   16:35
 */
public interface NotesGwtServiceAsync {
	void get(AsyncCallback<String> callback);
}
