package top.bctime;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Created by soutou on 2015/12/17 0017.
 */
public class Main extends JavaPlugin {
    public void onEnable() {
        this.saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE+"");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"[BC-Time] "+ChatColor.GREEN+" 消 息 辅 助 推 送");
        Bukkit.getConsoleSender().sendMessage(ChatColor.MAGIC+"");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BOLD+"      加 载 成 功!");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE+"");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("bcxx")) {
            if (args.length == 0) {
                sender.sendMessage("§6北城时光 消息辅助插件 帮助");
                sender.sendMessage("§a/bcxx 消息编号");
                return true;
            }
                if (!sender.isOp() && sender.hasPermission("bcxx.admin")) {
                    sender.sendMessage("§c权限不足");
                    return false;
                }
                if (args.length == 1) {
//                    List<String> note = getConfig().getStringList("Note");
//                    int number = Integer.parseInt(args[0]) - 1;
//                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&' , note.get(number)));
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&' , getConfig().getString(args[0])));
                    Bukkit.getConsoleSender().sendMessage(getConfig().getString(args[0]).replace("%player%" , sender.getName()));
                    return true;
                }
                return true;
            }
            return true;
        }
    public void onDisabel() {

    }
    }
