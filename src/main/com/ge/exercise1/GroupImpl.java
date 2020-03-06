package com.ge.exercise1;

import java.util.ArrayList;
import java.util.List;

public class GroupImpl extends Group{

	String data;
	List<UserImpl> users = new ArrayList<UserImpl>();

	public GroupImpl(String data, List<UserImpl> users) {
		this.data = data;
		this.users = users;
	}

	public GroupImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupImpl(String id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public List<UserImpl> getUsers() {
		return users;
	}

	public void setUsers(List<UserImpl> users) {
		this.users = users;
	}
	
}
