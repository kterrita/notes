package ru.beleychev.notes.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * Resource used by the entire application
 * @author beleychev.ilya 10.08.2017   13:02
 */
public interface Resources extends ClientBundle {
	Resources INSTANCE = GWT.create(Resources.class);

	@Source("ru/beleychev/notes/static/notesCss.css")
	Style style();

	interface Style extends CssResource {
		String mainPanel();
		String northPanel();
		String southPanel();
		String navigationPanel();
		String dataGridPanel();
		String label();
		String button();
		String searchBox();
	}
}
