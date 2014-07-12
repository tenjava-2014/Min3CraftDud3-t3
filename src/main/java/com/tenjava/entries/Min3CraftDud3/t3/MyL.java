package com.tenjava.entries.Min3CraftDud3.t3;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

/**
 * Created by Min3 on 7/12/2014.
 */
public class MyL implements Listener {
    TenJava plugin;
    static Random rand = new Random();
    static int numSteps = 0;
    static int encounterSteps=0;
    public MyL(TenJava plugin){this.plugin=plugin;}

    @EventHandler
    public void onMovement(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(encounterSteps==0){
            encounterSteps = rand.nextInt(400);
            System.out.println(encounterSteps);
        }
        if(e.getFrom().getBlockX()==e.getTo().getBlockX() && e.getFrom().getBlockY()==e.getTo().getBlockY() && e.getFrom().getBlockZ()==e.getTo().getBlockZ())return;
        numSteps++;
        System.out.println(numSteps);
        checkSteps(p);
    }
    public static void checkSteps(Player p){
        if(numSteps==encounterSteps){
            doMobAttack(p);
            p.sendMessage(ChatColor.RED + "Wild Mobs Appeared!!");
            System.out.println("Spawning mobs on player");
        }
    }
    public static void doMobAttack(Player p) {
        Location l = p.getLocation();
        World w = l.getWorld();
        int numMobs = rand.nextInt(6);
        Location mSpawnLoc;
        for (int i = 0; i < numMobs; i++) {
                double locX = randInt((int) l.getX() - 5, (int) l.getX() + 5);
                double locY = randInt((int) l.getY() - 5, (int) l.getY() + 5);
                double locZ = w.getHighestBlockYAt((int) locX, (int) locY);
                mSpawnLoc = new Location(w, locX, locY, locZ);
                int type = rand.nextInt(6);
                switch (type) {
                    case 0: //Zombie
                       // p.getWorld().spawnEntity(mSpawnLoc, EntityType.ZOMBIE);
                        p.getWorld().spawnCreature(mSpawnLoc, EntityType.ZOMBIE);
                        Bukkit.broadcastMessage("Z");
                        break;
                    case 1: //Skeleton
                        p.getWorld().spawnEntity(mSpawnLoc, EntityType.SKELETON);
                        Bukkit.broadcastMessage("S");
                        break;
                    case 2: //Spider
                        p.getWorld().spawnEntity(mSpawnLoc, EntityType.SPIDER);
                        Bukkit.broadcastMessage("SP");
                        break;
                    case 3: //Witch
                        p.getWorld().spawnEntity(mSpawnLoc, EntityType.WITCH);
                        Bukkit.broadcastMessage("W");
                        break;
                    case 4: //CaveSpider
                        p.getWorld().spawnEntity(mSpawnLoc, EntityType.CAVE_SPIDER);
                        Bukkit.broadcastMessage("CS");
                        break;
                    case 5: //PigZombie
                        p.getWorld().spawnEntity(mSpawnLoc, EntityType.PIG_ZOMBIE);
                        Bukkit.broadcastMessage("PZ");
                        break;
                    case 6: //Creeper
                        p.getWorld().spawnEntity(mSpawnLoc, EntityType.CREEPER);
                        Bukkit.broadcastMessage("C");
                        break;
                }
        }
        encounterSteps=0;
    }
    public static int randInt(int min, int max){
        int randNumber = rand.nextInt((max-min)+1)+min;
        return randNumber;
    }
    @EventHandler
    public void onSpawn(CreatureSpawnEvent e){
        if(e.getEntity() instanceof Slime){
            e.setCancelled(true);
        }
    }

}
