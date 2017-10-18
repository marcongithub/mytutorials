package com.mytutorial.components.model;

import java.io.Serializable;

public class BancAccount implements Serializable{
	
	private Integer accountNr;
	private Integer blz;
	private String bancName;
	
	
	public String getBancName() {
		return bancName;
	}
	public void setBancName(String bancName) {
		this.bancName = bancName;
	}
    public Integer getAccountNr() {
        return accountNr;
    }
    public void setAccountNr(Integer accountNr) {
        this.accountNr = accountNr;
    }
    public Integer getBlz() {
        return blz;
    }
    public void setBlz(Integer blz) {
        this.blz = blz;
    }
	

}
