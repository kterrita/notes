package ru.beleychev.notes.client.event.main;

import com.google.gwt.event.shared.EventHandler;

/**
 * Interface for handler processing search
 * @author beleychev.ilya 10.08.2017   15:02
 */
public interface SearchNoteEventHandler extends EventHandler {
	void onSearchNote(SearchNoteEvent event);
}
