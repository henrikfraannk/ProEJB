package dk.sdu.mmmi.cbse.project7.asteroids;

import dk.sdu.mmmi.cbse.project7.common.data.Entity;
import dk.sdu.mmmi.cbse.project7.common.data.GameTime;
import dk.sdu.mmmi.cbse.project7.common.data.Position;
import dk.sdu.mmmi.cbse.project7.common.data.Rotation;
import dk.sdu.mmmi.cbse.project7.common.data.Scale;
import dk.sdu.mmmi.cbse.project7.common.data.View;
import dk.sdu.mmmi.cbse.project7.common.data.World;
import dk.sdu.mmmi.cbse.project7.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.project7.common.services.IGamePluginService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import playn.core.Game;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import playn.core.util.Clock;

public class AsteroidsGame extends Game.Default {

    private final Clock.Source clock = new Clock.Source(33);
    private GroupLayer layer;
    private World world = new World();
    private final List<IGamePluginService> gamePluginService;
    private final List<IEntityProcessingService> entityProcessingServices;
    private final Map<String, ImageLayer> imageLayerMap = new HashMap<>();

    AsteroidsGame(List<IGamePluginService> gamePluginServices, List<IEntityProcessingService> entityProcessingService) {
        super(33); // call update every 33ms (30 times per second)
        this.gamePluginService = gamePluginServices;
        this.entityProcessingServices = entityProcessingService;
    }

    @Override
    public void init() {

        // Add clock to world context
        world.setGameTime(new GameTime());

        // Lookup all Game Plugins using ServiceLoader
        for (IGamePluginService gamePlugin : gamePluginService) {
            world = gamePlugin.start(world);
        }

        // create a group layer to hold everything
        layer = graphics().rootLayer();

        // create and addEntitiy background image layer
        layer.add(graphics().createImmediateLayer(
                new StarRenderer(clock, world)));

        // Create views for each entity
        createViews();
    }

    @Override
    public void update(int delta) {

        clock.update(delta);
        world.getGameTime().delta = delta;

        // Process each entity using provided processing services (i.e.,
        // ServiceLoader services)
        for (Entity e : world.getEntities()) {
            for (IEntityProcessingService entityProcessingService : entityProcessingServices) {
                world = entityProcessingService.process(world, e);
            }
        }

    }

    @Override
    public void paint(float alpha) {
        // the background automatically paints itself, so no need to do anything
        // here!
        clock.paint(alpha);

        for (Entity e : world.getEntities()) {
            ImageLayer view = imageLayerMap.get(e.getView().getImageFilePath());
            Position p = e.getPosition();
            Rotation r = e.getRotation();
            Scale s = e.getScale();

            view.setTranslation(p.x, p.y);
            view.setRotation(r.angle);
            view.setAlpha(1.0f);
            view.setScale(s.x, s.y);
        }
    }

    private void createViews() {
        for (Entity entity : world.getEntities()) {

            View sprite = entity.getView();

            String imagePath = sprite.getImageFilePath();

            Image image = assets().getImageSync(imagePath);

            ImageLayer viewLayer = graphics().createImageLayer(image);
            viewLayer.setOrigin(image.width() / 2f, image.height() / 2f);

            imageLayerMap.put(imagePath, viewLayer);
            layer.add(viewLayer);
        }
    }
}
