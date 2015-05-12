package dk.sdu.mmmi.cbse.project7.common.data;

import java.io.Serializable;

public class Position implements Serializable {

    public float x, y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
