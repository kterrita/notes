package ru.beleychev.notes.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * TODO: comment
 * @author beleychev.ilya 17.07.2017   15:09
 */
@RemoteServiceRelativePath("/")
public interface NotesGwtService extends RemoteService {
	String get();
}
