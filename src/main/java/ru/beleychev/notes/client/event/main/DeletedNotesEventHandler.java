package ru.beleychev.notes.client.event.main;

import com.google.gwt.event.shared.EventHandler;

/**
 * Interface for handler processing representation of deleted notes
 * @author beleychev.ilya 11.08.2017   15:22
 */
public interface DeletedNotesEventHandler extends EventHandler {
	void onDeletedNotes(DeletedNotesEvent event);
}
