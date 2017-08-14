package ru.beleychev.notes.client.event.popup;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for save event
 * Created by ilya on 13.08.2017.
 */
public interface SaveNoteEventHandler extends EventHandler {
    void onSaveNote(SaveNoteEvent event);
}
