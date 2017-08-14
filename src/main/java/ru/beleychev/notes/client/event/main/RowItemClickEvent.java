package ru.beleychev.notes.client.event.main;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Implementation of {@link com.google.gwt.event.shared.GwtEvent<RowItemClickEventHandler>}
 * @author beleychev.ilya 10.08.2017   15:27
 */
public class RowItemClickEvent extends GwtEvent<RowItemClickEventHandler> {
	public static Type<RowItemClickEventHandler> TYPE = new Type<>();

	@Override
	public Type<RowItemClickEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RowItemClickEventHandler handler) {
		handler.onRowItemClick(this);
	}
}
