package marumasa.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

import java.util.logging.Logger;

public class eventListener implements Listener {

    private static final Logger logger = Bukkit.getLogger();
    private final minecraft mc;

    public eventListener(minecraft minecraft) {
        mc = minecraft;
    }

    @EventHandler
    public void onC(ChunkUnloadEvent event) {
        final Chunk eventChunk = event.getChunk();
        for (remove item : blocks.dataList) {
            if (eventChunk == item.chunk) {
                logger.info(item.chunk.toString());
            }
        }
    }

    @EventHandler
    public void onR(BlockRedstoneEvent event) {
        final Chunk chunk = event.getBlock().getChunk();
        for (remove rmv : blocks.dataList) {
            if (rmv.chunk == chunk) {
                rmv.cancel();
                blocks.dataList.remove(rmv);
                break;
            }
        }
        final remove rmv = new remove(chunk);
        blocks.dataList.add(rmv);
        rmv.runTaskTimer(mc, 400L, 0L);
    }
}
