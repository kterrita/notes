package ru.beleychev.notes.client.dto;

import java.io.Serializable;

/**
 * Yeap. My Project)
 * Created by ilya on 21.07.2017.
 */
public class RoleDTO implements Serializable {
    private Long id;
    private String roleName;

    public RoleDTO() {
    }

    public RoleDTO(Long id) {
        this.id = id;
    }

    public RoleDTO(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
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
