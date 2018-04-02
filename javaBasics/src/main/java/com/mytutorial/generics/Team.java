package com.mytutorial.generics;

import java.util.ArrayList;
import java.util.List;

public abstract class Team<P extends Person, T extends Person> {
	
	private T teamlead;
	
	private List<P> teamMember = new ArrayList<>();

	public T getTeamlead() {
		return teamlead;
	}

	public void setTeamlead(T teamlead) {
		this.teamlead = teamlead;
	}

	public List<P> getTeamMember() {
		return teamMember;
	}
	
	abstract List<Person> getPersons();
	
	public void addTeamMember(P person) {
		this.teamMember.add(person);
	}
	
}
