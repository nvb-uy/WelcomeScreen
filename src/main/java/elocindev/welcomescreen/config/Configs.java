package elocindev.welcomescreen.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import elocindev.welcomescreen.WelcomeScreen;
import elocindev.welcomescreen.config.entries.MainConfig;
import elocindev.necronomicon.api.config.v1.NecConfigAPI;

//? if fabric {
import net.fabricmc.loader.api.FabricLoader;
//?} else {
/*import net.minecraftforge.fml.loading.FMLPaths;
*///?}

public class Configs {
    public static MainConfig MAIN = MainConfig.INSTANCE;

    public static void loadCommonConfigs() {
        NecConfigAPI.registerConfig(MainConfig.class);
    }

    public static void loadClientConfigs() {}

    public static String getNestedFile(String file, String folder) {
        Path cfg =
        //?if fabric {
        FabricLoader.getInstance().getConfigDir();
        //?} else {
        /*FMLPaths.CONFIGDIR.get();
        *///?}

        Path eeFolder = cfg.resolve(WelcomeScreen.MODID);
        Path nestedFolder = eeFolder.resolve(folder);

        try {
            Files.createDirectories(nestedFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nestedFolder.resolve(file).toString();
    }
}
