package ufcg.daca.questions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	private QuestionFactory QUESTION_FACTORY;
	private List<Question> questions;
	
	public QuestionService() {
		QUESTION_FACTORY = new QuestionFactory();
		questions = QUESTION_FACTORY.createAllQuestions();
	}

	public List<Question> getAllQuestions() {
		//return questions;
		List<Question> questions = new ArrayList<Question>();
		questionRepository.findAll()
						  .forEach(questions::add);
		
		return questions;
	}
	
	public Question getQuestion(int id) {
		return getAllQuestions().stream().filter(q -> q.getId()==id).findFirst().get();
	}

	public void addQuestion(Question question) {
		//questions.add(question);
		questionRepository.save(question);
	}

	public void updateQuestion(int id, Question question) {
		for (int i = 0; i < questions.size(); i++) {
			if(questions.get(i).getId()==id) {
				questions.set(i, question);
				return;
			}
		}
	}

	public void deleteQuestion(int id) {
		questions.removeIf(t -> t.getId() == id);
	}

}
