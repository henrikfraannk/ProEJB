package dk.sdu.mmmi.cbse.project7.entities;

import dk.sdu.mmmi.cbse.project7.common.data.Entity;
import dk.sdu.mmmi.cbse.project7.common.data.World;
import dk.sdu.mmmi.cbse.project7.common.services.IGamePluginService;
import static dk.sdu.mmmi.cbse.project7.entities.EntityFactory.createEnemyShip;
import javax.ejb.Stateless;

@Stateless(name = "EnemyPlugin")
public class EnemyPlugin implements IGamePluginService {

    private Entity e;

    @Override
    public World start(World world) {

        // Add entities to the world
        e = createEnemyShip();
        world.addEntitiy(e);

        return world;
    }

    @Override
    public void stop() {
        // Remove entities
    }
}
