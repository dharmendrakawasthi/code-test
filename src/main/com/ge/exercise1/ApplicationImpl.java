package com.ge.exercise1;

import java.util.ArrayList;
import java.util.Collection;

public class ApplicationImpl extends Application{

	Collection<UserImpl> users = new ArrayList<UserImpl>();
	Collection<GroupImpl> groups = new ArrayList<GroupImpl>();
	
	
	public ApplicationImpl() {}

	public ApplicationImpl(String id, String name) {
		super(id, name);
	}

	@Override
	public Collection<UserImpl> getUsers() {
		return users;
	}

	@Override
	public User getUser(String userId) {
		for(User user: users){
			if(user.getId().equals(userId)){
				return user;
			}
		}
		return null;
	}

	@Override
	public Collection<GroupImpl> getGroups() {
		return groups;
	}

	@Override
	public Group getGroup(String groupId) {
		for(Group group: groups){
			if(group.getId().equals(groupId)){
				group.size = 1;
				return group;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "ApplicationImpl [users=" + users + ", groups=" + groups + "]";
	}

}
