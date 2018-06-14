package ufcg.daca.candidates;

public class CandidateFactory {
	
	public Candidate createCandidate(int id, String fullname, String nickname, String party,
			String state, int age, String photo, boolean isAlreadyDeputy) {
		
		return new Candidate(id, fullname, nickname,party, state, age, photo, isAlreadyDeputy);
	}
}
