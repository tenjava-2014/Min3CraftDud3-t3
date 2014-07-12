package com.tenjava.entries.Min3CraftDud3.t3;

import org.bukkit.Bukkit;
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
    public MyL(TenJava plugin){this.plugin=plugin;}

    @EventHandler
    public void onMovement(PlayerMoveEvent e){
        if(e.getFrom().getBlockX()==e.getTo().getBlockX() && e.getFrom().getBlockY()==e.getTo().getBlockY() && e.getFrom().getBlockZ()==e.getTo().getBlockZ())return;
        numSteps++;
        checkSteps(e.getPlayer());
    }
    public static void checkSteps(Player p){
        int encounterSteps = rand.nextInt(400);
        if(numSteps==encounterSteps){
            doMobAttack(p);
        }
    }
    public static void doMobAttack(Player p) {
        Location l = p.getLocation();
        World w = l.getWorld();
        int numMobs = rand.nextInt(6);
        Location mSpawnLoc;
        for (int i = 0; i < numMobs; i++) {
            double locX = randInt((int)l.getX()-5,(int)l.getX()+5);
            double locY = randInt((int)l.getY()-5,(int)l.getY()+5);
            double locZ = w.getHighestBlockYAt((int)locX,(int)locY);
            int type = rand.nextInt(7);
            switch (type) {
                case 0: //Zombie
                    mSpawnLoc = new Location(w,locX,locY,locZ);
                    Bukkit.getWorld(p.getWorld().toString()).spawnEntity(mSpawnLoc, EntityType.ZOMBIE);
                    break;
                case 1: //Skeleton
                    mSpawnLoc = new Location(w,locX,locY,locZ);
                    Bukkit.getWorld(p.getWorld().toString()).spawnEntity(mSpawnLoc, EntityType.SKELETON);
                    break;
                case 2: //Spider
                    mSpawnLoc = new Location(w,locX,locY,locZ);
                    Bukkit.getWorld(p.getWorld().toString()).spawnEntity(mSpawnLoc, EntityType.SPIDER);
                    break;
                case 3: //Witch
                    mSpawnLoc = new Location(w,locX,locY,locZ);
                    Bukkit.getWorld(p.getWorld().toString()).spawnEntity(mSpawnLoc, EntityType.WITCH);
                    break;
                case 4: //CaveSpider
                    mSpawnLoc = new Location(w,locX,locY,locZ);
                    Bukkit.getWorld(p.getWorld().toString()).spawnEntity(mSpawnLoc, EntityType.CAVE_SPIDER);
                    break;
                case 5: //PigZombie
                    mSpawnLoc = new Location(w,locX,locY,locZ);
                    Bukkit.getWorld(p.getWorld().toString()).spawnEntity(mSpawnLoc, EntityType.PIG_ZOMBIE);
                    break;
                case 6: //Creeper
                    mSpawnLoc = new Location(w,locX,locY,locZ);
                    Bukkit.getWorld(p.getWorld().toString()).spawnEntity(mSpawnLoc, EntityType.CREEPER);
                    break;
            }
        }
    }
    public static int randInt(int min, int max){
        int randNumber = rand.nextInt((max-min)+1)+min;
        return randNumber;
    }
}
