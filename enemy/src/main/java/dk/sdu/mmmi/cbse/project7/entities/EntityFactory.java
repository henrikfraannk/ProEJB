package dk.sdu.mmmi.cbse.project7.entities;

import dk.sdu.mmmi.cbse.project7.common.data.BehaviourEnum;
import dk.sdu.mmmi.cbse.project7.common.data.Entity;
import dk.sdu.mmmi.cbse.project7.common.data.Position;
import dk.sdu.mmmi.cbse.project7.common.data.Rotation;
import dk.sdu.mmmi.cbse.project7.common.data.Scale;
import dk.sdu.mmmi.cbse.project7.common.data.Velocity;
import dk.sdu.mmmi.cbse.project7.common.data.View;

public class EntityFactory {

    public static Entity createEnemyShip() {
        Entity enemyShip = new Entity();
        enemyShip.setView(new View("images/EnemyShip.png"));
        enemyShip.setPosition(new Position(360, 280));
        enemyShip.setRotation(new Rotation());
        enemyShip.setVelocity(new Velocity());
        enemyShip.setScale(new Scale());
        enemyShip.setBehaviour(BehaviourEnum.RANDOM_MOVEMENT);
        return enemyShip;
    }
}
