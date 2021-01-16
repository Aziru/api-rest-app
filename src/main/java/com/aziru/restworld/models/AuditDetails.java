package com.aziru.restworld.models;

public class AuditDetails {

    private String createdBy;

    private String roleName;

    public AuditDetails(final String createdBy, final String roleName) {
	this.createdBy = createdBy;
	this.roleName = roleName;
    }

    public AuditDetails() {
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
	return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(final String createdBy) {
	this.createdBy = createdBy;
    }

    /**
     * @return the roleName
     */
    public String getRoleName() {
	return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(final String roleName) {
	this.roleName = roleName;
    }

}
