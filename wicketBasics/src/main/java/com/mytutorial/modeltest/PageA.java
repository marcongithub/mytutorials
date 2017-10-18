package com.mytutorial.modeltest;

public class PageA {

	TheModelObject theModelObject;

	public PageA(TheModelObject theModelObject) {
		this.theModelObject = theModelObject;
	}

	public void getModelObjectsValue() {
		if (this.theModelObject != null)
			System.out.println("ModelObjectsValue: "
					+ theModelObject.getSomeValue());
		else
			System.out.println("ModelObjectsValue is null");
	}

}
