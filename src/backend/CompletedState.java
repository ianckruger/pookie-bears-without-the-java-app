package backend;

import java.util.ArrayList;

public class CompletedState extends StatusState {
    private boolean completed;

    public CompletedState(Roadmap roadmap) {
        super(roadmap);
        this.completed = true;
        setCompleted(completed);
    }

    public boolean isCompleted() {
        return completed;
    }

    public String toString() {
        StringBuilder ceString = new StringBuilder(super.toString());

        ceString.append("\nElectrical Engineering Courses:\n");
        for (Class course : completed) {
            ceString.append(course.toString());
        }

        return ceString.toString();
    }

    public void clear() {
        this.clear();
        this.electricalEngineering.clear();
    }

}