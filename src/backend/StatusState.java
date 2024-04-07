package backend;
import java.util.ArrayList;

public abstract class StatusState {
    protected Roadmap roadmap;
    protected StatusState statusState;
    protected String courseSubjectCode;
    protected String courseNumber;
    protected String courseID;
    protected boolean transferred;
    protected boolean inProgress;
    protected boolean completed;
    protected String semesterTaken;
    protected double grade;

    public StatusState(Roadmap roadmap) {
        this.roadmap = roadmap;
        this.courseSubjectCode = "";
        this.courseNumber = "";
        this.courseID = "";
 
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