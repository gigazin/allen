package com.github.gigazin.allen.commands;

import com.github.gigazin.allen.settings.Default;
import com.github.gigazin.allen.settings.Client;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TestEvent extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase(Client.getCurrentPrefix()) && message[1].equalsIgnoreCase("test") ||
        message[0].equalsIgnoreCase(Default.DEFAULT_PREFIX) && message[1].equalsIgnoreCase("test")) {
            if (Client.getCurrentLanguage().equalsIgnoreCase("en-US"))
                sendEnglishMessage(event);
            else if (Client.getCurrentLanguage().equalsIgnoreCase("pt-BR"))
                sendPortugueseMessage(event);
        }
    }

    private void sendEnglishMessage(MessageReceivedEvent event) {
        event.getMessage().getChannel().sendMessage("event recognized").queue();
    }

    private void sendPortugueseMessage(MessageReceivedEvent event) {
        event.getMessage().getChannel().sendMessage("evento reconhecido").queue();
    }

}
