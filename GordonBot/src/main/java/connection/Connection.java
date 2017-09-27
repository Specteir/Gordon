package connection;

import javax.security.auth.login.LoginException;

import cmd.BasicCmd;
import cmd.ReportCmd;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class Connection {
	private static final String DISCORD_TOKEN = "MzA1NTQ3MjQ4OTM3MzM2ODMz.DJ-BdA.oiGLfMRpuMEWIjneJ5qfa5yTVFQ";

	public static void main(String[] args) {

		JDA discord = null;

		try {
			discord = new JDABuilder(AccountType.BOT).setToken(DISCORD_TOKEN).buildBlocking();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RateLimitedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discord.addEventListener(new BasicCmd());
		discord.addEventListener(new ReportCmd());
	}
}
