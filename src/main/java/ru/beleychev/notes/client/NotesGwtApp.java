package ru.beleychev.notes.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * TODO: comment
 * @author beleychev.ilya 17.07.2017   16:07
 */
public class NotesGwtApp implements EntryPoint {
	@Override
	public void onModuleLoad() {

		DockLayoutPanel p = new DockLayoutPanel(Style.Unit.EM);
		p.addNorth(new HTML("header"), 2);
		p.addSouth(new HTML("footer"), 2);
		p.addWest(new HTML("navigation"), 10);
		p.add(new HTML("OMG IT WORKS!"));
		p.setTitle("Hello World");

		RootPanel.get().add(p);
	}
}
