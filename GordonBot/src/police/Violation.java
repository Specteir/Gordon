package police;

public class Violation {
	int votes;
	int onlineUsers;

	public Violation(int onlineUsers) {
		this.onlineUsers = onlineUsers;
		votes = 0;
	}

	public void addVote() {
		votes++;
	}

	public int getVotes() {
		return votes;
	}
}
