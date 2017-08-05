package ru.beleychev.notes.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;
import ru.beleychev.notes.server.domain.NoteState;
import ru.beleychev.notes.server.domain.NoteType;
import ru.beleychev.notes.server.domain.User;

import java.util.Date;

/**
 * Yeap. My Project)
 * Created by ilya on 05.08.2017.
 */
public class NoteDTO implements IsSerializable {
    private Long id;
    private String uuid;
    private boolean favorite;
    private Date dateCreated;
    private String content;
    private String title;
    private NoteTypeDTO type;
    private NoteStateDTO state;
    private User user;

    public NoteDTO() {
    }

    public NoteDTO(Long id) {
        this.id = id;
    }

    public NoteDTO(Long id, String uuid, boolean favorite, Date dateCreated, String content, String title, NoteTypeDTO type, NoteStateDTO state, User user) {
        this.id = id;
        this.uuid = uuid;
        this.favorite = favorite;
        this.dateCreated = dateCreated;
        this.content = content;
        this.title = title;
        this.type = type;
        this.state = state;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NoteTypeDTO getType() {
        return type;
    }

    public void setType(NoteTypeDTO type) {
        this.type = type;
    }

    public NoteStateDTO getState() {
        return state;
    }

    public void setState(NoteStateDTO state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "NoteDTO{" +
                "uuid='" + uuid + '\'' +
                '}';
    }
}
