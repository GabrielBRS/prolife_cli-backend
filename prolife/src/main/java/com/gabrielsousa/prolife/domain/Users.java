package com.gabrielsousa.prolife.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gabrielsousa.prolife.domain.enums.UsersTypes;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class Users implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique=true)
	@Email
	private String email;
	
	@JsonIgnore
	private String password;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	@ElementCollection
	@CollectionTable(name="TELEPHONE")
	private Set<String> telefones = new HashSet<>();
	
	public Users() {
		
	}
	
	public Users(Integer id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
//	public Users(Integer id, String organizationName,String email, String cpf, String password) {
//		this.id = id;
//		this.organizationName = organizationName;
//		this.email = email;
//		this.cpf = cpf;
//		this.password = password;
//	}
//	
//	public Users(Integer id, String fristName,String lastName,String email, String cpf, String password) {
//		this.id = id;
//		this.fristName = fristName;
//		this.lastName = lastName;
//		this.email = email;
//		this.cpf = cpf;
//		this.password = password;
//	}
	
	public void addPerfil(UsersTypes perfil) {
		perfis.add(perfil.getCod());
	}

	public Set<UsersTypes> getPerfis() {	
		return perfis.stream().map(x-> UsersTypes.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void setPerfis(Set<Integer> usersTypes) {
		this.perfis = usersTypes;
	}
	
	public void addUserType(UsersTypes usersTypes) {
		perfis.add(usersTypes.getCod());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + ", email=" + email + ", cpf=" + ", userType="
				+ ", telefones=" + telefones + ", perfis=" + perfis + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(id, other.id);
	}
	
}
