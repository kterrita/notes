package ru.beleychev.notes.client.event.main;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.cellview.client.DataGrid;
import ru.beleychev.notes.shared.dto.NoteDTO;

/**
 * Yeap. My Project)
 * Created by ilya on 13.08.2017.
 */
public class EditNoteEvent extends GwtEvent<EditNoteEventHandler> {
    public static Type<EditNoteEventHandler> TYPE = new Type<EditNoteEventHandler>();
    private NoteDTO noteDTO;

    public EditNoteEvent(NoteDTO noteDTO) {
        this.noteDTO = noteDTO;
    }

    public NoteDTO getNoteDTO() {
        return noteDTO;
    }

    public Type<EditNoteEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(EditNoteEventHandler handler) {
        handler.onEditNote(this);
    }
}
