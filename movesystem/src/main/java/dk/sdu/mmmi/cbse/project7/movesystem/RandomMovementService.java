package dk.sdu.mmmi.cbse.project7.movesystem;

import dk.sdu.mmmi.cbse.project7.common.data.BehaviourEnum;
import dk.sdu.mmmi.cbse.project7.common.data.Entity;
import dk.sdu.mmmi.cbse.project7.common.data.Position;
import dk.sdu.mmmi.cbse.project7.common.data.Rotation;
import dk.sdu.mmmi.cbse.project7.common.data.Velocity;
import dk.sdu.mmmi.cbse.project7.common.data.World;
import dk.sdu.mmmi.cbse.project7.common.services.IEntityProcessingService;
import javax.ejb.Stateless;

@Stateless(name = "RandomMovementService")
public class RandomMovementService implements IEntityProcessingService {

    private int turnDirection = 1;

    @Override
    public World process(World world, Entity entity) {
        BehaviourEnum b = entity.getBehavior();

        if (b.equals(BehaviourEnum.RANDOM_MOVEMENT)) {

            // Get context from entity
            Rotation rotation = entity.getRotation();
            Position position = entity.getPosition();
            Velocity velocity = entity.getVelocity();

            // Generate random movement direction
            if (Math.random() < 0.3) {
                turnDirection = -turnDirection;
            }
            rotation.angle += turnDirection * 0.5;

            position.x += velocity.vectorX;
            position.y += velocity.vectorY;

        }
        world.updateEntity(entity);
        return world;
    }
}
