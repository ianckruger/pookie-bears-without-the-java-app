package backend;

import java.util.ArrayList;
import java.util.UUID;

public abstract class MajorState {

    protected Roadmap roadmap;
    protected ArrayList<Class> majorClasses;
    protected ArrayList<Class> carolinaCore;
    protected ArrayList<Class> electives;
    protected ArrayList<Class> liberalArtsElectives;
    protected ArrayList<Class> foundationalCourses;
    protected ArrayList<Class> lowerDivisionComputing;
    protected MajorState majorState;
    protected ArrayList<String> advisorNotes;
    protected String major;

    public MajorState(Roadmap roadmap) {
        this.roadmap = roadmap;
        this.majorClasses = new ArrayList<>();
        this.carolinaCore = new ArrayList<>();
        this.electives = new ArrayList<>();
        this.liberalArtsElectives = new ArrayList<>();
        this.foundationalCourses = new ArrayList<>();
        this.lowerDivisionComputing = new ArrayList<>();
        this.advisorNotes = new ArrayList<>();   
    }

    public MajorState(MajorState majorState) {
        this.majorState = majorState;
    }

    public ArrayList<Class> getMajorClasses() {
        return majorClasses;
    }

    public void setMajorClasses(ArrayList<Class> majorClasses) {
        this.majorClasses = majorClasses;
    }

    public ArrayList<Class> getCarolinaCore() {
        return carolinaCore;
    }

    public void setCarolinaCore(ArrayList<Class> carolinaCore) {
        this.carolinaCore = carolinaCore;
    }

    public ArrayList<Class> getLiberalArtsElectives() {
        return liberalArtsElectives;
    }
    
    public void setLiberalArtsElectives(ArrayList<Class> liberalArtsElectives) {
        this.liberalArtsElectives = liberalArtsElectives;
    }

    public ArrayList<Class> getFoundationalCourses() {
        return foundationalCourses;
    }

    public void setFoundationalCourses(ArrayList<Class> foundationalCourses) {
        this.foundationalCourses = foundationalCourses;
    }

    public ArrayList<Class> getLowerDivisionComputing() {
        return lowerDivisionComputing;
    }

    public void setLowerDivisionComputing(ArrayList<Class> lowerDivisionComputing) {
        this.lowerDivisionComputing = lowerDivisionComputing;
    }

    public ArrayList<Class> getElectives() {
        return electives;
    }

    public void setElectives(ArrayList<Class> electives) {
        this.electives = electives;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return this.major;
    }

    public void clear() {
        this.majorClasses.clear();
        this.carolinaCore.clear();
        this.electives = new ArrayList<>();
        this.liberalArtsElectives.clear();
        this.foundationalCourses.clear();
        this.lowerDivisionComputing.clear();
        this.advisorNotes.clear();
    }


    public String toString() {
        StringBuilder msString = new StringBuilder();

        msString.append("\nMajor Classes: \n");
        if(!majorClasses.isEmpty()) {
            for (Class course : majorClasses) {
               msString.append(course.toString());
            }
        } else {
            msString.append("No major classes available\n");
        }
        


        msString.append("\nCarolina Core: \n");
        if(!carolinaCore.isEmpty()) {
            for (Class course : carolinaCore) {
                msString.append(course.toString());
            }
        }

        msString.append("\nElectives: \n");
        if(!electives.isEmpty()) {
            for (Class course : electives) {
                msString.append(course.toString());
            }
        }

        msString.append("\nLiberal Arts Electives: \n");
        if(!liberalArtsElectives.isEmpty()) {
            for (Class course : liberalArtsElectives) {
                msString.append(course.toString());
            }
        }

        msString.append("\nFoundational Courses: \n");
        if (!foundationalCourses.isEmpty()) {
            for (Class course : foundationalCourses) {
                msString.append(course.toString());
            }
        }

        msString.append("\nLower Division Computing: \n");
        if (!lowerDivisionComputing.isEmpty()) {
            for (Class course : lowerDivisionComputing) {
                msString.append(course.toString());
            }
        }

        return msString.toString();
    }





}