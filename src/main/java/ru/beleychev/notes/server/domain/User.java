package ru.beleychev.notes.server.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
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
@Table(name = "users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "username", unique = true)
	@NotEmpty(message = "*Please provide username")
	private String username;

	@Column(name = "password")
	@Length(min = 4, message = "*Your password must be at least 4 characters")
	@NotEmpty(message = "*Please provide a password")
	private String password;

	@Column(name = "first_name")
	@NotEmpty(message = "*Please provide your first name")
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;

	@Column(name = "email")
	@NotEmpty(message = "*Please provide an email")
	@Email(message = "Please provide a valid email")
	private String email;

	@OneToMany(mappedBy = "user")
	private Set<Note> notes = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(UserDTO userDTO) {
		this.id = userDTO.getId();
		this.username = userDTO.getUsername();
		this.password = userDTO.getPassword();
		this.firstName = userDTO.getFirstName();
		this.lastName = userDTO.getLastName();
		this.email = userDTO.getEmail();
		Set<RoleDTO> roleDTOs = userDTO.getRoles();
		if (roleDTOs != null) {
			Set<Role> roles = new HashSet<>(roleDTOs.size());
			for (RoleDTO roleDTO : roleDTOs) {
				roles.add(new Role(roleDTO));
			}
			this.roles = roles;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "User{" +
		       "id=" + id +
		       ", username='" + username + '\'' +
		       '}';
	}
}
