package ru.beleychev.notes.client.event.main;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Implementation of {@link com.google.gwt.event.shared.GwtEvent<NewNoteEventHandler>}
 * @author beleychev.ilya 10.08.2017   15:09
 */
public class NewNoteEvent extends GwtEvent<NewNoteEventHandler> {
	public static Type<NewNoteEventHandler> TYPE = new Type<>();

	@Override
	public Type<NewNoteEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(NewNoteEventHandler handler) {
		handler.onNewNote(this);
	}
}
