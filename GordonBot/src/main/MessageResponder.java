package main;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageResponder extends ListenerAdapter {
	private static final String IDENTIFIER = ".g ";

	public void onMessageReceived(MessageReceivedEvent event) {
		String message = event.getMessage().getContent();
		String name = event.getAuthor().getName();

		if (message.startsWith(IDENTIFIER + "hello")) {
			name = event.getAuthor().getName();

			String response = name + ", hello and welcome";

			event.getTextChannel().sendMessage(response).queue();
		} else if (message.startsWith(IDENTIFIER + "who")) {

			String response = "You are " + name;

			event.getTextChannel().sendMessage(response).queue();
		}
	}
}
