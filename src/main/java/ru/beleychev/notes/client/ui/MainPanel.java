package ru.beleychev.notes.client.ui;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import ru.beleychev.notes.client.view.NotesView;
import ru.beleychev.notes.shared.dto.NoteDTO;

import java.util.Date;
import java.util.List;

/**
 * Main Panel UI building
 * Created by ilya on 30.07.2017.
 */
public class MainPanel extends Composite implements NotesView {
	interface MainPanelUiBinder extends UiBinder<DockLayoutPanel, MainPanel> {
	}

	private static MainPanelUiBinder ourUiBinder = GWT.create(MainPanelUiBinder.class);

	@UiField
	DockLayoutPanel mainPanel;
	@UiField
	HorizontalPanel northPanel;
	@UiField
	VerticalPanel userDatePanel;
	@UiField
	Label usernameLabel;
	@UiField
	DateLabel currentDateLabel;
	@UiField
	HorizontalPanel searchPanel;
	@UiField
	TextBox searchBox;
	@UiField
	Button searchButton;
	@UiField
	HorizontalPanel southPanel;
	@UiField
	Label rightsReservedLabel;
	@UiField
	VerticalPanel navigationPanel;
	@UiField
	Label newNote;
	@UiField
	Label allNotes;
	@UiField
	Label important;
	@UiField
	Label favorite;
	@UiField
	Label recycleBin;
	@UiField
	DataGrid<NoteDTO> notesList;
	@UiField
	Resources res;

	private Presenter presenter;

	static {
		Resources.INSTANCE.style().ensureInjected();
	}

	public MainPanel() {
		initWidget(ourUiBinder.createAndBindUi(this));
	}

	@UiHandler("searchButton")
	void onSearchButtonClick(ClickEvent event) {
		if (presenter != null) {
			presenter.onSearchButtonClicked();
		}
	}

	@UiHandler("searchBox")
	void onSearchTextBoxPressed(ClickEvent event) {
		if (presenter != null) {
			presenter.onSearchTextBoxPressed();
		}
	}

	@UiHandler("newNote")
	void onNewNoteButtonClicked(ClickEvent event) {
		if (presenter != null) {
			presenter.onNewNoteButtonClicked();
		}
	}

	@UiHandler("allNotes")
	void onAllNotesButtonClicked(ClickEvent event) {
		if (presenter != null) {
			presenter.onAllNotesButtonClicked();
		}
	}

	@UiHandler("important")
	void onImportantButtonClicked(ClickEvent event) {
		if (presenter != null) {
			presenter.onImportantButtonClicked();
		}
	}

	@UiHandler("favorite")
	void onFavoriteButtonClicked(ClickEvent event) {
		if (presenter != null) {
			presenter.onFavoriteButtonClicked();
		}
	}

	@UiHandler("recycleBin")
	void onRecycleBinButtonClicked(ClickEvent event) {
		if (presenter != null) {
			presenter.onRecycleBinButtonClicked();
		}
	}

/*	@UiHandler("notesList")
	void onRowItemClicked(ClickEvent event) {
		if (presenter != null) {
			// TODO: простая заглушка. Необходимо реализовать выделение строки чекбоксом
			presenter.onRowItemClicked(notesList.getVisibleItem(0));
		}
	}

	@UiHandler("notesList")
	void onRowItemSelected(ClickEvent event) {
		if (presenter != null) {
			// TODO: простая заглушка. Необходимо реализовать логику Обработки выбранных строк
			presenter.onRowItemSelected(notesList.getVisibleItem(0));
		}
	}*/

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setRowData(List<NoteDTO> rowData) {
		notesList.setRowData(0, rowData);
	}

	@Override
	public Widget asWidget() {
		return this;
	}
}