package elocindev.welcomescreen.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import de.keksuccino.fancymenu.customization.customgui.CustomGuiHandler;
import elocindev.welcomescreen.compat.BCCCompat;
import elocindev.welcomescreen.config.Configs;
import elocindev.welcomescreen.fancymenu.Screens;
import elocindev.welcomescreen.util.GuiUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @SuppressWarnings("deprecation")
    @Inject(method = "tick", at = @At("TAIL"))
    private void welcomescreen$onPlayerInit(CallbackInfo ci) {
        var ths = (ClientPlayerEntity) (Object) this;
        if (ths.age <3 && !ths.getWorld().isPosLoaded(ths.getBlockX(), ths.getBlockZ())) return;

        if (Configs.MAIN.update_screen_enabled && !Configs.CACHE.shownUpdateScreen && BCCCompat.isBCCInstalled() && !Configs.CACHE.bccUpdateString.equals("") && !BCCCompat.getModpackVersion().equals(Configs.CACHE.bccUpdateString)) {
            if (CustomGuiHandler.guiExists(Screens.UPDATE)) {
                Screen custom = CustomGuiHandler.constructInstance(Screens.UPDATE, MinecraftClient.getInstance().currentScreen, null);
                
                if (custom != null) {
                    GuiUtils.SHOWN_UPDATE = true;
                    Configs.refreshCache();

                    MinecraftClient.getInstance().setScreen(custom);
                }
            }
        } else if (Configs.MAIN.welcome_screen_enabled && !Configs.CACHE.shownWelcomeScreen) {
            if (CustomGuiHandler.guiExists(Screens.WELCOME)) {
                Screen custom = CustomGuiHandler.constructInstance(Screens.WELCOME, MinecraftClient.getInstance().currentScreen, null);
                
                if (custom != null) {
                    GuiUtils.SHOWN_WELCOME = true;
                    Configs.refreshCache();

                    MinecraftClient.getInstance().setScreen(custom);
                }                
            }
        }
    }
}

