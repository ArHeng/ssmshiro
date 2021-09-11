package com.zking.ssm.model;

public class Role {
    private Integer roleid;

    private String rolename;

    private String description;

    public Role(Integer roleid, String rolename, String description) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.description = description;
    }

    public Role() {
        super();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}