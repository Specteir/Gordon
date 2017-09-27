package cmd;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class BasicCmd extends Command{

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);

        if (isValidCommand()) {
            String command = getArgs().get(1);
            if (command.equals("hello")) {
                getChannel().sendMessage("Hello, and welcome!").queue();
            }
            else if (command.equals("who")) {
                getChannel().sendMessage("You are " + getAuthor().getName()).queue();
            }
        }
        else {
            return;
        }
    }
}
