package me.lucashu;

import commands.BotCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    private static String bot_token = "insert bot token here";

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA bot = JDABuilder.createDefault(bot_token)
                .setActivity(Activity.playing("Glimpse Of Us by Joji"))
                .addEventListeners(new Megamind())
                .addEventListeners(new EmojiReact())
                .addEventListeners(new BotCommands())
                .build().awaitReady();

        Guild guild1 = bot.getGuildById("741498293359476787");
        Guild guild2 = bot.getGuildById("762122181957648405");

        createGuild(guild1);
        createGuild(guild2);

    }

    public static void createGuild(Guild guild) {
        if (guild != null) {
            guild.upsertCommand("hello", "Says hello").queue();
            guild.upsertCommand("ubc", "Search for a UBC course")
                    .addOption(OptionType.STRING, "subject", "the subject name (ex. MATH)", true)
                    .addOption(OptionType.INTEGER, "code", "the course code (ex. 100)", true)
                    .queue();
            guild.upsertCommand("lol", "Enter champion for op.gg")
                    .addOption(OptionType.STRING, "champion", "the name of the champion (ex. annie)", true)
                    .queue();
            guild.upsertCommand("aram", "Enter ARAM champion for op.gg")
                    .addOption(OptionType.STRING, "champion", "the name of the champion (ex. annie)", true)
                    .queue();
            guild.upsertCommand("ld", "Enter champion and player level for loaded dice odds") // WIP
                    .addOption(OptionType.STRING, "champion", "the name of champion (ex. annie)", true)
                    .addOption(OptionType.INTEGER, "level", "your player level (3 - 11)", true)
                    .queue();
        }
    }


}
