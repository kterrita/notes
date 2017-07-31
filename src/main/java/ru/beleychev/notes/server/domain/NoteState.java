package ru.beleychev.notes.server.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Note State entity
 * @author beleychev.ilya 31.07.2017   13:42
 */
@Entity
@Table(name = "note_states")
public class NoteState implements Serializable {
	private Long id;
	private String description;
	private String systemName;
}
