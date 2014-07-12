package com.tenjava.entries.Min3CraftDud3.t3;

import org.bukkit.Location;
import org.bukkit.World;
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
    public static void doMobAttack(Player p){
        Location l = p.getLocation();
        double locX = l.getX();
        double locY = l.getY();
        double locZ = l.getZ();
        World w = l.getWorld();
        int type = rand.nextInt(10);
        switch(type){
            case 0:

                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}
