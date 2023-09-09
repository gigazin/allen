package com.github.gigazin.allen.commands;

import com.github.gigazin.allen.settings.Client;
import com.github.gigazin.allen.settings.Default;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LanguageEvent extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase(Client.getCurrentPrefix()) && message[1].equalsIgnoreCase("lang") ||
        message[0].equalsIgnoreCase(Default.DEFAULT_PREFIX) && message[1].equalsIgnoreCase("lang")) {
            if (message[2].equalsIgnoreCase("pt-BR") ||
                    message[2].equalsIgnoreCase("pt_BR") ||
                    message[2].equalsIgnoreCase("ptBR")) {
                Client.setCurrentLanguage("pt-BR");
                sendPortugueseMessage(event);
            }
            else if (message[2].equalsIgnoreCase("en-US") ||
                    message[2].equalsIgnoreCase("en_US") ||
                    message[2].equalsIgnoreCase("enUS")) {
                Client.setCurrentLanguage("en-US");
                sendEnglishMessage(event);
            }
        }
    }

    private void sendEnglishMessage(MessageReceivedEvent event) {
        event.getMessage().getChannel().sendMessage("Changed language to " + Client.getCurrentLanguage()).queue();
    }

    private void sendPortugueseMessage(MessageReceivedEvent event) {
        event.getMessage().getChannel().sendMessage("Idioma alterado para " + Client.getCurrentLanguage()).queue();
    }

}
