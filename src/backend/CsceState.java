package backend;

import java.util.ArrayList;

public class CsceState extends MajorState {
    private ArrayList<Class> labScienceElective;

    public CsceState(Roadmap roadmap) {
        super(roadmap);
        this.labScienceElective = new ArrayList<>();
        setMajor("csce");
        GenerateSemesterPlan();
    };

    public void GenerateSemesterPlan() {
        CourseList courseList = CourseList.getInstance();
        SemesterOne.add(courseList.searchClass("ENGL", "101"));
        SemesterOne.add(courseList.searchClass("MATH", "141"));
        SemesterOne.add(courseList.searchClass("CSCE", "145"));
        SemesterOne.add(courseList.searchClass("CSCE", "190"));
        SemesterOne.add(courseList.searchClass("FAMS", "300"));

        SemesterTwo.add(courseList.searchClass("ENGL", "102"));
        SemesterTwo.add(courseList.searchClass("MATH", "142"));
        SemesterTwo.add(courseList.searchClass("CHEM", "111"));
        SemesterTwo.add(courseList.searchClass("CHEM", "111L"));
        SemesterTwo.add(courseList.searchClass("CSCE", "146"));
        SemesterTwo.add(courseList.searchClass("CSCE", "215"));

        SemesterThree.add(courseList.searchClass("CSCE", "211"));
        SemesterThree.add(courseList.searchClass("CSCE", "240"));
        SemesterThree.add(courseList.searchClass("MATH", "374"));
        SemesterThree.add(courseList.searchClass("CHEM", "112"));
        SemesterThree.add(courseList.searchClass("CHEM", "112L"));
        SemesterThree.add(courseList.searchClass("SPCH", "145"));

        SemesterFour.add(courseList.searchClass("CSCE", "212"));
        SemesterFour.add(courseList.searchClass("CSCE", "247"));
        SemesterFour.add(courseList.searchClass("MATH", "241"));
        SemesterFour.add(courseList.searchClass("GEOL", "101"));
        SemesterFour.add(courseList.searchClass("AFAM", "201"));

        SemesterFive.add(courseList.searchClass("CSCE", "311"));
        SemesterFive.add(courseList.searchClass("CSCE", "330"));
        SemesterFive.add(courseList.searchClass("CSCE", "350"));
        SemesterFive.add(courseList.searchClass("CSCE", "390"));
        SemesterFive.add(courseList.searchClass("ENGL", "463"));

        SemesterSix.add(courseList.searchClass("CSCE", "416"));
        SemesterSix.add(courseList.searchClass("STAT", "509"));
        SemesterSix.add(courseList.searchClass("ITAL", "121"));
        SemesterSix.add(courseList.searchClass("CSCE", "510"));
        SemesterSix.add(courseList.searchClass("PHIL", "213"));

        SemesterSeven.add(courseList.searchClass("CSCE", "490"));
        SemesterSeven.add(courseList.searchClass("CSCE", "355"));
        SemesterSeven.add(courseList.searchClass("CSCE", "317"));
        SemesterSeven.add(courseList.searchClass("MATH", "344"));
        SemesterSeven.add(courseList.searchClass("MATH", "344L"));
        SemesterSeven.add(courseList.searchClass("ECON", "221"));

        SemesterEight.add(courseList.searchClass("CSCE", "492"));
        SemesterEight.add(courseList.searchClass("CSCE", "611"));
        SemesterEight.add(courseList.searchClass("ITEC", "560"));
        SemesterEight.add(courseList.searchClass("HIST", "111"));
        SemesterEight.add(courseList.searchClass("AFAM", "202"));
    }

    public ArrayList<Class> getLabScienceElective() {
        return labScienceElective;
    }

    public void setLabScienceElective(ArrayList<Class> labScienceElective) {
        this.labScienceElective = labScienceElective;
    }

    public String toString() {
        StringBuilder csceString = new StringBuilder(super.toString());

        csceString.append("\nLab Science Electives: \n");
        for (Class course : labScienceElective) {
            csceString.append(course.toString());
        }
        return csceString.toString();
    
    }

    public void clear() {
        this.clear();
        this.labScienceElective.clear();
    }

    
    
}