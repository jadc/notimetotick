package red.jad.tiab.config;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import red.jad.tiab.backend.Helpers;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if(FabricLoader.getInstance().isModLoaded(Helpers.CLOTHCONFIG_MOD_ID)){
            return screen -> AutoConfig.getConfigScreen(AutoConfigIntegration.class, screen).get();
        }else{
            return screen -> MinecraftClient.getInstance().currentScreen;
        }
    }
}
