package elocindev.welcomescreen.config.entries;

import elocindev.welcomescreen.config.Configs;
import elocindev.necronomicon.config.Comment;
import elocindev.necronomicon.config.NecConfig;

public class MainConfig {
    @NecConfig public static MainConfig INSTANCE;
    
    public static String getFile() {
        return Configs.getNestedFile("welcomescreen.json5", "welcomescreen");
    }

    @Comment("-------------------------------------------------------------------------------------------------------------")
    @Comment("                                      Welcome Screen by ElocinDev")
    @Comment("-------------------------------------------------------------------------------------------------------------")
    @Comment("WARNING FOR MODPACK DEVELOPERS:")
    @Comment("- Do NOT include the welcomescreen_cache.json file in the game directory when exporting your modpack,")
    @Comment("  as that file defines if the screens were shown already or not.")
    @Comment("- You can manually open the screen using /openguiscreen welcomescreen_welcome or /openguiscreen welcomescreen_update")
    @Comment("- By default the screens are EMPTY, you need FancyMenu to edit them and add the content you wish.")
    @Comment("-------------------------------------------------------------------------------------------------------------")
    @Comment("Whether or not to enable the welcome screen.")
    @Comment("This screen will appear the first time the player joins a world after installing the modpack,")
    @Comment("you can edit it and add important info, links to discord or github issues, etc.")
    public boolean welcome_screen_enabled = true;
    @Comment("Whether or not to enable the update screen.")
    @Comment("This screen will appear every time the user updates the modpack, you can edit it to add a showcase of")
    @Comment("new important features, important bug fixes, etc.")
    @Comment(" ")
    @Comment("Requires BCC to be installed! https://modrinth.com/mod/better-compatibility-checker")
    public boolean update_screen_enabled = true;
}
