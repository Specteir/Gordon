package user;

/**
 * Represents a registered user in the system using Gordon Holds all violations
 * issued if the votes pass
 * 
 * @author jack
 *
 */
public class User {
	String userName;
	int musicViolations;
	int textViolations;
	String startDate;

	public User() {
		userName = "";
		musicViolations = 0;
		textViolations = 0;
		startDate = "";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMusicViolations() {
		return musicViolations;
	}

	public void setMusicViolations(int musicViolations) {
		this.musicViolations = musicViolations;
	}

	public int getTextViolations() {
		return textViolations;
	}

	public void setTextViolations(int textViolations) {
		this.textViolations = textViolations;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		String string = new String();
		string = getUserName() + "\nMusic Violations: " + getMusicViolations() + "\nText Violations: "
				+ getTextViolations() + "\nStart Date: " + getStartDate();
		return string;
	}

}
