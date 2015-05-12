package dk.sdu.mmmi.cbse.project7.player;

import dk.sdu.mmmi.cbse.project7.common.data.Entity;
import dk.sdu.mmmi.cbse.project7.common.data.World;
import dk.sdu.mmmi.cbse.project7.common.services.IGamePluginService;
import static dk.sdu.mmmi.cbse.project7.player.EntityFactory.createShip;
import javax.ejb.Stateless;

@Stateless(name = "PlayerPlugin")
public class PlayerPlugin implements IGamePluginService {

    private Entity e;

    @Override
    public World start(World world) {

        // Add entities to the world
        e = createShip();
        world.addEntitiy(e);

        return world;
    }

    @Override
    public void stop() {
        // Remove entities
    }

}
