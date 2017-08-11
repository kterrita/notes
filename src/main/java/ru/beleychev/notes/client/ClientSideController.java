package ru.beleychev.notes.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import ru.beleychev.notes.client.event.AllNotesEvent;
import ru.beleychev.notes.client.event.DeletedNotesEvent;
import ru.beleychev.notes.client.event.FavoriteEvent;
import ru.beleychev.notes.client.event.ImportantEvent;
import ru.beleychev.notes.client.presenter.NotesPresenter;
import ru.beleychev.notes.client.presenter.Presenter;
import ru.beleychev.notes.client.ui.MainPanel;
import ru.beleychev.notes.client.view.NotesView;

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

    public ClientSideController(HandlerManager eventBus, NotesGwtServiceAsync rpcService) {
        this.eventBus = eventBus;
        this.rpcService = rpcService;
        bind();
    }

    private void bind() {
        History.addValueChangeHandler(this);
        eventBus.addHandler(AllNotesEvent.TYPE, event -> doAllNotes());
        eventBus.addHandler(FavoriteEvent.TYPE, event -> doAllNotes());
        eventBus.addHandler(ImportantEvent.TYPE, event -> doAllNotes());
        eventBus.addHandler(DeletedNotesEvent.TYPE, event -> doAllNotes());
    }

    private void doAllNotes() {
        History.newItem("all");
    }

    @Override
    public void go(HasWidgets container) {
        this.container = container;

        if ("".equals(History.getToken())) {
            History.newItem("all");
        } else {
            History.fireCurrentHistoryState();
        }
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        String token = event.getValue();

        if (token != null) {
            if (token.equals("all")) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {

                    }

                    @Override
                    public void onSuccess() {
                        if (view == null) {
                            view = new MainPanel();
                        }
                        new NotesPresenter(rpcService, eventBus, view)
                                .go(container);
                    }
                });
            }
        }


    }
}
