package com.jpetstore.utils;

public enum PetCategories {
	
	
	FISH("Fish"),
	CATS("Cats"),
	DOGS("Dogs"),
	REPTILES("Reptiles"),
	BIRDS("Birds");
	
	private String value;
	
	private PetCategories(String value) {
		
		this.value = value;
	}
	
	public String getValue() {
		
		return value;
	}
	
}
