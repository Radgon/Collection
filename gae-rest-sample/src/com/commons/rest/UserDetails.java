package com.commons.rest;

import java.io.Serializable;
import java.util.Date;

public class UserDetails implements Serializable{


	/**
	 * SUID
	 */
	private static final long serialVersionUID = 5575631176975902415L;

	String name;

	Date lastLoggedInAt;

	boolean locked;

	public UserDetails(String name, Date lastLoggedInAt, boolean locked) {
		this.name = name;
		this.lastLoggedInAt = lastLoggedInAt;
		this.locked = locked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastLoggedInAt() {
		return lastLoggedInAt;
	}

	public void setLastLoggedInAt(Date lastLoggedInAt) {
		this.lastLoggedInAt = lastLoggedInAt;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
		return String.format("[name: %s, last logged in at: %s, is locked: %s]", name, lastLoggedInAt, locked);
	}

}
