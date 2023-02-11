package kbtdx.man10loginbonus;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("mlb.user")){
            sender.sendMessage(ChatColor.RED + "[Man10LoginBonus] 権限がありません");
            return true;
        }
        return true;
    }
}
