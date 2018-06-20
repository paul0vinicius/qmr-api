package ufcg.daca.questions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("questions")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@RequestMapping("questions/{id}")
	public Question getQuestion(@PathVariable int id) {
		return questionService.getQuestion(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/questions")
	public void addQuestion(@RequestBody Question question) {
		questionService.addQuestion(question);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/questions/{id}")
	public void updateQuestion(@RequestBody Question question, @PathVariable int id) {
		questionService.updateQuestion(id, question);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/questions/{id}")
	public void deleteQuestion(@PathVariable int id) {
		questionService.deleteQuestion(id);
	}

}
