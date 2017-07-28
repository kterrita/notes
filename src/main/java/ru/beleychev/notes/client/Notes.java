package ru.beleychev.notes.client;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import ru.beleychev.notes.shared.dto.UserDTO;

import java.util.List;

/**
 * Main gwt class with UI building
 *
 * @author beleychev.ilya 17.07.2017   16:07
 * @version 1.0
 * @since 17.07.2017
 */
public class Notes implements EntryPoint {
    // главная панель
    private SimpleLayoutPanel mainPanel = new SimpleLayoutPanel();
    // панель север, юг, навигация, контент
    private DockLayoutPanel addPanel = new DockLayoutPanel(Style.Unit.EM);
    private HorizontalPanel northPanel = new HorizontalPanel();
    // элементы userAndTimeInfo
    private Label user = new Label();
    private Label time = new Label();
    private VerticalPanel userAndTimeInfo = new VerticalPanel();
    // элементы searchAndFilter
    private TextBox searchBox = new TextBox();
    private Button searchButton = new Button("Search");
    private HorizontalPanel searchAndFilter = new HorizontalPanel();
    // элементы southPanel
    private Label allRightsReservedLabel = new Label("All rights reserved");
    private HorizontalPanel southPanel = new HorizontalPanel();
    // элементы navigationPanel
    private Button allNotes = new Button("All notes");
    private Button important = new Button("Important");
    private Button favorite = new Button("Favorite");
    private Button recycleBin = new Button("Recycle bin");
    private VerticalPanel navigationPanel = new VerticalPanel();
    // элементы listPanel
    private DataGrid<UserDTO> notesList = new DataGrid<>();
    private ScrollPanel listPanel = new ScrollPanel();

    private NotesGwtServiceAsync notesGwtServiceAsync = GWT.create(NotesGwtService.class);

    @Override
    public void onModuleLoad() {
        Column<UserDTO, String> firstNameColumn = new Column<UserDTO, String>(new TextCell()) {
            @Override
            public String getValue(UserDTO userDTO) {
                return userDTO.getFirstName();
            }
        };
        firstNameColumn.setSortable(true);
        notesList.addColumn(firstNameColumn, "First name");
        if (notesGwtServiceAsync == null) {
            notesGwtServiceAsync = GWT.create(NotesGwtService.class);
        }
        AsyncCallback<List<UserDTO>> callback = new AsyncCallback<List<UserDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Fail callback!");
            }

            @Override
            public void onSuccess(List<UserDTO> result) {
                notesList.setRowCount(result.size(), true);
                notesList.setRowData(0, result);
                notesList.setWidth("100%");
                user.setText(result.get(0).getUsername());
                time.setText("28 July 2017");
            }
        };
        notesGwtServiceAsync.listUsers(callback);

        userAndTimeInfo.add(user);
        userAndTimeInfo.add(time);

        searchAndFilter.add(searchBox);
        searchAndFilter.add(searchButton);

        northPanel.add(userAndTimeInfo);
        northPanel.add(searchAndFilter);

        southPanel.add(allRightsReservedLabel);

        navigationPanel.add(allNotes);
        navigationPanel.add(important);
        navigationPanel.add(favorite);
        navigationPanel.add(recycleBin);

        //listPanel.add(notesList);
        //listPanel.setWidth("100%");

        addPanel.addNorth(northPanel, 2);
        addPanel.addSouth(southPanel, 2);
        addPanel.addWest(navigationPanel, 10);
        addPanel.add(notesList);

        mainPanel.add(addPanel);

        RootLayoutPanel.get().add(mainPanel);
    }
}
