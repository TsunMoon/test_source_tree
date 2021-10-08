package com.export.excel_ver1.model;


public class Users {
    private Integer id;
    private String email;
    private String password;
    private String fullname;
    private boolean enabled;
    private Integer roleId;

    public Users() {
    }

    public Users(Integer id, String email, String password, String fullname, boolean enabled, Integer roleId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.enabled = enabled;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
