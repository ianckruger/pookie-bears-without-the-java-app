package backend;

import java.util.ArrayList;
import java.util.UUID;

public class CisState extends MajorState {
    private ArrayList<Class> businessInformationManagement;

    public CisState(Roadmap roadmap) {
        super(roadmap);
        this.businessInformationManagement = new ArrayList<>();
        setMajor("cis");
        GenerateSemesterPlan();
    }

    public void GenerateSemesterPlan() {
        CourseList courseList = CourseList.getInstance();
        SemesterOne.add(courseList.searchClass("ENGL", "101"));
        SemesterOne.add(courseList.searchClass("MATH", "141"));
        SemesterOne.add(courseList.searchClass("CSCE", "145"));
        SemesterOne.add(courseList.searchClass("CSCE", "190"));
        SemesterOne.add(courseList.searchClass("ANTH", "161"));
        
        SemesterTwo.add(courseList.searchClass("ENGL", "102"));
        SemesterTwo.add(courseList.searchClass("FAMS", "240"));
        SemesterTwo.add(courseList.searchClass("CHEM", "111"));
        SemesterTwo.add(courseList.searchClass("CHEM", "111L"));
        SemesterTwo.add(courseList.searchClass("CSCE", "146"));
        SemesterTwo.add(courseList.searchClass("CSCE", "215"));
        
        SemesterThree.add(courseList.searchClass("CSCE", "242"));
        SemesterThree.add(courseList.searchClass("CSCE", "210"));
        SemesterThree.add(courseList.searchClass("CSCE", "247"));
        SemesterThree.add(courseList.searchClass("ECON", "224"));
        SemesterThree.add(courseList.searchClass("SPCH", "140"));
        
        SemesterFour.add(courseList.searchClass("CSCE", "201"));
        SemesterFour.add(courseList.searchClass("CSCE", "240"));
        SemesterFour.add(courseList.searchClass("MATH", "374"));
        SemesterFour.add(courseList.searchClass("MGSC", "290"));
        SemesterFour.add(courseList.searchClass("POLI", "201"));
        
        SemesterFive.add(courseList.searchClass("ACCT", "222"));
        SemesterFive.add(courseList.searchClass("MGMT", "371"));
        SemesterFive.add(courseList.searchClass("CSCE", "350"));
        SemesterFive.add(courseList.searchClass("CSCE", "390"));
        SemesterFive.add(courseList.searchClass("ENGL", "463"));
        SemesterFive.add(courseList.searchClass("STAT", "515"));        
        
        SemesterSix.add(courseList.searchClass("CSCE", "520"));
        SemesterSix.add(courseList.searchClass("STAT", "516"));
        SemesterSix.add(courseList.searchClass("ACCT", "324"));
        SemesterSix.add(courseList.searchClass("CSCE", "594"));
        SemesterSix.add(courseList.searchClass("HIST", "101"));
        
        SemesterSeven.add(courseList.searchClass("CSCE", "490"));
        SemesterSeven.add(courseList.searchClass("CSCE", "416"));
        SemesterSeven.add(courseList.searchClass("CSCE", "522"));
        SemesterSeven.add(courseList.searchClass("ITEC", "560"));
        SemesterSeven.add(courseList.searchClass("ECON", "311"));
        
        SemesterEight.add(courseList.searchClass("CSCE", "492"));
        SemesterEight.add(courseList.searchClass("MATH", "344"));
        SemesterEight.add(courseList.searchClass("MATH", "344L"));
        SemesterEight.add(courseList.searchClass("PHIL", "102"));
        SemesterEight.add(courseList.searchClass("ITAL", "121"));
    }

    public ArrayList<Class> getBusinessInformationManagement() {
        return businessInformationManagement;
    }

    
    public String toString() {
        StringBuilder cisString = new StringBuilder(super.toString());

        cisString.append("\nBusiness Information Management Electives:\n");
        for (Class course : businessInformationManagement) {
            cisString.append(course.toString());
        }

        return cisString.toString();
    }

    public void clear() {
        this.clear();
        this.businessInformationManagement.clear();

    }
    
}