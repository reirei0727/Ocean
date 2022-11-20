package ocean.ocean;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.Bukkit.getLogger;

public class ChangeOcean implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        for (int x = -10; x < 10; x++) {
            for (int y = -10; y < 10; y++) {
                for (int z = -10; z < 10; z++) {
                    Block block = p.getLocation().subtract(x,y,z).getBlock();
                    if (block.getType() == Material.AIR) {
                        block.getLocation().getBlock().setType(Material.WATER);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,100000,1,false,false));
    }

    @EventHandler
    @Deprecated
    public void onSpawnEvent(PlayerRespawnEvent e){
        Bukkit.getScheduler().runTaskLater(Ocean.getInstance(), task ->{
            Player p = e.getPlayer();
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,100000,1,false,false));
        },5L);

    }
}
