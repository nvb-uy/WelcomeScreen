package elocindev.welcomescreen.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import elocindev.welcomescreen.WelcomeScreen;
import elocindev.welcomescreen.config.entries.CacheFile;
import elocindev.welcomescreen.config.entries.MainConfig;
import elocindev.welcomescreen.util.PathUtils;
import elocindev.necronomicon.api.config.v1.NecConfigAPI;

public class Configs {
    public static MainConfig MAIN;

    public static void loadCommonConfigs() {
        NecConfigAPI.registerConfig(MainConfig.class);
        MAIN = MainConfig.INSTANCE;
    }

    public static CacheFile CACHE;

    public static void loadClientConfigs() {
        NecConfigAPI.registerConfig(CacheFile.class);
        CACHE = CacheFile.INSTANCE;
    }

    public static String getNestedFile(String file, String folder) {
        Path cfg = PathUtils.getConfigPath();

        Path eeFolder = cfg.resolve(WelcomeScreen.MODID);
        Path nestedFolder = eeFolder.resolve(folder);

        try {
            Files.createDirectories(nestedFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nestedFolder.resolve(file).toString();
    }

    public static void refreshCache() {
        try {
            CacheFile.getPath().toFile().delete();
            
            NecConfigAPI.registerConfig(CacheFile.class);
            CACHE = CacheFile.INSTANCE;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
