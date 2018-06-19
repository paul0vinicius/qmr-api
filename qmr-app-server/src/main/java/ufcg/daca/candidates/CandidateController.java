package ufcg.daca.candidates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@RequestMapping("candidates")
	public List<Candidate> getAllCandidates(){
		return candidateService.getAllCandidates();
	}
	
	@RequestMapping("candidates/{id}")
	public Candidate getCandidate(@PathVariable int id){
		return candidateService.getCandidate(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/candidates")
	public void addCandidate(@RequestBody Candidate candidate) {
		candidateService.addCandidate(candidate);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/candidates/{id}")
	public void updateCandidate(@RequestBody Candidate candidate, @PathVariable int id) {
		candidateService.updateCandidate(id, candidate);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/candidates/{id}")
	public void deleteCandidate(@PathVariable int id) {
		candidateService.deleteCandidate(id);
	}
	
	// Doesn't make sense... How to get the answers?
	@RequestMapping(method=RequestMethod.PUT, value="/candidates/{idCandidate}/{idQuestion}/{answer}")
	public void answerQuestion(@PathVariable int idCandidate, @PathVariable int idQuestion, @PathVariable int answer) {
		candidateService.answerQuestion(idCandidate, idQuestion, answer);
	}
	
}
