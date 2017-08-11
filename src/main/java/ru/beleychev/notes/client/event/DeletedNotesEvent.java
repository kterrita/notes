package ru.beleychev.notes.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Implementation of {@link com.google.gwt.event.shared.GwtEvent<DeletedNotesEventHandler>}
 * @author beleychev.ilya 11.08.2017   15:23
 */
public class DeletedNotesEvent extends GwtEvent<DeletedNotesEventHandler> {
	public static Type<DeletedNotesEventHandler> TYPE = new Type<>();

	@Override
	public Type<DeletedNotesEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DeletedNotesEventHandler handler) {
		handler.onDeletedNotes(this);
	}
}
