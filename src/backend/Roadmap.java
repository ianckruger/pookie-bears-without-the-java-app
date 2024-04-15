package backend;
import java.util.ArrayList;
import java.util.UUID;

public class Roadmap {
    private Student student;
    // private ArrayList<String> classes;
    private MajorState majorState;
    // private StatusState statusState;
    private CsceState csceState;
    private CisState cisState;
    private CeState ceState;
    private DefaultState defaultState;
    private CompletedState completedState;
    private IncompletedState incompletedState;
    // private HistoryState historyState;
    // private double progressBar;
    protected UUID roadmapID;
    private String major;
    private static Roadmap roadmap;
    private ArrayList<String> advisorNotes;
    private StatusState statusState;


    public Roadmap(String major) {
        this.advisorNotes = new ArrayList<>();
        this.major = major;
        cisState = new CisState(this);
        csceState = new CsceState(this);
        ceState = new CeState(this);
        defaultState = new DefaultState(this);
        completedState = new CompletedState(this);
        incompletedState = new IncompletedState(this);

        
        if(major.equalsIgnoreCase("cis")){
            setMajorState(cisState);
        } else if (major.equalsIgnoreCase("ce")){
            setMajorState(ceState);
        } else if (major.equalsIgnoreCase("csce")){
            setMajorState(csceState);
        }

    }

    public void setAdvisorNotes(ArrayList<String> notes) {
        this.advisorNotes = notes;
    }

    public static Roadmap getInstance() {
        if(roadmap == null) {
            roadmap = DataLoader.readRoadmap();
         }
        return roadmap;
    }

    public void setMajorState(MajorState majorState) {
        this.majorState = majorState;
    }

    public void setStatusState(StatusState statusState) {
        this.statusState = statusState;
    }

    public void setDefaultState(DefaultState defaultState) {
        this.defaultState = defaultState;
        setStatusState(defaultState);
    }

    public void setCompletedState(CompletedState completedState) {
        this.completedState = completedState;
        setStatusState(completedState);
    }

    public void setIncompletedState(IncompletedState incompletedState) {
        this.incompletedState = incompletedState;
        setStatusState(incompletedState);
    }

    public void setMajorState(String major) {
        if(major.equalsIgnoreCase("cis")){
            setMajorState(cisState);
        } else if (major.equalsIgnoreCase("ce")){
            setMajorState(ceState);
        } else if (major.equalsIgnoreCase("csce")){
            setMajorState(csceState);
        }
    }

    public void setCisState(CisState state) {
        this.cisState = state;
        setMajorState(cisState);
    }

    public void setCeState(CeState state) {
        this.ceState = state;
        setMajorState(ceState);
    }

    public void setCsState(CsceState state) {
        this.csceState = state;
        setMajorState(csceState);
    }

    public String displayClasses() {
        System.out.println("Major State: " + majorState.getMajor() + ".\n");
        return majorState.toString();
    }
    
    public String displayStudentInfo() {
        return "";
    }

    public MajorState getMajorState() {
        return this.majorState;
    }
    public void setRoadmap(Roadmap roadmap) {
        this.roadmap = roadmap;
    }

    
    

}