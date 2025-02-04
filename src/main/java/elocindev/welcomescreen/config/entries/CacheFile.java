package elocindev.welcomescreen.config.entries;

import elocindev.welcomescreen.compat.BCCCompat;
import elocindev.welcomescreen.util.GuiUtils;
import elocindev.welcomescreen.util.PathUtils;

import java.nio.file.Path;

import elocindev.necronomicon.config.NecConfig;

public class CacheFile {
    @NecConfig public static CacheFile INSTANCE;
    
    public static String getFile() {
        return getPath().toString();
    }

    public static Path getPath() {
        return PathUtils.getGamePath().resolve("welcomescreen_cache.json");
    }

    public boolean shownWelcomeScreen = GuiUtils.SHOWN_WELCOME;
    public String bccUpdateString = BCCCompat.getModpackVersion();
    public boolean shownUpdateScreen = GuiUtils.SHOWN_UPDATE;
}
