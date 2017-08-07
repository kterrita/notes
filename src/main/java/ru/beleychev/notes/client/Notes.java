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
		MainPanel mainPanel = new MainPanel();

		if (notesGwtServiceAsync == null) {
			notesGwtServiceAsync = GWT.create(NotesGwtService.class);
		}

		notesGwtServiceAsync.getCurrentUser(new AsyncCallback<UserDTO>() {
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Something is wrong with *fillUserData method*");
			}

			@Override
			public void onSuccess(UserDTO result) {
				mainPanel.getUsernameLabel().setText(result.getUsername());
			}
		});


		notesGwtServiceAsync.getCurrentUserNotes(new AsyncCallback<List<NoteDTO>>() {
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Something is wrong with *FillInDataGrid method*");
			}

			@Override
			public void onSuccess(List<NoteDTO> result) {
				mainPanel.getNotesList().setRowCount(result.size(), true);
				mainPanel.getNotesList().setRowData(0, result);
			}
		});

		RootLayoutPanel.get().add(mainPanel);
	}
}
