package ru.beleychev.notes.server.domain;

import ru.beleychev.notes.shared.dto.RoleDTO;
import ru.beleychev.notes.shared.dto.UserDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
	private Set<User> users = new HashSet<>();

	public Role() {
	}

	public Role(RoleDTO roleDTO) {
		this.id = roleDTO.getId();
		this.roleName = roleDTO.getRoleName();
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role{" +
		       "id=" + id +
		       ", roleName='" + roleName + '\'' +
		       '}';
	}
}
