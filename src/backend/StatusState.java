package backend;
import java.util.ArrayList;

public abstract class StatusState {
    protected Roadmap roadmap;
    protected StatusState statusState;
    protected ArrayList<Class> courses;

    public StatusState(Roadmap roadmap) {
 
    }

    public StatusState(StatusState statusState) {
        this.statusState = statusState;
    }




}