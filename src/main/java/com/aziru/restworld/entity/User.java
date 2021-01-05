package com.aziru.restworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String userName;

    @Column
    private String nickName;

    @Column
    private String password;

    private static final long serialVersionUID = -3885972747117635195L;

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
     * @return the userName
     */
    public String getUserName() {
	return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(final String userName) {
	this.userName = userName;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
	return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(final String nickName) {
	this.nickName = nickName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password) {
	this.password = password;
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
	final var other = (User) obj;
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
