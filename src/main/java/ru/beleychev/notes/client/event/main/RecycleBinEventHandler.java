package ru.beleychev.notes.client.event.main;

import com.google.gwt.event.shared.EventHandler;

/**
 * Interface for handler processing representation of Recycle Bin
 * @author beleychev.ilya 10.08.2017   15:23
 */
public interface RecycleBinEventHandler extends EventHandler {
	void onRecycleBin(RecycleBinEvent event);
}
