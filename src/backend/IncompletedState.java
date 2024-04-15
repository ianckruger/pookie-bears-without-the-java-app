package backend;

import java.util.ArrayList;

public class IncompletedState extends StatusState {
    private boolean isCompleted;

    public IncompletedState(Roadmap roadmap) {
        super(roadmap);
        this.isCompleted = false;
    }

}