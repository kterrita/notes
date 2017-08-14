package ru.beleychev.notes.client.view;

import com.google.gwt.user.client.ui.Widget;
import ru.beleychev.notes.shared.dto.NoteDTO;
import ru.beleychev.notes.shared.dto.UserDTO;

/**
 * Yeap. My Project)
 * Created by ilya on 13.08.2017.
 */
public interface NewNoteView {
    interface Presenter {
        void onFavoriteCheckBoxClicked();
        void onApplyButtonClicked();
    }

    void setPresenter(Presenter presenter);
    void setNoteData(NoteDTO noteDTO);
    NoteDTO getNoteData();
    Widget asWidget();
}
