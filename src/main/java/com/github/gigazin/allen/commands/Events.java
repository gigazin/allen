package com.github.gigazin.allen.commands;

import com.github.gigazin.allen.settings.Default;
import com.github.gigazin.allen.settings.Client;
import com.github.gigazin.allen.database.Queries;

import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import org.jetbrains.annotations.NotNull;

/**
 * @author gigazin
 * @version 1.0.0
 * @since 09/16/2023
 */
public class Events extends ListenerAdapter {

    /**
     * Checks if the received message is a legacy (prefix) command and responds to the command.
     *
     * @param event The event/message received from a Discord chat.
     */
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] message = event.getMessage().getContentRaw().split(" "); // Splitting the message.

        /*
         * if (message[0]...) -> Checks if the first part of the message is a prefix.
         * switch (message[1]) -> Checks if the following part of the message is a command and responds to it.
         */
        if (message[0].equalsIgnoreCase(Client.getCurrentPrefix()) || message[0].equalsIgnoreCase(Default.DEFAULT_PREFIX)) {
            switch (message[1].toLowerCase()) {

                /*
                 * Checks whether the received command is the 'test' command.
                 * Responds in the current language Allen is set to use.
                 * TODO -> Use database query to get the current language.
                 */
                case "test" -> {
                    switch (Client.getCurrentLanguage()) {
                        case "pt-BR" -> event.getMessage().getChannel().sendMessage("evento reconhecido").queue();
                        case "en-US" -> event.getMessage().getChannel().sendMessage("event recognized").queue();
                    }

                }

                /*
                 * Checks whether the command is the 'lang' command.
                 * switch (message[2] -> Checks the input and changes the language accordingly to it.
                 *   "         "      -> Responds in the new language Allen is set to use.
                 * TODO -> Use database query to change the language.
                 */
                case "lang" -> {
                    switch (message[2]) {
                        case "ptBR", "pt-BR", "pt_BR" -> {
                            Client.setCurrentLanguage("pt-BR");
                            if (Client.getCurrentLanguage().equalsIgnoreCase("pt-BR"))
                                event.getMessage().getChannel().sendMessage("Idioma alterado para `" + Client.getCurrentLanguage() + "`").queue();
                        }

                        case "enUS", "en-US", "en_US" -> {
                            Client.setCurrentLanguage("en-US");
                            if (Client.getCurrentLanguage().equalsIgnoreCase("en-US"))
                                event.getMessage().getChannel().sendMessage("Changed language to `" + Client.getCurrentLanguage() + "`").queue();
                        }

                        default -> {
                            if (Client.getCurrentLanguage().equalsIgnoreCase("pt-BR"))
                                event.getMessage().getChannel().sendMessage("""
                                        Falha ao alterar o idioma. Certifique-se de utilizar o comando no formato correto.""").queue();
                            else if (Client.getCurrentLanguage().equalsIgnoreCase("en-US"))
                                event.getMessage().getChannel().sendMessage("""
                                        Language not changed. Make sure you use the command in the correct format.""").queue();
                        }

                    }

                }

            }

        }

    }

    /**
     * Checks whether the bot has joined a guild and runs
     * a query to insert the guild into the database.
     *
     * @param event The event containing the info from the guild.
     */
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        Queries.insertGuild(event.getGuild());
    }

    /**
     * Checks whether the bot has left a guild and runs
     * a query to remove the guild from the database.
     *
     * @param event The event containing the info from the guild.
     */
    public void onGuildLeave(@NotNull GuildLeaveEvent event) {
        Queries.removeGuild(event.getGuild());
    }

}
