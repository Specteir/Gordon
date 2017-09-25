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

    public final String IDENTIFIER = ".g";

    private Scanner scanner;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
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
}
