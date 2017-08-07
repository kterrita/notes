package ru.beleychev.notes.server.domain;

import ru.beleychev.notes.shared.dto.NoteDTO;
import ru.beleychev.notes.shared.dto.NoteTypeDTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Note Type entity
 * @author beleychev.ilya 31.07.2017   13:42
 */
@Entity
@Table(name = "note_types")
public class NoteType implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "type_id")
	private Long id;
	@Column(name = "description")
	private String description;
	@Column(name = "systemname")
	private String systemName;
	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
	private Set<Note> notes = new HashSet<>();

	public NoteType() {
	}

	public NoteType(NoteTypeDTO noteTypeDTO) {
		this.id = noteTypeDTO.getId();
		this.description = noteTypeDTO.getDescription();
		this.systemName = noteTypeDTO.getSystemName();
		Set<NoteDTO> noteDTOs = noteTypeDTO.getNotes();
		Set<Note> notes = new HashSet<>();
		for (NoteDTO noteDTO : noteDTOs) {
			notes.add(new Note(noteDTO));
		}
		this.notes = notes;
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

	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "NoteType{" +
		       ", systemName='" + systemName + '\'' +
		       '}';
	}
}
