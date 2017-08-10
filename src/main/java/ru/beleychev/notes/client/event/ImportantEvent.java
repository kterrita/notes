package ru.beleychev.notes.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Implementation of {@link com.google.gwt.event.shared.GwtEvent<ImportantEventHandler>}
 * @author beleychev.ilya 10.08.2017   15:17
 */
public class ImportantEvent extends GwtEvent<ImportantEventHandler> {
	public static Type<ImportantEventHandler> TYPE = new Type<>();

	@Override
	public Type<ImportantEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ImportantEventHandler handler) {
		handler.onImportantEvent(this);
	}
}
