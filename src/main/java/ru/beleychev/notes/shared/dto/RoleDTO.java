package ru.beleychev.notes.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.Set;


/**
 * Yeap. My Project)
 * Created by ilya on 21.07.2017.
 */
public class RoleDTO implements IsSerializable {
    private Long id;
    private String roleName;
    private Set<UserDTO> users;

    public RoleDTO() {
    }

    public RoleDTO(Long id) {
        this.id = id;
    }

    public RoleDTO(Long id, String roleName, Set<UserDTO> users) {
        this.id = id;
        this.roleName = roleName;
        this.users = users;
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

	public Set<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDTO> users) {
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
