package ru.beleychev.notes.server.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Note Type entity
 * @author beleychev.ilya 31.07.2017   13:42
 */
@Entity
@Table(name = "note_types")
public class NoteType implements Serializable {
	private Long id;
	private String description;
	private String systemName;
}
