package elocindev.welcomescreen.util;

//? if fabric {
import net.fabricmc.loader.api.FabricLoader;
//?} else if forge{
/*import net.minecraftforge.fml.loading.FMLPaths;
*///?} else if neoforge {
/*import net.neoforged.fml.loading.FMLPaths;
*///?}

import java.nio.file.Path;

public class PathUtils {
    public static Path getConfigPath() {
        //?if fabric {
        return FabricLoader.getInstance().getConfigDir();
        //?} else {
        /*return FMLPaths.CONFIGDIR.get();
        *///?}
    }

    public static Path getGamePath() {
        //?if fabric {
        return FabricLoader.getInstance().getGameDir();
        //?} else {
        /*return FMLPaths.GAMEDIR.get();
        *///?}
    }
}
