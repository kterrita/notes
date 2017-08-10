package ru.beleychev.notes.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Interface for handler processing representation of favorite notes
 * @author beleychev.ilya 10.08.2017   15:20
 */
public interface FavoriteEventHandler extends EventHandler {
	void onFavoriteEvent(FavoriteEvent event);
}
