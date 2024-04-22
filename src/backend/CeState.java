package backend;

import java.util.ArrayList;
import java.util.UUID;

public class CeState extends MajorState {
    private ArrayList<Class> electricalEngineering;

    public CeState(Roadmap roadmap) {
        super(roadmap);
        this.electricalEngineering = new ArrayList<>();
        setMajor("ce");
        GenerateSemesterPlan();
    }

    public void GenerateSemesterPlan() {
        CourseList courseList = CourseList.getInstance();
        SemesterOne.add(courseList.searchClass("ENGL", "101"));
        SemesterOne.add(courseList.searchClass("MATH", "141"));
        SemesterOne.add(courseList.searchClass("CSCE", "145"));
        SemesterOne.add(courseList.searchClass("CSCE", "190"));
        SemesterOne.add(courseList.searchClass("CHEM", "111"));
        SemesterOne.add(courseList.searchClass("CHEM", "111L"));

        SemesterTwo.add(courseList.searchClass("ENGL", "102"));
        SemesterTwo.add(courseList.searchClass("MATH", "142"));
        SemesterOne.add(courseList.searchClass("FAMS", "300"));
        SemesterTwo.add(courseList.searchClass("CSCE", "146"));
        SemesterTwo.add(courseList.searchClass("CSCE", "215"));
        
        SemesterThree.add(courseList.searchClass("CSCE", "211"));
        SemesterThree.add(courseList.searchClass("SPCH", "145"));
        SemesterThree.add(courseList.searchClass("MATH", "374"));
        SemesterThree.add(courseList.searchClass("PHYS", "211"));
        SemesterThree.add(courseList.searchClass("PHYS", "211L"));
        SemesterThree.add(courseList.searchClass("ELCT", "102"));
       
        SemesterFour.add(courseList.searchClass("CSCE", "212"));
        SemesterFour.add(courseList.searchClass("CSCE", "240"));
        SemesterFour.add(courseList.searchClass("MATH", "242"));
        SemesterFour.add(courseList.searchClass("PHYS", "212"));
        SemesterFour.add(courseList.searchClass("PHYS", "212L"));
        SemesterFour.add(courseList.searchClass("ELCT", "221"));
        
        SemesterFive.add(courseList.searchClass("CSCE", "311"));
        SemesterFive.add(courseList.searchClass("CSCE", "611"));
        SemesterFive.add(courseList.searchClass("CSCE", "274"));
        SemesterFive.add(courseList.searchClass("ELCT", "222"));
        SemesterFive.add(courseList.searchClass("STAT", "509"));
        
        SemesterSix.add(courseList.searchClass("CSCE", "313"));
        SemesterSix.add(courseList.searchClass("CSCE", "350"));
        SemesterSix.add(courseList.searchClass("MATH", "241"));
        SemesterSix.add(courseList.searchClass("CSCE", "390"));
        SemesterSix.add(courseList.searchClass("ENGL", "462"));
        SemesterFive.add(courseList.searchClass("ELCT", "201"));
        
        SemesterSeven.add(courseList.searchClass("CSCE", "490"));
        SemesterSeven.add(courseList.searchClass("CSCE", "416"));
        SemesterSeven.add(courseList.searchClass("CSCE", "330"));
        SemesterSeven.add(courseList.searchClass("CSCE", "355"));
        SemesterSeven.add(courseList.searchClass("AFAM", "201"));
        SemesterSeven.add(courseList.searchClass("ELCT", "321"));
        
        SemesterEight.add(courseList.searchClass("CSCE", "492"));
        SemesterEight.add(courseList.searchClass("CSCE", "491"));
        SemesterEight.add(courseList.searchClass("ITAL", "121"));
        SemesterEight.add(courseList.searchClass("HIST", "111"));
        SemesterEight.add(courseList.searchClass("MATH", "344"));
        SemesterEight.add(courseList.searchClass("MATH", "344L"));
    }

    public ArrayList<Class> getElectricalEngineering() {
        return electricalEngineering;
    }

    public String toString() {
        StringBuilder ceString = new StringBuilder(super.toString());

        ceString.append("\nElectrical Engineering Courses:\n");
        for (Class course : electricalEngineering) {
            ceString.append(course.toString());
        }

        return ceString.toString();
    }

    public void clear() {
        this.clear();
        this.electricalEngineering.clear();
    }
    
}