package ru.beleychev.notes.client.event.main;

import com.google.gwt.event.shared.EventHandler;

/**
 * Interface for handler processing creating New Note
 * @author beleychev.ilya 10.08.2017   15:10
 */
public interface NewNoteEventHandler extends EventHandler {
	void onNewNote(NewNoteEvent event);
}
