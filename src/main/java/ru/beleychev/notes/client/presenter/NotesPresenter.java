package ru.beleychev.notes.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.view.client.SetSelectionModel;
import ru.beleychev.notes.client.NotesGwtServiceAsync;
import ru.beleychev.notes.client.event.main.EditNoteEvent;
import ru.beleychev.notes.client.event.main.NewNoteEvent;
import ru.beleychev.notes.client.view.NotesView;
import ru.beleychev.notes.shared.dto.NoteDTO;
import ru.beleychev.notes.shared.dto.UserDTO;

import java.util.List;
import java.util.Set;

/**
 * Main page presenter
 *
 * @author beleychev.ilya 10.08.2017   16:53
 */
public class NotesPresenter implements Presenter, NotesView.Presenter {
    private List<NoteDTO> noteDTOs;
    private final NotesGwtServiceAsync rpcService;
    private final HandlerManager eventBus;
    private final NotesView view;

    public NotesPresenter(NotesGwtServiceAsync rpcService, HandlerManager eventBus, NotesView view) {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.view = view;
        this.view.setPresenter(this);
    }

    /**
     * This method starts every time, you return to main page
     *
     * @param container passing view
     */
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(view.asWidget());
        fillNotesDataGrid();
        fillUserDetails();
    }

    @Override
    public void onSearchButtonClicked() {

    }

    @Override
    public void onSearchTextBoxPressed() {

    }

    @Override
    public void onNewNoteButtonClicked() {
        eventBus.fireEvent(new NewNoteEvent());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onEditNoteButtonClicked() {
        SetSelectionModel<NoteDTO> selectionModel = (SetSelectionModel<NoteDTO>) view.getData().getSelectionModel();
        Set<NoteDTO> selectedRows = selectionModel.getSelectedSet();
        if (selectedRows.size() == 1) {
            NoteDTO selectedNote = selectedRows.iterator().next();
            eventBus.fireEvent(new EditNoteEvent(selectedNote));
        } else if (selectedRows.size() == 0) {
            Window.alert("Please select at least 1 note.");
        } else {
            Window.alert("You cant edit more than one note at the same time, please check only one note to edit.");
        }
    }

    @Override
    public void onAllNotesButtonClicked() {
        fillNotesDataGrid();
    }

    @Override
    public void onImportantButtonClicked() {
        fillImportantNotes();
    }

    @Override
    public void onFavoriteButtonClicked() {
        fillFavoriteNotes();
    }

    @Override
    public void onRecycleBinButtonClicked() {
        fillDeletedNotes();
    }

    /**
     * filling user details
     */
    private void fillUserDetails() {
        rpcService.getCurrentUser(new AsyncCallback<UserDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error was caught while application were filling user details");
            }

            @Override
            public void onSuccess(UserDTO result) {
                view.setUserDetails(result);
            }
        });
    }

    /**
     * filling notes dataGrid
     */
    private void fillNotesDataGrid() {
        rpcService.getCurrentUserNotes(new AsyncCallback<List<NoteDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error was caught while application were filling note grid");
            }

            @Override
            public void onSuccess(List<NoteDTO> result) {
                noteDTOs = result;
                view.setRowData(noteDTOs);
            }
        });
    }

    /**
     * filling favorite notes to dataGrid
     */
    private void fillFavoriteNotes() {
        rpcService.getFavoriteNotes(new AsyncCallback<List<NoteDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error was caught while application were filling favorite notes");
            }

            @Override
            public void onSuccess(List<NoteDTO> result) {
                noteDTOs = result;
                view.setRowData(noteDTOs);
            }
        });
    }

    /**
     * filling important notes to dataGrid
     */
    private void fillImportantNotes() {
        rpcService.getImportantNotes(new AsyncCallback<List<NoteDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error was caught while application were filling favorite notes");
            }

            @Override
            public void onSuccess(List<NoteDTO> result) {
                noteDTOs = result;
                view.setRowData(noteDTOs);
            }
        });
    }

    /**
     * filling deleted notes to dataGrid
     */
    private void fillDeletedNotes() {
        rpcService.getDeletedNotes(new AsyncCallback<List<NoteDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error was caught while application were filling favorite notes");
            }

            @Override
            public void onSuccess(List<NoteDTO> result) {
                noteDTOs = result;
                view.setRowData(noteDTOs);
            }
        });
    }
}
