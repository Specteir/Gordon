package main;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageResponder extends ListenerAdapter {
	private static final String IDENTIFIER = ".g ";
	String response;
	CommandManager commander = new CommandManager();

	public void onMessageReceived(MessageReceivedEvent event) {
		String message = event.getMessage().getContent();

		if (message.startsWith(IDENTIFIER + "hello")) {
			response = commander.hello(event);
			event.getTextChannel().sendMessage(response).queue();
		} else if (message.startsWith(IDENTIFIER + "who")) {

			response = commander.who(event);

			event.getTextChannel().sendMessage(response).queue();
		} else if (message.startsWith(IDENTIFIER + "register")) {
			response = commander.register(event);
		} else if (message.startsWith(IDENTIFIER + "report")) {
			String userName = message.substring(11);
			String violationType;
			if (message.contains("text")) {
				violationType = "text";
			} else {
				violationType = "music";
			}
			response = commander.report(event);
		} else if (message.startsWith(IDENTIFIER)) {
			event.getTextChannel().sendMessage("Invalid command").queue();
		}
	}
}
