package cmd;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.entities.Message;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Command extends ListenerAdapter {

    private User author;
    private Message message;
    private String content;
    private MessageChannel channel;
    private ArrayList<String> args;
    private boolean validCommand;

    public final String IDENTIFIER = ".g";

    private Scanner scanner;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        clearFields();
        if (event.getMessage().getContent().startsWith(IDENTIFIER) && !(event.getAuthor().isBot())) {
            author = event.getAuthor();
            message = event.getMessage();
            content = message.getContent();
            channel = event.getChannel();

            args = new ArrayList<String>();
            scanner = new Scanner(content);
            scanner.useDelimiter(" ");
            while (scanner.hasNext()) {
                args.add(scanner.next());
            }
//            for (int i = 0;i<args.size();i++) {
//                System.out.println(args.get(i));
//            }
            validCommand = true;
        } else {
            validCommand = false;
        }
    }

    public User getAuthor() {
        return author;
    }

    public Message getMessage() {
        return message;
    }

    public String getContent() {
        return content;
    }

    public MessageChannel getChannel() {
        return channel;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public boolean isValidCommand() {
        return validCommand;
    }

    private void clearFields() {
        author = null;
        message = null;
        content = null;
        channel = null;
        args = null;
    }

}
