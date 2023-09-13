package com.github.gigazin.allen.commands;

import com.github.gigazin.allen.settings.Client;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TestCommand extends ListenerAdapter {

    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equalsIgnoreCase("allentest")) {
            switch (Client.getCurrentLanguage()) {
                case "pt-BR" -> event.reply("comando reconhecido").queue();
                case "en-US" -> event.reply("command recognized").queue();
            }
        }
    }

}
