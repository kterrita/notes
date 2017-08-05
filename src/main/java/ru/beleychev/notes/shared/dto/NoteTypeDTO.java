package ru.beleychev.notes.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.HashSet;
import java.util.Set;

/**
 * Yeap. My Project)
 * Created by ilya on 05.08.2017.
 */
public class NoteTypeDTO implements IsSerializable {
    private Long id;
    private String description;
    private String systemName;
    private Set<NoteDTO> notes = new HashSet<>();

    public NoteTypeDTO(Long id, String description, String systemName, Set<NoteDTO> notes) {
        this.id = id;
        this.description = description;
        this.systemName = systemName;
        this.notes = notes;
    }

    public NoteTypeDTO(Long id) {

        this.id = id;
    }

    public NoteTypeDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Set<NoteDTO> getNotes() {
        return notes;
    }

    public void setNotes(Set<NoteDTO> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "NoteTypeDTO{" +
                "systemName='" + systemName + '\'' +
                '}';
    }
}
