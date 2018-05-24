package ufcg.daca.questions;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
	private int id;
	private String title;
	private String description;
	private Category category;
	
	@ElementCollection
	private List<String> keywords;
	@ElementCollection
	private List<Integer> votings;
	
	public Question() {
		
	}
	
	public Question(int id, String title, String description, Category category, List<String> keywords, List<Integer> votings) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.keywords = keywords;
		this.votings = votings;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public List<Integer> getVotings() {
		return votings;
	}
	public void setVotings(List<Integer> votings) {
		this.votings = votings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
