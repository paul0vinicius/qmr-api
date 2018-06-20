package ufcg.daca.candidates;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	private CandidateFactory CANDIDATE_FACTORY;
	private List<Candidate> candidates;
	
	public CandidateService() {
		CANDIDATE_FACTORY = new CandidateFactory();
		candidates = new ArrayList<Candidate>();
	}
	
	public List<Candidate> getAllCandidates(){
		List<Candidate> candidates = new ArrayList<Candidate>();
		candidateRepository.findAll()
						  .forEach(candidates::add);
		
		return candidates;
	}
	
	public Candidate getCandidate(int id) {
		return getAllCandidates().stream().filter(q -> q.getId()==id).findFirst().get();
	}
	
	public void addCandidate(Candidate candidate) {
		candidateRepository.save(candidate);
	}
	
	public void updateCandidate(int id, Candidate candidate) {
		for (int i = 0; i < candidates.size(); i++) {
			if(candidates.get(i).getId()==id) {
				candidates.set(i, candidate);
				return;
			}
		}
	}
	
	public void deleteCandidate(int id) {
		candidates.removeIf(t -> t.getId() == id);
	}
	
	public void answerQuestion(int idCandidate, int idQuestion, int answer) {
		getAllCandidates().stream().filter(q -> q.getId()==idCandidate).findFirst().get().answerQuestion(idQuestion, answer);
	}
}
