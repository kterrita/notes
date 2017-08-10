package ru.beleychev.notes.server.domain;

import ru.beleychev.notes.shared.dto.NoteDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Note entity
 *
 * @author beleychev.ilya 21.07.2017   15:21
 */

@Entity
@Table(name = "notes")
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "note_id")
    private Long id;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "favorite")
    private boolean favorite;
    @Column(name = "important")
    private boolean important;
    @Column(name = "date_created")
    private Date dateCreated;
    @Column(name = "content")
    private String content;
    @Column(name = "title")
    private String title;
    @Column(name = "type_id")
    private Long typeId;
    @Column(name = "state_id")
    private Long stateId;
    @Column(name = "user_id")
    private Long userId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", insertable = false, updatable = false)
    private NoteType type;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id", insertable = false, updatable = false)
    private NoteState state;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Note() {
    }

    public Note(NoteDTO noteDTO) {
        this.id = noteDTO.getId();
        this.uuid = noteDTO.getUuid();
        this.favorite = noteDTO.isFavorite();
        this.important = noteDTO.isImportant();
        this.dateCreated = noteDTO.getDateCreated();
        this.content = noteDTO.getContent();
        this.title = noteDTO.getTitle();
        this.typeId = noteDTO.getTypeId();
        this.stateId = noteDTO.getStateId();
        this.userId = noteDTO.getUserId();
        this.type = new NoteType(noteDTO.getType());
        this.state = new NoteState(noteDTO.getState());
        this.user = new User(noteDTO.getUser());
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

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
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

    public Long getTypeID() {
        return typeId;
    }

    public void setTypeID(Long typeID) {
        this.typeId = typeID;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public NoteType getType() {
        return type;
    }

    public void setType(NoteType type) {
        this.type = type;
    }

    public NoteState getState() {
        return state;
    }

    public void setState(NoteState state) {
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
        return "Note{" +
                ", uuid=" + uuid +
                '}';
    }
}
