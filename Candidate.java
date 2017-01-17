package ca.dantav.vote;

import java.util.Arrays;
import java.util.Optional;

public enum Candidate {
	
	DONALD_TRUMP("Donald Trump"),
	
	HILLARY_CLINTON("Hillary Clintion");
	
	private String name;
	
	Candidate(String name) {
		this.name = name;
	}
	
	public static Optional<Candidate> forName(String name) {
		return Arrays.stream(values()).filter((Candidate c) -> c.getName().equalsIgnoreCase(name)).findFirst();
	}
	
	public String getName() {
		return name;
	}
	


}
