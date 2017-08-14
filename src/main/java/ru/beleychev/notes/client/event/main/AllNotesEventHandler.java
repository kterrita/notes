package ru.beleychev.notes.client.event.main;

import com.google.gwt.event.shared.EventHandler;

/**
 * Interface for handler processing representation of all notes
 * @author beleychev.ilya 10.08.2017   15:14
 */
public interface AllNotesEventHandler extends EventHandler {
	void onAllNotes(AllNotesEvent event);
}
