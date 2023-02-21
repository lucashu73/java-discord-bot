package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class BotCommands extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("hello")) {
            event.reply("Hello!").queue();
        } else if (event.getName().equals("ubc")) {
            OptionMapping option1 = event.getOption("subject");
            OptionMapping option2 = event.getOption("code");

            if (option1 == null || option2 == null) {
                event.reply("Please enter a subject and course code.").queue();
                return;
            }

            String subject = option1.getAsString().toUpperCase();
            int code = option2.getAsInt();

            event.reply("https://courses.students.ubc.ca/cs/courseschedule?pname=subjarea&tname=subj-course&dept="
                    +subject+"&course="+code
                    +"\n"+"https://ubcgrades.com/statistics-by-course#UBCV-"+subject+"-"+code).queue();
        } else if (event.getName().equals("lol")) {
            OptionMapping option = event.getOption("champion");

            if (option == null) {
                event.reply("Please enter the name of a champion.").queue();
                return;
            }

            String champion = option.getAsString().replaceAll("\\s+", "");

            event.reply("https://na.op.gg/champions/"+champion).queue();
        } else if (event.getName().equals("aram")) {
            OptionMapping option = event.getOption("champion");

            if (option == null) {
                event.reply("Please enter the name of a champion.").queue();
                return;
            }

            String champion = option.getAsString().replaceAll("\\s+", "");

            event.reply("https://na.op.gg/modes/aram/"+champion+"/build").queue();
        } else if (event.getName().equals("ld")) { // WIP
            OptionMapping option1 = event.getOption("champion");
            OptionMapping option2 = event.getOption("level");

            if (option1 == null || option2 == null) {
                event.reply("Please enter a champion and player level.").queue();
                return;
            }

            String champion = option1.getAsString().replaceAll("\\s+", "").toLowerCase();
            int level = option2.getAsInt();

            if (level < 3 || level > 11) {
                event.reply("Please enter a valid player level.").queue();
            } else {
                event.reply("stub").queue();
            }
        }

    }
}
