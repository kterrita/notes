package ru.beleychev.notes.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.*;
import ru.beleychev.notes.shared.dto.UserDTO;

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
    DataGrid<UserDTO> notesList;


    public MainPanel() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}