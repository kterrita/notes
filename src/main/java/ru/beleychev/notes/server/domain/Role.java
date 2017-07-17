package ru.beleychev.notes.server.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Yeap. My Project)
 * Created by ilya on 05.07.2017.
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private Long id;

	@Column(name = "role_name")
	private String roleName;

	public Role() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role{" +
		       "id=" + id +
		       ", roleName='" + roleName + '\'' +
		       '}';
	}
}
