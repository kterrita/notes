package ru.beleychev.notes.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "note_id")
	private Long id;
	@Column(name = "uuid")
	private UUID uuid;
	@Column(name = "favorite")
	private boolean favorite;
	@Column(name = "date_created")
	private Date dateCreated;
	@Column(name = "type_id")
	private Long noteTypeId;
	@Column(name = "content")
	private String content;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "state_id")
	private Long noteStateId;
	@Column(name = "title")
	private String title;
}
