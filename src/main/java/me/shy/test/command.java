package me.shy.test;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;
import org.bukkit.World;

import java.util.Random;

public class RandomPlayerTeleport implements CommandExecutor, Listener {
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        Bukkit player;
        World world = player.getWorld();

        if (cmd.getName().equalsIgnoreCase("test")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                teleportPlayer(player);
                player.sendMessage("무작위 위치로 이동되었습니다!");
            } else {
                sender.sendMessage("이 명령은 플레이어만 사용할 수 있습니다.");
            }
            return true;
        }
        return false;
    }

    private void teleportPlayer(Player player) {

        Random random = new Random();
        int x = random.nextInt(10000) - 10000;
        int z = random.nextInt(10000) - 10000;
        int y = getSafeY(x, z);

        player.teleport(new org.bukkit.Location(player.getWorld(), x, y, z));
    }

    private int getSafeY(x, z) {
    }

    }
}
}
