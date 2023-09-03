package com.github.gigazin.allen.core;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Allen {

    private static JDA jda;
    private static final JDABuilder builder = JDABuilder.createDefault(Token.TOKEN);
    private static boolean isLaunched = false;

    public static void action(String action) {
        if (action.equals("launch") && !isLaunched) launch();
        else if (action.equals("shutdown") && isLaunched) shutdown();
    }

    public static void launch() {
        jda = builder.build();
        isLaunched = true;
    }

    public static void shutdown() {
        jda.shutdown();
    }

}
