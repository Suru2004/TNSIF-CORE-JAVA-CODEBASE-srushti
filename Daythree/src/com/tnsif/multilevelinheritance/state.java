package com.tnsif.multilevelinheritance;

public class state extends County{
	private String statename;
	private String language;
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "state [statename=" + statename + ", language=" + language + ", getStatename()=" + getStatename()
				+ ", getLanguage()=" + getLanguage() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	
	

}
