package ocean.ocean;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Ocean extends JavaPlugin {
    private static JavaPlugin plugin;
    private ChangeOcean listners;

    public static Ocean instance;
    public static Ocean getInstance(){
        return instance;
    }
    @Override
    public void onEnable() {
        this.listners = new ChangeOcean();
        Bukkit.getPluginManager().registerEvents(this.listners, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
