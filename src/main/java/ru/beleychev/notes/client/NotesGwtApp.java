package ru.beleychev.notes.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;

/**
 * Main gwt class with UI building
 * @author beleychev.ilya 17.07.2017   16:07
 * @since 17.07.2017
 * @version 1.0
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
	private Button searchButton = new Button();
	private HorizontalPanel searchAndFilter = new HorizontalPanel();

	private HorizontalPanel southPanel = new HorizontalPanel();
	private VerticalPanel navigationPanel = new VerticalPanel();
	private ScrollPanel listPanel = new ScrollPanel();
	@Override
	public void onModuleLoad() {



		RootPanel.get();
	}
}
