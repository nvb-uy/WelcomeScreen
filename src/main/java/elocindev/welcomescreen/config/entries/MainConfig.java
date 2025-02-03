package elocindev.welcomescreen.config.entries;

import elocindev.welcomescreen.config.Configs;
import elocindev.necronomicon.config.NecConfig;

public class MainConfig {
    @NecConfig public static MainConfig INSTANCE;
    
    public static String getFile() {
        return Configs.getNestedFile("welcomescreen.json5", "welcomescreen");
    }

}
