package ru.beleychev.notes.client.widget;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.view.client.*;
import ru.beleychev.notes.shared.dto.NoteDTO;

import java.util.Date;

/**
 * Yeap. My Project)
 * Created by ilya on 14.08.2017.
 */
public class CustomDataGrid extends Composite {
    private DataGrid<NoteDTO> notesList;

    public CustomDataGrid() {
        ListDataProvider<NoteDTO> dataProvider = new ListDataProvider<>();
        // set key provider for identify rows
        ProvidesKey<NoteDTO> keyProvider = item -> item == null ? null : item.getId();
        notesList = new DataGrid<>(keyProvider);
        // set selection model for select row by clicking checkbox opportunity
        SelectionModel<NoteDTO> selectionModel = new MultiSelectionModel<>(keyProvider);
        notesList.setSelectionModel(selectionModel, DefaultSelectionEventManager.createCheckboxManager());
        //set sortHandler for sorting capability
        ColumnSortEvent.ListHandler<NoteDTO> sortHandler = new ColumnSortEvent.ListHandler<>(dataProvider.getList());
        notesList.addColumnSortHandler(sortHandler);

        Column<NoteDTO, Boolean> checkColumn = new Column<NoteDTO, Boolean>(new CheckboxCell(true, false)) {
            @Override
            public Boolean getValue(NoteDTO noteDTO) {
                return selectionModel.isSelected(noteDTO);
            }
        };
        Column<NoteDTO, String> titleColumn = new Column<NoteDTO, String>(new TextCell()) {
            @Override
            public String getValue(NoteDTO noteDTO) {
                return noteDTO.getTitle();
            }
        };

        Column<NoteDTO, Date> dateCreatedColumn = new Column<NoteDTO, Date>(new DateCell()) {
            @Override
            public Date getValue(NoteDTO noteDTO) {
                return noteDTO.getDateCreated();
            }
        };

        notesList.addColumn(checkColumn);
        notesList.addColumn(titleColumn, "Title");
        notesList.addColumn(dateCreatedColumn, "Created Date");

        initWidget(notesList);
    }

    public DataGrid<NoteDTO> getNotesList() {
        return notesList;
    }
}
