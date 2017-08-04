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
		return "NoteType{" +
		       "id=" + id +
		       ", description='" + description + '\'' +
		       ", systemName='" + systemName + '\'' +
		       '}';
	}
}
