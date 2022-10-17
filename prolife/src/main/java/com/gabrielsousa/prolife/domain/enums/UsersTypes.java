package com.gabrielsousa.prolife.domain.enums;

public enum UsersTypes {
	
	PACIENT(1,"ROLE_PACIENT"),
	DOCTOR(2,"ROLE_DOCTOR"),
	DIRECTOR(3,"ROLE_DIRECTOR"),
	HOSPITAL(5,"ROLE_HOSPITAL"),
	ASSISTANT(6,"ROLE_ASSISTANT"),
	ORGANIZATION(7,"ROLE_ORGANIZATION"),
	ADMIN(8,"ROLE_ADMIN");
	
	private int cod;
	private String description;
	
	private UsersTypes(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static UsersTypes toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		
		for(UsersTypes x : UsersTypes.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
	public static UsersTypes toCod(String cod) {
		if(cod==null) {
			return null;
		}
		
		for(UsersTypes x : UsersTypes.values()) {
			if(cod.equals(x.getDescription())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
