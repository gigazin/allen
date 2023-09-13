package com.github.gigazin.allen.commands;

import com.github.gigazin.allen.settings.Default;
import com.github.gigazin.allen.settings.Client;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Events extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase(Client.getCurrentPrefix()) || message[0].equalsIgnoreCase(Default.DEFAULT_PREFIX)) {
            switch (message[1]) {

                case "test" -> {
                    switch (Client.getCurrentLanguage()) {
                        case "pt-BR" -> event.getMessage().getChannel().sendMessage("evento reconhecido").queue();
                        case "en-US" -> event.getMessage().getChannel().sendMessage("event recognized").queue();
                    }

                }

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

                    }

                }

            }

        }

    }

}
