package com.mytutorial.generics;

import java.util.ArrayList;
import java.util.List;

public class CommandControlTeam extends Team<StaffMember, Manager> {

	@Override
	List<Person> getPersons() {
		List<Person> wholeTeam = new ArrayList<>();
		wholeTeam.addAll(this.getTeamMember());
		wholeTeam.add(this.getTeamlead());

		return wholeTeam;
	}

}
