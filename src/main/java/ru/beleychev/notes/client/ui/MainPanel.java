package ru.beleychev.notes.client.ui;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
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
import ru.beleychev.notes.shared.dto.NoteDTO;

import java.util.Date;

/**
 * Main Panel UI building
 * Created by ilya on 30.07.2017.
 */
public class MainPanel extends Composite {
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
    Label allNotes;
    @UiField
    Label important;
    @UiField
    Label favorite;
    @UiField
    Label recycleBin;
    @UiField
    DataGrid<NoteDTO> notesList;


    public MainPanel() {
        initWidget(ourUiBinder.createAndBindUi(this));
        setupNorthPanel();
        setupSouthPanel();
        setupNavigationPanel();
        setupCenterPanel();
    }

    private void setupNorthPanel() {
    	currentDateLabel.setValue(new Date());
    	searchButton.setText("Search");
    }

    private void setupSouthPanel() {
    	rightsReservedLabel.setText("All rights reserved. BIN TM. 2017");
    }

    private void setupNavigationPanel() {
    	allNotes.setText("All notes");
	    important.setText("Important");
	    favorite.setText("Favorite");
	    recycleBin.setText("Recycle Bin");
    }

    private void setupCenterPanel() {
	    Column<NoteDTO, String> titleColumn = new Column<NoteDTO, String>(new TextCell()) {
		    @Override
		    public String getValue(NoteDTO noteDTO) {
			    return noteDTO.getTitle();
		    }
	    };

	    Column<NoteDTO, Date> dateCreatedColumn = new Column<NoteDTO, Date>(new DateCell()) {
		    @Override
		    public Date getValue(NoteDTO noteDTO) {
			    return noteDTO.getDateCreated();
		    }
	    };

	    notesList.addColumn(titleColumn, "Title");
	    notesList.addColumn(dateCreatedColumn, "Created Date");
    }

	public static MainPanelUiBinder getOurUiBinder() {
		return ourUiBinder;
	}

	public DockLayoutPanel getMainPanel() {
		return mainPanel;
	}

	public HorizontalPanel getNorthPanel() {
		return northPanel;
	}

	public VerticalPanel getUserDatePanel() {
		return userDatePanel;
	}

	public Label getUsernameLabel() {
		return usernameLabel;
	}

	public DateLabel getCurrentDateLabel() {
		return currentDateLabel;
	}

	public HorizontalPanel getSearchPanel() {
		return searchPanel;
	}

	public TextBox getSearchBox() {
		return searchBox;
	}

	public Button getSearchButton() {
		return searchButton;
	}

	public HorizontalPanel getSouthPanel() {
		return southPanel;
	}

	public Label getRightsReservedLabel() {
		return rightsReservedLabel;
	}

	public VerticalPanel getNavigationPanel() {
		return navigationPanel;
	}

	public Label getAllNotes() {
		return allNotes;
	}

	public Label getImportant() {
		return important;
	}

	public Label getFavorite() {
		return favorite;
	}

	public Label getRecycleBin() {
		return recycleBin;
	}

	public DataGrid<NoteDTO> getNotesList() {
		return notesList;
	}
}