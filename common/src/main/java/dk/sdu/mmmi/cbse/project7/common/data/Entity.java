package dk.sdu.mmmi.cbse.project7.common.data;

import java.io.Serializable;

public class Entity implements Serializable {

    private View view;
    private Position position;
    private Rotation rotation;
    private Velocity velocity;
    private Scale scale;
    private BehaviourEnum behavior;

    public void setView(View view) {
        this.view = view;
    }

    public void setPosition(Position p) {
        this.position = p;
    }

    public void setRotation(Rotation r) {
        this.rotation = r;
    }

    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    public void setScale(Scale s) {
        this.scale = s;
    }

    public void setBehaviour(BehaviourEnum be) {
        this.behavior = be;
    }

    public BehaviourEnum getBehavior() {
        return behavior;
    }

    public Position getPosition() {
        return position;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public Scale getScale() {
        return scale;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public View getView() {
        return view;
    }

}
