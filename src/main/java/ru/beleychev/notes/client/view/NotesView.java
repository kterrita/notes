package ru.beleychev.notes.client.view;

import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Widget;
import ru.beleychev.notes.shared.dto.NoteDTO;
import ru.beleychev.notes.shared.dto.UserDTO;

import java.util.List;

/**
 * View interface for main page
 * @author beleychev.ilya 10.08.2017   13:58
 */
public interface NotesView {

	interface Presenter {
		void onSearchButtonClicked();

		void onSearchTextBoxPressed();

		void onNewNoteButtonClicked();

		void onEditNoteButtonClicked();

		void onAllNotesButtonClicked();

		void onImportantButtonClicked();

		void onFavoriteButtonClicked();

		void onRecycleBinButtonClicked();
	}

	void setPresenter(Presenter presenter);
	void setRowData(List<NoteDTO> rowData);
	void setUserDetails(UserDTO userDTO);
	DataGrid<NoteDTO> getData();
	Widget asWidget();
}
