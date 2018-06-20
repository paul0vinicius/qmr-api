package ufcg.daca.candidates;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ufcg.daca.credentials.Credential;

@Entity
public class Candidate {
	
	@Id
	private int id;
	
	private String fullName;
	private String nickname;
	private String party;
	private String state;
	private int age;
	private String photo;
	private boolean isAlreadyDeputy;
	
	@OneToOne
	private Credential credential;

	// Replace for Answers and questions after...
	@ElementCollection
	private Map<Integer, Integer> answers = new HashMap<Integer, Integer>();
	
	public Candidate() {
		
	}
	
	public Candidate(int id, String fullname, String nickname, String party,
			String state, int age, String photo, boolean isAlreadyDeputy) {
		super();
		this.id = id;
		this.fullName = fullname;
		this.nickname = nickname;
		this.party = party;
		this.state = state;
		this.age = age;
		this.photo = photo;
		this.isAlreadyDeputy = isAlreadyDeputy;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isAlreadyDeputy() {
		return isAlreadyDeputy;
	}

	public void setAlreadyDeputy(boolean isAlreadyDeputy) {
		this.isAlreadyDeputy = isAlreadyDeputy;
	}

	public Map<Integer, Integer> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<Integer, Integer> answers) {
		this.answers = answers;
	}
	
	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	
	public void answerQuestion(int idQuestion, int answer) {
		answers.put(idQuestion, answer);
	}
}
