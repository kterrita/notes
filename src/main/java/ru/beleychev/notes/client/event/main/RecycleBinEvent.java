package ru.beleychev.notes.client.event.main;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Implementation of {@link com.google.gwt.event.shared.GwtEvent<RecycleBinEventHandler>}
 * @author beleychev.ilya 10.08.2017   15:22
 */
public class RecycleBinEvent extends GwtEvent<RecycleBinEventHandler> {
	public static Type<RecycleBinEventHandler> TYPE = new Type<>();

	@Override
	public Type<RecycleBinEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RecycleBinEventHandler handler) {
		handler.onRecycleBin(this);
	}
}
