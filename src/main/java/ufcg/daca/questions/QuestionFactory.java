package ufcg.daca.questions;

import java.util.ArrayList;
import java.util.List;

public class QuestionFactory {
	
	private final int QUESTIONS_LIST_SIZE = 10;
	
	public List<Question> createAllQuestions(){
		// Importar e ler a partir de um csv ou algo assim... 
		// São questões predefinidas
		List<Question> questions = new ArrayList<Question>();
		
		for (int i = 0; i < QUESTIONS_LIST_SIZE; i++) {
			ArrayList<String> keywords = new ArrayList<String>();
			ArrayList<Integer> votings = new ArrayList<Integer>();
			votings.add(1);
			votings.add(2);
			keywords.add("Generic");
			keywords.add("Democracy");
			Question q = new Question(i,""+i,"Lorus Epsum",Category.DEMOCRACIA,
					keywords, votings);
			questions.add(q);
		}
		
		return questions;
	}

}
