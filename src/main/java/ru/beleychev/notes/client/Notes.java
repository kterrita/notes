package ru.beleychev.notes.client;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import ru.beleychev.notes.shared.dto.UserDTO;

import java.util.Date;
import java.util.List;

/**
 * Main gwt class with UI building
 *
 * @author beleychev.ilya 17.07.2017   16:07
 * @version 1.0
 * @since 17.07.2017
 */
public class Notes implements EntryPoint {
    private NotesGwtServiceAsync notesGwtServiceAsync = GWT.create(NotesGwtService.class);

    @Override
    public void onModuleLoad() {

    }
}
