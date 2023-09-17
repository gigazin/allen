package com.github.gigazin.allen.commands;

import com.github.gigazin.allen.settings.Client;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * @author gigazin
 * @version 1.0.0
 * @since 09/16/2023
 */
public class SlashCommands extends ListenerAdapter {

    /**
     * Checks the received command and responds to it.
     *
     * @param event The command received from a Discord chat.
     */
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        /*
         * Checks the received command by its name and responds to it.
         */
        switch (event.getName()) {

            /*
             * Checks whether the received command is the 'allentest' command.
             * Responds in the current language Allen is set to use.
             * TODO -> Use database query to get the current language.
             */
            case "allentest" -> {
                switch (Client.getCurrentLanguage()) {
                    case "pt-BR" -> event.reply("comando reconhecido").queue();
                    case "en-US" -> event.reply("command recognized").queue();
                }

            }

        }

    }

}
