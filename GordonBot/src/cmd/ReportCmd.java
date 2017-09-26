package cmd;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.entities.User;

public class ReportCmd extends Command{
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);
        JDA jda = event.getJDA();

        if (isValidCommand()) {
            String command = getArgs().get(1);
            if (command.equals("report")) {
                User reporter = getAuthor();
                try {
                    User reported = jda.getUsersByName( getArgs().get(2), true).get(0);
                    String reportType = getArgs().get(3);
                } catch (IndexOutOfBoundsException e) {
                    getChannel().sendMessage("Invalid report command").queue();
                }
            }
        }
    }
}
