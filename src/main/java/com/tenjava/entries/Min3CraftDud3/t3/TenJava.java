package com.tenjava.entries.Min3CraftDud3.t3;

import org.bukkit.plugin.java.JavaPlugin;

///Final Fantasy/Pokemon inspired random combat system.
public class TenJava extends JavaPlugin {
    MyL myl = new MyL(this);
    public void onEnable(){
        getServer().getPluginManager().registerEvents(myl,this);
    }
}
