package ru.beleychev.notes.client.event.main;

import com.google.gwt.event.shared.EventHandler;

/**
 * Interface which handle selected rows
 * @author beleychev.ilya 10.08.2017   16:39
 */
public interface RowItemSelectEventHandler extends EventHandler {
	void onRowItemSelected(RowItemSelectEvent event);
}
