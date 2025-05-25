import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Base class for a Person
class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }
}

// Candidate class
class Candidate extends Person {
    private int votes;

    public Candidate(String name) {
        super(name);
        this.votes = 0;
    }

    public void vote() {
        votes++;
    }

    public int getVotes() {
        return votes;
    }

    public String getName() {
        return name;
    }
}

// Voter class
class Voter extends Person {
    private boolean hasVoted;
    private String voterID;

    public Voter(String name, String voterID) {
        super(name);
        this.voterID = voterID;
        this.hasVoted = false;
    }

    public boolean getHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean status) {
        this.hasVoted = status;
    }

    public String getVoterID() {
        return voterID;
    }
}

// Voting System class
public class VotingSystem {
    private ArrayList<Candidate> candidates = new ArrayList<>();
    private HashMap<String, Voter> voterMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addCandidate(String name) {
        candidates.add(new Candidate(name));
    }

    public void addVoter(String name, String voterID) {
        voterMap.put(voterID, new Voter(name, voterID));
    }

    public void startVoting() {
        System.out.print("Enter your Voter ID to vote: ");
        String id = scanner.nextLine();

        if (voterMap.containsKey(id)) {
            Voter voter = voterMap.get(id);
            if (!voter.getHasVoted()) {
                System.out.println("Hello " + voter.name + ", please vote by entering the candidate number:");
                for (int i = 0; i < candidates.size(); i++) {
                    System.out.println((i + 1) + ". " + candidates.get(i).getName());
                }

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (choice > 0 && choice <= candidates.size()) {
                    candidates.get(choice - 1).vote();
                    voter.setHasVoted(true);
                    System.out.println("Thank you for voting!");
                } else {
                    System.out.println("Invalid choice!");
                }
            } else {
                System.out.println("You have already voted.");
            }
        } else {
            System.out.println("Invalid Voter ID!");
        }
    }

    public void showResults() {
        System.out.println("\n=== Voting Results ===");
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getName() + ": " + candidate.getVotes() + " votes");
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        Scanner input = new Scanner(System.in);

        // Setup candidates
        System.out.print("Enter number of candidates: ");
        int numCandidates = input.nextInt();
        input.nextLine(); // consume newline

        for (int i = 0; i < numCandidates; i++) {
            System.out.print("Enter candidate " + (i + 1) + " name: ");
            String cname = input.nextLine();
            system.addCandidate(cname);
        }

        // Setup voters
        System.out.print("Enter number of voters: ");
        int numVoters = input.nextInt();
        input.nextLine(); // consume newline

        for (int i = 0; i < numVoters; i++) {
            System.out.print("Enter voter " + (i + 1) + " name: ");
            String vname = input.nextLine();
            System.out.print("Enter voter " + (i + 1) + " ID: ");
            String vid = input.nextLine();
            system.addVoter(vname, vid);
        }

        // Voting loop
        String continueVoting;
        do {
            system.startVoting();
            System.out.print("Continue voting? (yes/no): ");
            continueVoting = input.nextLine();
        } while (continueVoting.equalsIgnoreCase("yes"));

        // Show results
        system.showResults();
    }
}
