package backend;
import java.util.ArrayList;

public abstract class StatusState {
    protected Roadmap roadmap;
    protected StatusState statusState;

    public StatusState(Roadmap roadmap) {
        this.roadmap = roadmap;
    }

    public StatusState(StatusState statusState) {
        this.statusState = statusState;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean getCompleted() {
        return this.completed;
    }


}