package com.tenjava.entries.Min3CraftDud3.t3;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

    //Detects amount of steps the player has walked and sends them to the checkSteps() to be compared against the random encounter steps int.
    //If both ints match the mobs will randomly be generates within 5 blocks of the player.
    @EventHandler
    public void onMovement(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(encounterSteps==0){
            encounterSteps = rand.nextInt(400);
            System.out.println(encounterSteps);
        }
        if(e.getFrom().getBlockX()==e.getTo().getBlockX() && e.getFrom().getBlockY()==e.getTo().getBlockY() && e.getFrom().getBlockZ()==e.getTo().getBlockZ())return;
        numSteps++;
        checkSteps(p);
    }
    public static void checkSteps(Player p){
        if(numSteps==encounterSteps){
            doMobAttack(p);
            p.sendMessage(ChatColor.RED + "Wild Mobs Appeared!!");
            encounterSteps=0;
            numSteps = 0;
        }
    }
    public static void doMobAttack(Player p) {
        Location l = p.getLocation();
        World w = l.getWorld();
        int numMobs = rand.nextInt(6);
        Location mSpawnLoc;
        for (int i = 0; i < numMobs; i++) {
                double locX = randInt((int) l.getX() - 5, (int) l.getX() + 5);
                double locZ = randInt((int) l.getZ() - 5, (int) l.getZ() + 5);
                double locY = w.getHighestBlockYAt((int) locX, (int) locZ);
                mSpawnLoc = new Location(w, locX, locY, locZ);
                int type = rand.nextInt(6);
                switch (type) {
                    case 0: //Zombie
                        w.spawnEntity(mSpawnLoc,EntityType.ZOMBIE);
                        Bukkit.broadcastMessage("Z");
                        break;
                    case 1: //Skeleton
                        w.spawnEntity(mSpawnLoc,EntityType.SKELETON);
                        Bukkit.broadcastMessage("S");
                        break;
                    case 2: //Spider
                        w.spawnEntity(mSpawnLoc,EntityType.SPIDER);
                        Bukkit.broadcastMessage("SP");
                        break;
                    case 3: //Witch
                        w.spawnEntity(mSpawnLoc,EntityType.WITCH);
                        Bukkit.broadcastMessage("W");
                        break;
                    case 4: //CaveSpider
                        w.spawnEntity(mSpawnLoc,EntityType.CAVE_SPIDER);
                        Bukkit.broadcastMessage("CS");
                        break;
                    case 5: //PigZombie
                        w.spawnEntity(mSpawnLoc,EntityType.PIG_ZOMBIE);
                        Bukkit.broadcastMessage("PZ");
                        break;
                    case 6: //Creeper
                        w.spawnEntity(mSpawnLoc,EntityType.CREEPER);
                        Bukkit.broadcastMessage("C");
                        break;
                }
        }
    }
    public static int randInt(int min, int max){
        int randNumber = rand.nextInt((max-min)+1)+min;
        return randNumber;
    }
}
