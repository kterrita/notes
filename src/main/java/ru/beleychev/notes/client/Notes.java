package ru.beleychev.notes.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import ru.beleychev.notes.client.ui.MainPanel;
import ru.beleychev.notes.shared.dto.NoteDTO;
import ru.beleychev.notes.shared.dto.UserDTO;

import java.util.List;

/**
 * Main gwt class with UI building
 * @author beleychev.ilya 17.07.2017   16:07
 * @version 1.0
 * @since 17.07.2017
 */
public class Notes implements EntryPoint {
	private NotesGwtServiceAsync notesGwtServiceAsync = GWT.create(NotesGwtService.class);

	@Override
	public void onModuleLoad() {

	}
}
