package com.mytutorial.generics;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private final List<? extends Team<? extends Person, ? extends Person>> teams;

	public Department(List<? extends Team<? extends Person, ? extends Person>> teams) {
		super();
		this.teams = teams;
	}

	public List<? extends Team<? extends Person, ? extends Person>> getTeams() {
		return teams;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// doesnt compile
		// Team<Person,Person> team = new ScrumTeam();
		Team<StaffMember, StaffMember> team = new ScrumTeam();

		Team<?, ?> teamWcard = new ScrumTeam();
		// doesnt compile
		// teamWcard.setTeamlead(new Person());

		Team<? extends StaffMember, ? extends StaffMember> teamWcardExtends = new ScrumTeam();
		// doesnt compile
		// teamWcardExtends.setTeamlead(new StaffMember());
		// teamWcardExtends.setTeamlead(new Employee());

		Team<? super StaffMember, ? super StaffMember> teamSuper = new ScrumTeam();
		teamSuper.setTeamlead(new StaffMember());
		Person teamLeadPerson = teamSuper.getTeamlead();

	}
	
	

	public static void superExample() {

		Team aTeam = new ScrumTeam();
		aTeam.setTeamlead(new Manager());

		List<? super Integer> superTypeOfIntegerList = new ArrayList<>();
		List<Object> numberList = new ArrayList<>();
		Object stringObject = new String("asfd");
		numberList.add(stringObject);

		numberList.add(1);
		superTypeOfIntegerList = numberList;
		superTypeOfIntegerList.add(2);
		superTypeOfIntegerList.add(new Integer(4));

		Object drei = 3;
		Number x = new Double(1.2);
		Number y = new Integer(5);

		// doesnt compile
		// superTypeOfIntegerList.add(drei);
		// superTypeOfIntegerList.add(x);
		// superTypeOfIntegerList.add(y);

		// for each loop with lower bound wildcard works only with Object
		for (Object i : superTypeOfIntegerList) {
			System.out.println(i);
		}

	}

}
