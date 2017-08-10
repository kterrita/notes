package ru.beleychev.notes.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Interface for handler processing representation of Important notes
 * @author beleychev.ilya 10.08.2017   15:17
 */
public interface ImportantEventHandler extends EventHandler {
	void onImportantEvent(ImportantEvent event);
}
