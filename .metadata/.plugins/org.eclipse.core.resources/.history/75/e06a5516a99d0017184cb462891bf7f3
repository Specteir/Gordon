package main;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import user.User;
import user.UserManager;

/**
 * Command manager executes all commands and does vote calculations on
 * violations
 * 
 * @author jack
 *
 */
public class CommandManager {
	UserManager userManager = new UserManager("Users/UserList.xml");

	public String hello(MessageReceivedEvent event) {
		String name = event.getAuthor().getName();

		String response = name + ", hello and welcome";

		return response;
	}

	public String who(MessageReceivedEvent event) {
		return event.getAuthor().getName();
	}

	// Registers a user if they are not registered already
	public String register(MessageReceivedEvent event) {
		User user = userManager.getUser(event.getAuthor().getName());
		if (user != null) {
			return event.getAuthor().getName() + " is already registered";
		} else {
			user = new User();
			user.setUserName(event.getAuthor().getName());
			userManager.addUser(user);
			return event.getAuthor().getName() + " has been registered";
		}
	}
}
