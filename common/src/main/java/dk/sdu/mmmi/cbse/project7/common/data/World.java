package dk.sdu.mmmi.cbse.project7.common.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jcs
 */
public class World implements Serializable {

    private static final long serialVersionUID = 7526471155622776147L;

    private final ArrayList<Entity> entities = new ArrayList<>();
    private GameTime gameTime;

    public void addEntitiy(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void setGameTime(GameTime gameTime) {
        this.gameTime = gameTime;
    }

    public GameTime getGameTime() {
        return this.gameTime;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void updateEntity(Entity entity) {
        this.entities.remove(entity);
        this.entities.add(entity);
    }
}
