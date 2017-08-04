package ru.beleychev.notes.server.domain;

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
 * Note State entity
 * @author beleychev.ilya 31.07.2017   13:42
 */
@Entity
@Table(name = "note_states")
public class NoteState implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "state_id")
	private Long id;
	@Column(name = "description")
	private String description;
	@Column(name = "systemname")
	private String systemName;
	@OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
	private Set<Note> notes = new HashSet<>();

	public NoteState() {
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

	@Override
	public String toString() {
		return "NoteState{" +
		       "id=" + id +
		       ", description='" + description + '\'' +
		       ", systemName='" + systemName + '\'' +
		       '}';
	}
}
