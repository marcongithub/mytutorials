package com.mytutorial.lambda;

public class TestPerson {

	private boolean male;

	private String firstName;

	private String surName;

	private int age;
	
	

	public TestPerson(String firstName, String surName) {
		super();
		this.firstName = firstName;
		this.surName = surName;
	}

	public TestPerson() {
	}

	public String getName() {
		return firstName + " " + surName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isOlderThan(int age) {
		return this.age > age;
	}
	
	public boolean sameName(TestPerson person) {
		return person.getName().equals(this.getName());
	}
	
	public TestPerson changeFirstName(String firstName) {
		this.firstName=firstName;
		return this;
	}
	
	public void doSomething() {
		
	}
	
	

}
