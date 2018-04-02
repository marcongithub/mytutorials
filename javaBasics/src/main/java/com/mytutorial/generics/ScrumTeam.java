package com.mytutorial.generics;

import java.util.ArrayList;
import java.util.List;

public class ScrumTeam extends Team<StaffMember,StaffMember>{

	@Override
	List<Person> getPersons() {
		List<Person> wholeTeam = new ArrayList<>();
		wholeTeam.addAll(this.getTeamMember());
		return wholeTeam;
	}
	
	

}
