package elocindev.welcomescreen.compat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import elocindev.necronomicon.api.NecUtilsAPI;
import elocindev.welcomescreen.util.PathUtils;

//? if forge || neoforge {
/*import java.util.List;
*///?}

public class BCCCompat {
    public static boolean isBCCInstalled() {
        return NecUtilsAPI.isModLoaded("bcc");
    }

    public static String getModpackVersion() {
        if (isBCCInstalled()) {
            Path bccFile = 
            //?if fabric {
            PathUtils.getConfigPath().resolve("bcc.json");
            //?} else {
            /*PathUtils.getConfigPath().resolve("bcc-common.toml");
            *///?}

            if (bccFile.toFile().exists()) {
                try {
                    //?if fabric {
                    String content = Files.readString(bccFile);
                    Map<String, Object> jsonMap = new Gson().fromJson(content, new TypeToken<Map<String, Object>>(){}.getType());
                    return (String) jsonMap.get("modpackVersion");
                    //?} else {
                    /*List<String> lines = Files.readAllLines(bccFile);
                    for (String line : lines) {
                        if (line.trim().startsWith("modpackVersion")) {
                            return line.split("=")[1].trim().replace("\"", "");
                        }
                    }
                    *///?}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
         
        return "";
    }
}