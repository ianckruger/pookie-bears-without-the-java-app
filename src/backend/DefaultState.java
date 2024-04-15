package backend;

import java.util.ArrayList;

public class DefaultState extends StatusState {
    private boolean defaultState;

    public DefaultState(Roadmap roadmap) {
        super(roadmap);
        this.defaultState = true;
    }

}