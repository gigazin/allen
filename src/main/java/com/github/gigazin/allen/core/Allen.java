package com.github.gigazin.allen.core;

import com.github.gigazin.allen.commands.SlashCommands;
import com.github.gigazin.allen.commands.Events;
import com.github.gigazin.allen.database.Database;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Allen {

    private static JDA jda;
    private static final JDABuilder builder = JDABuilder.createDefault(Token.TOKEN, GatewayIntent.MESSAGE_CONTENT,
            GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_EMOJIS_AND_STICKERS, GatewayIntent.SCHEDULED_EVENTS);
    private static boolean isLaunched = false;

    public static void action(String action) throws InterruptedException {
        if (action.equals("launch") && !isLaunched) launch();
        else if (action.equals("shutdown") && isLaunched) shutdown();

        jda.addEventListener(new Events());
        jda.addEventListener(new SlashCommands());

        Guild guild = jda.getGuildById(TestGuild.ID);
        if (guild != null) guild.upsertCommand("allentest", "test slash command").queue();
    }

    public static void launch() throws InterruptedException {
        jda = builder.build().awaitReady();
        isLaunched = true;
        Database.connect();
    }

    public static void shutdown() {
        Database.shutdown();
        jda.shutdown();
    }

}
