package ru.beleychev.notes.client.event.main;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Implementation of {@link com.google.gwt.event.shared.GwtEvent<FavoriteEventHandler>}
 * @author beleychev.ilya 10.08.2017   15:20
 */
public class FavoriteEvent extends GwtEvent<FavoriteEventHandler> {
	public static Type<FavoriteEventHandler> TYPE = new Type<>();

	@Override
	public Type<FavoriteEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(FavoriteEventHandler handler) {
		handler.onFavoriteEvent(this);
	}
}
