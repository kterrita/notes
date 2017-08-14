package ru.beleychev.notes.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import ru.beleychev.notes.client.event.main.*;
import ru.beleychev.notes.client.presenter.EditNotePresenter;
import ru.beleychev.notes.client.presenter.NotesPresenter;
import ru.beleychev.notes.client.presenter.Presenter;
import ru.beleychev.notes.client.ui.MainPanel;
import ru.beleychev.notes.client.ui.NewNotePopupPanel;
import ru.beleychev.notes.client.view.NotesView;
import ru.beleychev.notes.client.widget.CustomDataGrid;
import ru.beleychev.notes.shared.dto.NoteDTO;

/**
 * GWT controller
 *
 * @author beleychev.ilya 11.08.2017   15:09
 */
public class ClientSideController implements Presenter, ValueChangeHandler<String> {
    private final HandlerManager eventBus;
    private final NotesGwtServiceAsync rpcService;
    private HasWidgets container;
    private NotesView view = null;

    ClientSideController(HandlerManager eventBus, NotesGwtServiceAsync rpcService) {
        this.eventBus = eventBus;
        this.rpcService = rpcService;
        bind();
    }

    private void bind() {
        History.addValueChangeHandler(this);
        eventBus.addHandler(NewNoteEvent.TYPE, event -> doAddNote());
        eventBus.addHandler(EditNoteEvent.TYPE, event -> doEditNote(event.getNoteDTO()));
        eventBus.addHandler(AllNotesEvent.TYPE, event -> doAllNotes());
        eventBus.addHandler(FavoriteEvent.TYPE, event -> doAllNotes());
        eventBus.addHandler(ImportantEvent.TYPE, event -> doAllNotes());
        eventBus.addHandler(DeletedNotesEvent.TYPE, event -> doAllNotes());
    }

    private void doAllNotes() {
        History.newItem("main");
    }

    private void doEditNote(NoteDTO noteDTO) {
        History.newItem("edit", false);
        Presenter presenter = new EditNotePresenter(rpcService, eventBus, new NewNotePopupPanel(), noteDTO);
        presenter.go(container);
    }

    private void doAddNote() {
        History.newItem("add");
        Presenter presenter = new EditNotePresenter(rpcService, eventBus, new NewNotePopupPanel());
        presenter.go(container);
    }

    @Override
    public void go(HasWidgets container) {
        this.container = container;

        if ("".equals(History.getToken())) {
            History.newItem("main");
        } else {
            History.fireCurrentHistoryState();
        }
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        String token = event.getValue();

        if (token != null) {
            if (token.equals("main")) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        Window.alert("Cannot build UI");
                    }

                    @Override
                    public void onSuccess() {
                        if (view == null) {
                            view = new MainPanel(new CustomDataGrid());
                        }
                        new NotesPresenter(rpcService, eventBus, view)
                                .go(container);
                    }
                });
            }
        }


    }
}
