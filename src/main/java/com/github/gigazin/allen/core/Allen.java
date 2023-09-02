package com.github.gigazin.allen.core;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Allen {

    public static void launch() {
        JDA jda = JDABuilder.createDefault(Token.TOKEN).build();
    }

}
