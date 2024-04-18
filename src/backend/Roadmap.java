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
    // private HistoryState historyState;
    // private double progressBar;
    protected UUID roadmapID;
    private String major;
    private static Roadmap roadmap;
    private ArrayList<String> advisorNotes;

    public Roadmap(String major) {
        this.advisorNotes = new ArrayList<>();
        this.major = major;
        cisState = new CisState(this);
        csceState = new CsceState(this);
        ceState = new CeState(this);

        
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
        return majorState.GetDefaultClasses();
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

    public String EightSemesterPlan() {
        if(majorState.getMajor().equals("csce")) {
            return getCSMajorPlan();
        }
        else if (majorState.getMajor().equals("cis")) {
            return getCISMajorPlan();
        } else if (majorState.getMajor().equals("ce")) {
            return getCEMajorPlan();
        } else {
            return "No major found!";
        }
    }

    public String getCSMajorPlan() {
        StringBuilder plan = new StringBuilder();
        
        // Semester One
        plan.append("Semester One:\n");
        plan.append("ENGL 101 Critical Reading and Composition - 3\n");
        plan.append("MATH 141 Calculus I - 4");
        plan.append("CSCE 145 Algorithmic Design I - 4\n");
        plan.append("CSCE 190 Computing in the Modern World - 1\n");
        plan.append("Electives - 3\n\n");
        
        // Semester Two
        plan.append("Semester Two:\n");
        plan.append("ENGL 102 Rhetoric and Composition - 3\n");
        plan.append("MATH 142 Calculus II - 4\n");
        plan.append("CHEM 111 General Chemistry I - 3\n");
        plan.append("CHEM 111L General Chemistry I Lab - 1\n");
        plan.append("CSCE 146 Algorithmic Design II - 4\n");
        plan.append("CSCE 215 UNIX/Linux Fundamentals - 1\n\n");
        
        // Semester Three
        plan.append("Semester Three\n");
        plan.append("CSCE 211 Digital Logic Design - 3\n");
        plan.append("CSCE 240 Advanced Programming Techniques - 3\n");
        plan.append("MATH 374 Discrete Structures - 3\n");
        plan.append("CHEM 112 General Chemistry II - 3\n");
        plan.append("CHEM 112L General Chemistry II Lab - 1\n");
        plan.append("SPCH 140 Public Communication - 3\n\n");

        //Semester Four
        plan.append("Semester Four\n");
        plan.append("CSCE 212 Intro. to Computer Architecture - 3\n");
        plan.append("CSCE 247 Software Engineering - 3\n");
        plan.append("Laboratory Science Elective - 4\n");
        plan.append("MATH 241 Vector Calculus - 3\n");
        plan.append("Electives - 3\n\n");
        
        return plan.toString();
    }

    public String getCISMajorPlan() {
        StringBuilder plan = new StringBuilder();
        
        // Semester One
        plan.append("Semester One\n");
        plan.append("ENGL 101 Critical Reading and Composition - 3\n");
        plan.append("MATH 122 Calc. for Bus. Admin - 3\n");
        plan.append("CSCE 145 Algorithmic Design I - 4\n");
        plan.append("CSCE 190 Computing in the Modern World - 1\n");
        plan.append("Electives - 4\n\n");
        
        // Semester Two
        plan.append("Semester Two\n");
        plan.append("ENGL 102 Rhetoric and Composition - 3\n");
        plan.append("Carolina Core SCI4 - 4\n");
        plan.append("CSCE 146 Algorithmic Design II - 4\n");
        plan.append("CSCE 215 UNIX/Linux Fundamentals - 1\n");
        plan.append("Electives - 3\n\n");
        
        // Semester Three
        plan.append("Semester Three:\n");
        plan.append("CSCE 242 Web Applications - 3\n");
        plan.append("CSCE 210 Computer Hardware Foundations - 3\n");
        plan.append("CSCE 247 Software Engineering - 3\n");
        plan.append("ECON 224 Introduction to Economics - 3\n");
        plan.append("Electives - 3\n\n");
        
        // Semester Four
        plan.append("Semester Four:\n");
        plan.append("CSCE 201 Introduction to Computer Security - 3\n");
        plan.append("CSCE 240 Advanced Programming Techniques - 3\n");
        plan.append("MATH 374 Discrete Structures - 3\n");
        plan.append("MGSC 290 Computer Info. Systems in Bus. - 3\n");
        plan.append("Electives - 3\n\n");
        
        return plan.toString();
    }

    public String getCEMajorPlan() {
        StringBuilder plan = new StringBuilder();
        
        // Semester One
        plan.append("Semester One\n");
        plan.append("ENGL 101 Critical Reading and Composition - 3\n");
        plan.append("MATH 141 Calculus I - 4\n");
        plan.append("CHEM 111 General Chemistry I - 3\n");
        plan.append("CHEM 111L General Chemistry I Lab - 1\n");
        plan.append("ECIV 101 Introduction to Civil Engineering - 3\n");
        plan.append("Electives - 3\n\n");
        
        // Semester Two
        plan.append("Semester Two:\n");
        plan.append("ENGL 102 Rhetoric and Composition - 3\n");
        plan.append("MATH 142 Calculus II - 4\n");
        plan.append("PHYS 211 Essentials of Physics I - 3\n");
        plan.append("PHYS 211L Essentials of Physics I Lab - 1\n");
        plan.append("ECIV 200 Statics - 3\n");
        plan.append("Electives - 3\n\n");
        
        // Semester Three
        plan.append("Semester Three:\n");
        plan.append("ECIV 201 Computational Methods for Civil Engr. - 3\n");
        plan.append("Foundational Math Elective - 3\n");
        plan.append("! ECIV 220 Mechanics of Solids - 3\n");
        plan.append("Basic Science Elective - 3\n");
        plan.append("Electives - 3\n\n");
        
        // Semester Four
        plan.append("Semester Four:\n");
        plan.append("ECIV 111 Intro. to Engr. Graphics & Visualization - 3\n");
        plan.append("ECIV 360 Fluid Mechanics - 3\n");
        plan.append("MATH 242 Elem. Differential Equations - 3\n");
        plan.append("STAT 509 Statistics for Engineers - 3\n");
        plan.append("Foundational Math/Science Elective - 3\n\n");
        
        
        return plan.toString();
    }





    
    

}