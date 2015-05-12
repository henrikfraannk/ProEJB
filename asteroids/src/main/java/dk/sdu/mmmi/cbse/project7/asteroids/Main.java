package dk.sdu.mmmi.cbse.project7.asteroids;

import dk.sdu.mmmi.cbse.project7.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.project7.common.services.IGamePluginService;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import playn.core.PlayN;
import playn.java.JavaPlatform;

/**
 * Enterprise Application Client main class.
 *
 */
public class Main {

    public static void main(String[] args) {
        try {

            InitialContext ic = new InitialContext();

            IGamePluginService playerGamePluginService
                    = (IGamePluginService) ic.lookup("java:global/Player/PlayerPlugin");

            IGamePluginService enemyGamePluginService
                    = (IGamePluginService) ic.lookup("java:global/Enemy/EnemyPlugin");

            List<IGamePluginService> gpList = new ArrayList<>();
            gpList.add(playerGamePluginService);
            gpList.add(enemyGamePluginService);

            IEntityProcessingService entityProcessingService
                    = (IEntityProcessingService) ic.lookup("java:global/Movesystem/RandomMovementService");

            List<IEntityProcessingService> epList = new ArrayList<>();
            epList.add(entityProcessingService);

            JavaPlatform.Config config = new JavaPlatform.Config();
            // use config to customize the Java platform, if needed
            JavaPlatform.register(config);

            PlayN.run(new AsteroidsGame(gpList, epList));
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
