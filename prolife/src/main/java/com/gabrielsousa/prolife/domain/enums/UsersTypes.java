package com.gabrielsousa.prolife.domain.enums;

public enum UsersTypes {
	
	PACIENT(1,"Paciente"),
	DOCTOR(2,"Doutor"),
	DIRECTOR(3,"Diretor"),
	HOSPITAL(5,"Hospital"),
	ASSISTANT(6,"Assistente"),
	ORGANIZATION(7,"Organização"),
	ADMIN(8,"Admin");
	
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
}
