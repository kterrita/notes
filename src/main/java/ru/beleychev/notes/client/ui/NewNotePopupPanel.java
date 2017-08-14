package ru.beleychev.notes.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import ru.beleychev.notes.client.view.NewNoteView;
import ru.beleychev.notes.shared.dto.NoteDTO;

import java.util.Date;

/**
 * View for new note
 * Created by ilya on 13.08.2017.
 */
public class NewNotePopupPanel extends Composite implements NewNoteView {
    interface NewNotePopupPanelUiBinder extends UiBinder<PopupPanel, NewNotePopupPanel> {
    }

    private static NewNotePopupPanelUiBinder ourUiBinder = GWT.create(NewNotePopupPanelUiBinder.class);


    @UiField
    PopupPanel popupPanel;
    @UiField
    VerticalPanel newNoteMainPanel;
    @UiField
    HorizontalPanel newNoteHeader;
    @UiField
    Label storedNoteTitle;
    @UiField
    DateLabel noteCreatedDate;
    @UiField
    VerticalPanel contentPanel;
    @UiField
    TextBox currentNoteTitle;
    @UiField
    RichTextArea contentTextArea;
    @UiField
    HorizontalPanel newNoteFooter;
    @UiField
    CheckBox favorite;
    @UiField
    Button save;
    @UiField
    Button close;

    private Presenter presenter;

    static {
        Resources.INSTANCE.style().ensureInjected();
    }

    public NewNotePopupPanel() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("favorite")
    void onFavoriteCheckBoxClicked(ClickEvent event) {
        if (presenter != null) {
            presenter.onFavoriteCheckBoxClicked();
        }
    }

    @UiHandler("save")
    void onApplyButtonClicked(ClickEvent event) {
        if (presenter != null) {
            presenter.onApplyButtonClicked();
        }
    }

    @UiHandler("close")
    void onCancelButtonClicked(ClickEvent event) {
        popupPanel.hide();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setNoteData(NoteDTO noteDTO) {
        if (noteDTO != null) {
            storedNoteTitle.setText(noteDTO.getTitle());
            noteCreatedDate.setValue(noteDTO.getDateCreated());
            currentNoteTitle.setText(noteDTO.getTitle());
            contentTextArea.setText(noteDTO.getContent());
            favorite.setValue(noteDTO.isFavorite());
        } else {
            noteCreatedDate.setValue(new Date());
            favorite.setValue(false);
        }
    }

    @Override
    public NoteDTO getNoteData() {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setFavorite(favorite.getValue());
        noteDTO.setDateCreated(noteCreatedDate.getValue());
        noteDTO.setTitle(currentNoteTitle.getTitle());
        noteDTO.setContent(contentTextArea.getHTML());
        return noteDTO;
    }

    @Override
    public Widget asWidget() {
        return this;
    }
}