package ru.beleychev.notes.client.event.main;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Implementation of {@link com.google.gwt.event.shared.GwtEvent<SearchNoteEventHandler>}
 * @author beleychev.ilya 10.08.2017   15:04
 */
public class SearchNoteEvent extends GwtEvent<SearchNoteEventHandler> {
	public static Type<SearchNoteEventHandler> TYPE = new Type<>();

	@Override
	public Type<SearchNoteEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SearchNoteEventHandler handler) {
		handler.onSearchNote(this);
	}
}
