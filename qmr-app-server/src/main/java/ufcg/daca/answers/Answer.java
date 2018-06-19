package ufcg.daca.answers;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public enum Answer {
	SIM(1), NAO(-1), NAO_SEI(0);
	
	@Id
	private int id;
	private int value;
	
	Answer(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
