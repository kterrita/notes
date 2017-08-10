package ru.beleychev.notes.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Implementation of {@link com.google.gwt.event.shared.GwtEvent<RowItemSelectEventHandler>}
 * @author beleychev.ilya 10.08.2017   16:40
 */
public class RowItemSelectEvent extends GwtEvent<RowItemSelectEventHandler> {
	public static Type<RowItemSelectEventHandler> TYPE = new Type<>();

	@Override
	public Type<RowItemSelectEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RowItemSelectEventHandler handler) {
		handler.onRowItemSelected(this);
	}
}
