package me.flashberry.chatradius.commands;


import me.flashberry.chatradius.ChatRadius;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.command.CommandExecutor;

public class Say implements Listener, CommandExecutor{
    public Say(ChatRadius plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        plugin.getCommand("say").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        @EventHandler
        public void playerChat(AsyncPlayerChatEvent e){
            //Preparing the msg
            String rawMessage = e.getMessage();
            String message = e.getPlayer().getName() + ": " + rawMessage;

            //Max distance from sender to receive
            int blockDistance = 15;

            Location playerLocation = e.getPlayer().getLocation();

            //Cycles through every player online
            for(Player p : e.getRecipients()){
                if (p.getLocation().distance(playerLocation) <= blockDistance){
                    p.sendMessage(message);
                    p.sendMessage("You are in range mah boieh!");
                }else p.sendMessage("GET IN RANGE.");
            }
            e.getRecipients().clear();

        }

    }
}