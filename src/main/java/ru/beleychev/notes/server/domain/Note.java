package ru.beleychev.notes.server.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Note entity
 * @author beleychev.ilya 21.07.2017   15:21
 */

@Entity
@Table(name = "notes")
public class Note implements Serializable {

	private Long id;
	private UUID uuid;
	private boolean favorite;
	private Date dateCreated;
	private NoteType noteType;
	private String content;
	private User user;
	private NoteState noteState;
	private String title;
}
