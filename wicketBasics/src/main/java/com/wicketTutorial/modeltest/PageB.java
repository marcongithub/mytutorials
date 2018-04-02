package com.wicketTutorial.modeltest;

public class PageB {
	
	TheModelObject theModelObject;
	PageA pageA;
	
	public PageB(){
		this.theModelObject=null;
		this.pageA=new PageA(theModelObject);
	}
	
	
	public static void main(String a[]){
		PageB pageB=new PageB();
		pageB.pageA.getModelObjectsValue();
		pageB.theModelObject=new TheModelObject();
		pageB.pageA.getModelObjectsValue();
	}

}
