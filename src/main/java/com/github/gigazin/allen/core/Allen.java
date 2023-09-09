package com.github.gigazin.allen.core;

import com.github.gigazin.allen.commands.LanguageEvent;
import com.github.gigazin.allen.commands.TestEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Allen {

    private static JDA jda;
    private static final JDABuilder builder = JDABuilder.createDefault(Token.TOKEN, GatewayIntent.MESSAGE_CONTENT,
            GatewayIntent.GUILD_MESSAGES);
    private static boolean isLaunched = false;

    public static void action(String action) {
        if (action.equals("launch") && !isLaunched) launch();
        else if (action.equals("shutdown") && isLaunched) shutdown();

        jda.addEventListener(new TestEvent());
        jda.addEventListener(new LanguageEvent());
    }

    public static void launch() {
        jda = builder.build();
        isLaunched = true;
    }

    public static void shutdown() {
        jda.shutdown();
    }

}
