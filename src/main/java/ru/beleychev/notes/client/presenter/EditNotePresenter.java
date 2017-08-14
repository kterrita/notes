package ru.beleychev.notes.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import ru.beleychev.notes.client.NotesGwtServiceAsync;
import ru.beleychev.notes.client.view.NewNoteView;
import ru.beleychev.notes.shared.dto.NoteDTO;

/**
 * New note page presenter
 * Created by ilya on 13.08.2017.
 */
public class EditNotePresenter implements Presenter, NewNoteView.Presenter {
    private NoteDTO noteDTO;
    private final NotesGwtServiceAsync rpcService;
    private final HandlerManager eventBus;
    private final NewNoteView view;

    public EditNotePresenter(NotesGwtServiceAsync rpcService, HandlerManager eventBus, NewNoteView view) {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.view = view;
        this.view.setPresenter(this);
        this.noteDTO = view.getNoteData();
    }

    public EditNotePresenter(NotesGwtServiceAsync rpcService, HandlerManager eventBus, NewNoteView view, NoteDTO noteDTO) {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.view = view;
        this.view.setPresenter(this);
        this.noteDTO = noteDTO;
    }

    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(view.asWidget());
        view.setNoteData(noteDTO);
    }

    @Override
    public void onFavoriteCheckBoxClicked() {
        noteDTO.setFavorite(!noteDTO.isFavorite());
    }

    @Override
    public void onApplyButtonClicked() {
        rpcService.saveNote(noteDTO, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Exception while saving Note");
            }

            @Override
            public void onSuccess(Void result) {
                Window.alert("Note has been saved correctly");
            }
        });
    }
}
