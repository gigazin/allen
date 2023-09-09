package com.github.gigazin.allen.settings;

public class Client {
    private static String currentPrefix = Default.DEFAULT_PREFIX;
    private static String currentLanguage = Default.DEFAULT_LANGUAGE;

    public static void setCurrentPrefix(String newPrefix) {
        currentPrefix = newPrefix;
    }

    public static String getCurrentPrefix() {
        return currentPrefix;
    }

    public static void setCurrentLanguage(String newLanguage) {
        currentLanguage = newLanguage;
    }

    public static String getCurrentLanguage() {
        return currentLanguage;
    }

}
