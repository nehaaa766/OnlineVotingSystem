# 🗳️ Online Voting System (Java Console Application)

This project is a **console-based online voting system** developed in Java. It uses **object-oriented programming principles** to manage candidates, voters, and the voting process. It allows users to register candidates and voters, cast votes using unique Voter IDs, and displays the final election results.

## 📌 Features

- Register multiple candidates and voters.
- Prevent double voting using Voter ID verification.
- Record and count votes for candidates.
- Display final voting results.
- Console-based user interaction.

## 🧱 Classes Used

### `Person`
- Base class for `Voter` and `Candidate`.
- Contains common attribute: `name`.

### `Candidate` (extends `Person`)
- Represents a candidate.
- Tracks vote count.
- Methods: `vote()`, `getVotes()`, `getName()`

### `Voter` (extends `Person`)
- Represents a voter.
- Contains `voterID` and voting status.
- Methods: `getHasVoted()`, `setHasVoted()`, `getVoterID()`

### `VotingSystem`
- Core class that:
  - Adds candidates and voters.
  - Starts the voting process.
  - Prevents double voting.
  - Displays results.

## 🖥️ How It Works

1. **Admin Inputs**:
   - Number of candidates and their names.
   - Number of voters and their details (name + unique Voter ID).

2. **Voting**:
   - Voters cast votes using their Voter ID.
   - The system ensures a voter cannot vote twice.

3. **Results**:
   - After voting ends, vote counts for each candidate are displayed.

## 🚀 How to Run

1. **Clone or Download** the repository.
2. **Compile** the Java file:

   ```bash
   javac VotingSystem.java
