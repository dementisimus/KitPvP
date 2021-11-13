package dev.dementisimus.kitpvp;

import dev.dementisimus.capi.core.BukkitCoreAPI;
import dev.dementisimus.capi.core.database.Database;
import dev.dementisimus.capi.core.setup.SetupManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
/**
 * Copyright (c) by dementisimus,
 * licensed under Attribution-NonCommercial-NoDerivatives 4.0 International
 *
 * Class KitPvPPlugin @ KitPvP
 *
 * @author dementisimus
 * @since 13.11.2021:22:09
 */
public class KitPvPPlugin extends JavaPlugin {

    @Getter private BukkitCoreAPI bukkitCoreAPI;
    @Getter private SetupManager setupManager;
    @Getter private Database database;

    @Override
    public void onEnable() {
        this.bukkitCoreAPI = new BukkitCoreAPI(this);
        this.setupManager = this.bukkitCoreAPI.getSetupManager();

        this.bukkitCoreAPI.enableMainSetupStates();

        this.bukkitCoreAPI.enableDatabase();
        this.database = this.bukkitCoreAPI.getDatabase();

        this.bukkitCoreAPI.prepare(coreAPIInjector -> {
            coreAPIInjector.addInjectionModule(KitPvPPlugin.class, this);

            this.bukkitCoreAPI.init(() -> {

            });
        });
    }

    public static class ExtraSetupStates {

    }

    public static class Strings {

        public static final String PREFIX = "§c§lMap§f§lCreator §7§l»";
    }

    public static class Translations {

    }
}
