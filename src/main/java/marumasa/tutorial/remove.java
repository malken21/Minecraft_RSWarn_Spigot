package marumasa.tutorial;

import org.bukkit.Chunk;
import org.bukkit.scheduler.BukkitRunnable;

public class remove extends BukkitRunnable {

    public final Chunk chunk;

    public remove(Chunk data) {
        chunk = data;
    }

    public void run() {
        blocks.dataList.remove(this);
        this.cancel();
    }
}
