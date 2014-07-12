package com.tenjava.entries.Min3CraftDud3.t3;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

///Final Fantasy/Pokemon inspired random combat system.
public class TenJava extends JavaPlugin {
    MyL myl = new MyL(this);
    public void onEnable(){
        getServer().getPluginManager().registerEvents(myl,this);
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equalsIgnoreCase("info")){
            sender.sendMessage(ChatColor.GOLD+"oOo___ Ten.Java 2014 ___oOo");
            sender.sendMessage("Author: Min3CraftDud3");
            sender.sendMessage("Time Taken: 3 Hours");
            sender.sendMessage("Theme: What random events can occur in Minecraft?");
            sender.sendMessage("");
            sender.sendMessage("Description: This is a random battle plugin. It is similar to Final Fantasy/Pokemon steps encounter system.");
            sender.sendMessage("When the player steps equal the steps for the random encounter mobs will spawn and attack the player.");
        }
        return false;
    }
}
