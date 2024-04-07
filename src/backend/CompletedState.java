package backend;

import java.util.ArrayList;

public class CompletedState extends StatusState {
    protected boolean completed;

    public CompletedState(Roadmap roadmap) {
        super(roadmap);
        this.completed = true;
        setCompleted(completed);
    }

    public boolean isCompleted() {
        return completed;
    }

}