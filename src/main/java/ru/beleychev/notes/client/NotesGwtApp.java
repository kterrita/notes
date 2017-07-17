package ru.beleychev.notes.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * TODO: comment
 * @author beleychev.ilya 17.07.2017   16:07
 */
public class NotesGwtApp implements EntryPoint {
	@Override
	public void onModuleLoad() {
		final Label label = new Label();
		label.setText("Hello World");
		RootPanel.get("notes").add(label);
	}
}
