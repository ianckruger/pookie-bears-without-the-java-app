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
    protected ArrayList<Class> SemesterOne;
    protected ArrayList<Class> SemesterTwo;
    protected ArrayList<Class> SemesterThree;
    protected ArrayList<Class> SemesterFour;
    protected ArrayList<Class> SemesterFive;
    protected ArrayList<Class> SemesterSix;
    protected ArrayList<Class> SemesterSeven;
    protected ArrayList<Class> SemesterEight;
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
        this.SemesterOne = new ArrayList<>();
        this.SemesterTwo = new ArrayList<>();
        this.SemesterThree = new ArrayList<>();
        this.SemesterFour = new ArrayList<>();
        this.SemesterFive = new ArrayList<>();
        this.SemesterSix = new ArrayList<>();
        this.SemesterSeven = new ArrayList<>();
        this.SemesterEight = new ArrayList<>();
    }

    public ArrayList<Class> getSemesterOne() {
        return this.SemesterOne;
    }

    public ArrayList<Class> getSemesterTwo() {
        return this.SemesterTwo;
    }

    public ArrayList<Class> getSemesterThree() {
        return this.SemesterThree;
    }

    public ArrayList<Class> getSemesterFour() {
        return this.SemesterFour;
    }

    public ArrayList<Class> getSemesterFive() {
        return this.SemesterFive;
    }

    public ArrayList<Class> getSemesterSix() {
        return this.SemesterSix;
    }

    public ArrayList<Class> getSemesterSeven() {
        return this.SemesterSeven;
    }

    public ArrayList<Class> getSemesterEight() {
        return this.SemesterEight;
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

    public void setAdvisorNotes(ArrayList<String> notes) {
        this.advisorNotes = notes;
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

    public String GetDefaultClasses() {
        StringBuilder msString = new StringBuilder();

        msString.append("\nAdvisor Notes: \n");
        if(!advisorNotes.isEmpty()) {
            for (String note : advisorNotes) {
               msString.append(note);
            }
        }

        msString.append("\n\nMajor Classes: \n");
        
        if(!getMajorClasses().isEmpty()) {
            for (Class course : getMajorClasses()) {
               msString.append(course.toString());
            }
        }
        
        msString.append("\nCarolina Core: \n");
        if(!getCarolinaCore().isEmpty()) {
            for (Class course : getCarolinaCore()) {
                msString.append(course.toString());
            }
        }

        msString.append("\nElectives: \n");
        if(!getElectives().isEmpty()) {
            for (Class course : getElectives()) {
                msString.append(course.toString());
            }
        }

        msString.append("\nLiberal Arts Electives: \n");
        if(!getLiberalArtsElectives().isEmpty()) {
            for (Class course : getLiberalArtsElectives()) {
                msString.append(course.toString());
            }
        }

        msString.append("\nFoundational Courses: \n");
        if (!getFoundationalCourses().isEmpty()) {
            for (Class course : getFoundationalCourses()) {
                msString.append(course.toString());
            }
        }

        msString.append("\nLower Division Computing: \n");
        if (!getLowerDivisionComputing().isEmpty()) {
            for (Class course : getLowerDivisionComputing()) {
                msString.append(course.toString());
            }
        }
        return msString.toString();
    }


public String GetCompletedClasses(MajorState majorState) {
    StringBuilder msString = new StringBuilder();

        msString.append("\nMajor Classes: \n");
        if(!getMajorClasses().isEmpty()) {
            for (Class course : getMajorClasses()) {
                if(course.IsCompleted() || course.inProgress())
                    msString.append(course.toString());
            }
        }
        
        msString.append("\nCarolina Core: \n");
        if(!getCarolinaCore().isEmpty()) {
            for (Class course : getCarolinaCore()) {
                if(course.IsCompleted() || course.inProgress()) 
                    msString.append(course.toString());
            }
        }

        msString.append("\nElectives: \n");
        if(!getElectives().isEmpty()) {
            for (Class course : getElectives()) {
                if(course.IsCompleted() || course.inProgress())
                    msString.append(course.toString());
            }
        }

        msString.append("\nLiberal Arts Electives: \n");
        if(!getLiberalArtsElectives().isEmpty()) {
            for (Class course : getLiberalArtsElectives()) {
                if(course.IsCompleted() || course.inProgress())
                    msString.append(course.toString());
            }
        }

        msString.append("\nFoundational Courses: \n");
        if (!getFoundationalCourses().isEmpty()) {
            for (Class course : getFoundationalCourses()) {
                if(course.IsCompleted() || course.inProgress())
                    msString.append(course.toString());
            }
        }

        msString.append("\nLower Division Computing: \n");
        if (!getLowerDivisionComputing().isEmpty()) {
            for (Class course : getLowerDivisionComputing()) {
                if(course.IsCompleted() || course.inProgress())
                    msString.append(course.toString());
            }
        }
        return msString.toString();
    }

    public String GetIncompletedClasses(MajorState majorState) {
    StringBuilder msString = new StringBuilder();

        msString.append("\nMajor Classes: \n");
        if(!getMajorClasses().isEmpty()) {
            for (Class course : getMajorClasses()) {
                if(!course.IsCompleted() || course.inProgress())
                    msString.append(course.toString());
            }
        }
        
        msString.append("\nCarolina Core: \n");
        if(!getCarolinaCore().isEmpty()) {
            for (Class course : getCarolinaCore()) {
                if(!course.IsCompleted() || course.inProgress()) 
                    msString.append(course.toString());
            }
        }

        msString.append("\nElectives: \n");
        if(!getElectives().isEmpty()) {
            for (Class course : getElectives()) {
                if(!course.IsCompleted() || course.inProgress())
                    msString.append(course.toString());
            }
        }

        msString.append("\nLiberal Arts Electives: \n");
        if(!getLiberalArtsElectives().isEmpty()) {
            for (Class course : getLiberalArtsElectives()) {
                if(!course.IsCompleted() || course.inProgress())
                    msString.append(course.toString());
            }
        }

        msString.append("\nFoundational Courses: \n");
        if (!getFoundationalCourses().isEmpty()) {
            for (Class course : getFoundationalCourses()) {
                if(!course.IsCompleted() || course.inProgress())
                    msString.append(course.toString());
            }
        }

        msString.append("\nLower Division Computing: \n");
        if (!getLowerDivisionComputing().isEmpty()) {
            for (Class course : getLowerDivisionComputing()) {
                if(!course.IsCompleted() || course.inProgress())
                    msString.append(course.toString());
            }
        }
        return msString.toString();
    }





}