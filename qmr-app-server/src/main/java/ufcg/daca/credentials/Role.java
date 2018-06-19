package ufcg.daca.credentials;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	private Long id;
	@Enumerated(EnumType.STRING)
	private RoleName name;
	
	public Role() {
		
	}
	
	public Role(RoleName name) {
		this.setName(name);
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
