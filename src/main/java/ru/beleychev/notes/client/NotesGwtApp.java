package ru.beleychev.notes.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import ru.beleychev.notes.client.dto.UserDTO;

/**
 * Main gwt class with UI building
 * @author beleychev.ilya 17.07.2017   16:07
 * @version 1.0
 * @since 17.07.2017
 */
public class NotesGwtApp implements EntryPoint {
	// главная панель
	private VerticalPanel mainPanel = new VerticalPanel();
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
	private Label allRightsReservedLabel = new Label();
	private HorizontalPanel southPanel = new HorizontalPanel();
	// элементы navigationPanel
	private Button allNotes = new Button("All notes");
	private Button important = new Button("Important");
	private Button favorite = new Button("Favorite");
	private Button recycleBin = new Button("Recycle bin");
	private VerticalPanel navigationPanel = new VerticalPanel();
	// элементы listPanel
	private DataGrid<UserDTO> notesList= new DataGrid<>();
	private ScrollPanel listPanel = new ScrollPanel();

	@Override
	public void onModuleLoad() {
		//notesList.addColumn(new Column<UserDTO, String>(), "First Name");
		RootPanel.get();
	}
}
