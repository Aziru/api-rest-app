package com.aziru.restworld.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_in_role")
public class UserInRole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Role role;

    public UserInRole() {
    }

    public UserInRole(final User user, final Role role) {
	this.user = user;
	this.role = role;
    }

    /**
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Integer id) {
	this.id = id;
    }

    /**
     * @return the role
     */
    public Role getRole() {
	return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(final Role role) {
	this.role = role;
    }

    /**
     * @return the user
     */
    public User getUser() {
	return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(final User user) {
	this.user = user;
    }

    @Override
    public int hashCode() {
	final var prime = 31;
	var result = 1;
	result = (prime * result) + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(final Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final var other = (UserInRole) obj;
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	return true;
    }
}
