package ca.dantav.vote;

public final class Voter {
	
	private final String name;
	
	private final Candidate candidate;
	
	public Voter(String name, Candidate candidate) {
		this.name= name;
		this.candidate = candidate;
	}
	
	public String getName() {
		return name;
	}
	
	public Candidate getCandidate() {
		return candidate;
	}

}
