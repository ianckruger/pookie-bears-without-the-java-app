package backend;

import java.util.ArrayList;

public class CsceState extends MajorState {
    private ArrayList<Class> labScienceElective;

    public CsceState(Roadmap roadmap) {
        super(roadmap);
        this.labScienceElective = new ArrayList<>();
        setMajor("csce");
    };

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