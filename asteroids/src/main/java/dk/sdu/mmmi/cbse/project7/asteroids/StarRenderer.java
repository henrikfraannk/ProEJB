package dk.sdu.mmmi.cbse.project7.asteroids;

import dk.sdu.mmmi.cbse.project7.common.data.Entity;
import dk.sdu.mmmi.cbse.project7.common.data.Position;
import dk.sdu.mmmi.cbse.project7.common.data.World;
import java.util.Random;
import playn.core.ImmediateLayer.Renderer;
import static playn.core.PlayN.graphics;
import playn.core.Surface;
import playn.core.util.Clock;
import pythagoras.f.Point;

public class StarRenderer implements Renderer {

    private final Random random = new Random();
    private final Point[] stars;
    private float nextTwinkle;
    private final Clock clock;
    private final World world;

    public StarRenderer(Clock clock, World world) {
        this.clock = clock;
        this.world = world;
        stars = new Point[50];
        for (int ii = 0; ii < stars.length; ii++) {
            stars[ii] = randomize(new Point());
        }
    }

    @Override
    public void render(Surface surf) {
        surf.setFillColor(0xFFFFFFFF);
        for (Point p : stars) {
            surf.fillRect(p.x, p.y, 2, 2);
        }
        if (clock.time() > nextTwinkle) {
            randomize(stars[random.nextInt(stars.length)]);
            // twinkle a star every 1/2 to 2s
            nextTwinkle = clock.time() + 500 + random.nextInt(1500);
        }

        for (Entity e : world.getEntities()) {

            Position p = e.getPosition();

            // wrap around if we hit the edge of the display
            float width = graphics().width();
            float height = graphics().height();

            if (p.x < 0) {
                p.x += width;
            } else if (p.x > width) {
                p.x -= width;
            }
            if (p.y < 0) {
                p.y += height;
            } else if (p.y > height) {
                p.y -= height;
            }
        }
    }

    private Point randomize(Point p) {
        p.x = random.nextFloat() * graphics().width();
        p.y = random.nextFloat() * graphics().height();
        return p;
    }
}
