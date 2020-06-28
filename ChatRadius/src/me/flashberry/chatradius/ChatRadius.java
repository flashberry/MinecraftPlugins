package me.flashberry.chatradius;
//Special thanks to firstflames for this code,
//I couldnt have copied it without you

import me.flashberry.chatradius.commands.Say;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatRadius extends JavaPlugin{

    @Override
    public void onEnable(){
        new Say(this);
    }
}


