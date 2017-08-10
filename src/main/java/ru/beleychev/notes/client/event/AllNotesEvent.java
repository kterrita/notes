package ru.beleychev.notes.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Implementation of {@link com.google.gwt.event.shared.GwtEvent<AllNotesEventHandler>}
 * @author beleychev.ilya 10.08.2017   15:14
 */
public class AllNotesEvent extends GwtEvent<AllNotesEventHandler> {
	public static Type<AllNotesEventHandler> TYPE = new Type<>();

	@Override
	public Type<AllNotesEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AllNotesEventHandler handler) {
		handler.onAllNotes(this);
	}
}
