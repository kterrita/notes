package ru.beleychev.notes.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Interface for handle selectItems event in dataGrid
 * @author beleychev.ilya 10.08.2017   15:27
 */
public interface RowItemClickEventHandler extends EventHandler {
	void onRowItemClick(RowItemClickEvent event);
}
