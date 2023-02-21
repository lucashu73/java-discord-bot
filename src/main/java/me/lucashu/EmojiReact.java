package me.lucashu;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EmojiReact extends ListenerAdapter {

    public static final String downvote = "downvote:764013174894231582";
    public static final String upvote = "upvote:764013152613564436";

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        String nick = "413867977851797506";
        String lucas = "389193841057726464";
        String siha = "659000940614909963";

        if (event.getAuthor().getId().equals(siha)) {
            event.getMessage().addReaction(downvote).queue();
        } else if (event.getAuthor().getId().equals(nick)) {
            event.getMessage().addReaction("U+1F913").queue();
        } else if (event.getAuthor().getId().equals(lucas)) {
            event.getMessage().addReaction(upvote).queue();
        }

    }

}
