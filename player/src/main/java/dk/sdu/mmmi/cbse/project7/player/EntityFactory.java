package dk.sdu.mmmi.cbse.project7.player;

import dk.sdu.mmmi.cbse.project7.common.data.BehaviourEnum;
import dk.sdu.mmmi.cbse.project7.common.data.Entity;
import dk.sdu.mmmi.cbse.project7.common.data.Position;
import dk.sdu.mmmi.cbse.project7.common.data.Rotation;
import dk.sdu.mmmi.cbse.project7.common.data.Scale;
import dk.sdu.mmmi.cbse.project7.common.data.Velocity;
import dk.sdu.mmmi.cbse.project7.common.data.View;

public class EntityFactory {

    public static Entity createShip() {
        Entity enemyShip = new Entity();
        enemyShip.setView(new View("images/Ship.png"));
        enemyShip.setPosition(new Position(400, 280));
        enemyShip.setRotation(new Rotation());
        enemyShip.setVelocity(new Velocity());
        enemyShip.setScale(new Scale());
        enemyShip.setBehaviour(BehaviourEnum.RANDOM_MOVEMENT);
        return enemyShip;
    }
}
