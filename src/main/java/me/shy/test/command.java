package me.shy.test;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class command extends BukkitCommand {

    public command(String name) {
        super("test");
    }

    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (commandLabel.equalsIgnoreCase("test")) {
            if (sender instanceof Player player) {
                teleportPlayer(player);
            } else {
                sender.sendMessage("이 명령어는 플레이어만 사용할 수 있습니다");
            }
            return true;
        }
        return false;
    }

    private void teleportPlayer(Player player) {
        List<Integer> List = new ArrayList<>();
        World world = player.getWorld();
        Random random = new Random();
        Location playerLocation = player.getLocation();

        int x = random.nextInt(20000) - 10000;
        int z = random.nextInt(20000) - 10000;
        int Y = world.getHighestBlockYAt(x, z);

        for ( int i = Y; i > -64; i--) {
            Location location = new Location(world, x, i, z);
            if (forSafeY(location)) {
                List.add(location.getBlockY());
            }
        }

        if (!List.isEmpty()) {
            Location safePlace = new Location(world, x + 0.5, List.get(random.nextInt(List.size())) + 1, z + 0.5);
            player.teleport(safePlace);
            player.sendMessage("무작위 위치로 이동");
        } else {
            player.sendMessage("실패했습니다.");
        }

    }

    public static boolean forSafeY(Location Y) {
        return Y.getBlock().getRelative(0, 1, 0).getType().isAir() && Y.getBlock().getRelative(0, 2, 0).getType().isAir()
                && !Y.getBlock().isPassable();

    }

}
