package ru.beleychev.notes.client.view;

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

		void onAllNotesButtonClicked();

		void onImportantButtonClicked();

		void onFavoriteButtonClicked();

		void onRecycleBinButtonClicked();

		void onRowItemClicked(NoteDTO clickedItem);

		void onRowItemSelected(NoteDTO selectedItem);
	}

	void setPresenter(Presenter presenter);
	void setRowData(List<NoteDTO> rowData);
	void setUserDetails(UserDTO userDTO);
	Widget asWidget();
}
