package backend;

import java.util.ArrayList;

public class CompletedState extends StatusState {
    private boolean isCompleted;

    public CompletedState(Roadmap roadmap) {
        super(roadmap);
        this.isCompleted = true;
        // setCompleted(completed);
    }

    public boolean isCompleted() {
        return isCompleted;
    }


}