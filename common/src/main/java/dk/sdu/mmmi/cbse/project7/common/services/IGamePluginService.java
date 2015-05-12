package dk.sdu.mmmi.cbse.project7.common.services;

import dk.sdu.mmmi.cbse.project7.common.data.World;
import javax.ejb.Remote;

@Remote
public interface IGamePluginService {

    World start(World world);

    void stop();
}
