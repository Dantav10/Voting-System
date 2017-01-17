package ca.dantav.vote;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class VoteManager {
	
	private final List<Voter> voters = new ArrayList<>();
	
	public void cast() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Voting [Y/N]? ");
		String anwser = scanner.nextLine();
		
		if(anwser.equalsIgnoreCase("Y")) {
			vote();
		} else if(anwser.equalsIgnoreCase("N")) {
			lookup();
		}
		
		
		scanner.close();
	}
	
	public void lookup() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What person are you looking up?");
		String name = scanner.nextLine();

		Optional<Voter> voter = voters.stream().filter((Voter v) -> v.getName().equalsIgnoreCase(name)).findFirst();
		
		if(voter.isPresent()) {
			System.out.println("[" + voter.get().getName() + "] is voting for " + voter.get().getCandidate().getName());
		} else {
			System.out.println("Error not real name");
		}
		
		cast();
		scanner.close();
	}

	
	public void vote() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Name");
		String name = scanner.nextLine();
		System.out.println("Enter Candidate");
		String candidateName = scanner.nextLine();
		
		Optional<Candidate> candidate = Candidate.forName(candidateName);
		
		if(candidate.isPresent()) {
			Voter voter = new Voter(name, candidate.get());
			voters.add(voter);
		} else {
			System.out.println("Error not real name");
		}
		
		cast();
		scanner.close();
	}


}
