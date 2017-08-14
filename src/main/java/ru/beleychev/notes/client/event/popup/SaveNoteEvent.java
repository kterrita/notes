package ru.beleychev.notes.client.event.popup;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Save event from popup
 * Created by ilya on 13.08.2017.
 */
public class SaveNoteEvent extends GwtEvent<SaveNoteEventHandler> {
    public static Type<SaveNoteEventHandler> TYPE = new Type<SaveNoteEventHandler>();

    public Type<SaveNoteEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(SaveNoteEventHandler handler) {
        handler.onSaveNote(this);
    }
}
