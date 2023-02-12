package kbtdx.man10loginbonus;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import static kbtdx.man10loginbonus.Man10LoginBonus.mlb;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("mlb.user")){
            sender.sendMessage(ChatColor.RED + "[Man10LoginBonus] 権限がありません");
            return true;
        }
        if (sender.hasPermission("mlb.op")){
            if (args.length==0)return true;
            else {
                if (args[0].equalsIgnoreCase("createbonus")){
                    Player p = (Player) sender;
                    File file = new File(mlb.getDataFolder().getAbsolutePath() + File.separator + "bonuses");
                    File filee = new File(file, File.separator + args[1] + ".yml");
                    YamlConfiguration yml = new YamlConfiguration();
                    yml.set("Material",p.getInventory().getItemInMainHand().getType());
                    yml.set("DisplayName",p.getInventory().getItemInMainHand().getItemMeta().getDisplayName());
                    yml.set("CustomModelData",p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData());
                    yml.set("Lore",p.getInventory().getItemInMainHand().getItemMeta().getLore());
                    yml.set("Modifiers",p.getInventory().getItemInMainHand().getItemMeta().getAttributeModifiers());
                    yml.set("ItemFlags",p.getInventory().getItemInMainHand().getItemFlags());
                    try {
                        yml.save(filee);
                        sender.sendMessage(ChatColor.BLUE + "§l[Man10LoginBonus]§f 保存しました。");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return true;
    }
}
