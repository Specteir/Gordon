package cmd;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class BasicCmd extends Command{

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);

        if (getArgs().get(0).equals(IDENTIFIER)) {
            if (getArgs().get(1).equals("hello")) {
                getChannel().sendMessage("Hello, and welcome!").queue();
            }
        }
        else {
            return;
        }
    }
}
