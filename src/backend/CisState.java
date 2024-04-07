package backend;

import java.util.ArrayList;
import java.util.UUID;

public class CisState extends MajorState {
    private ArrayList<Class> businessInformationManagement;

    public CisState(Roadmap roadmap) {
        super(roadmap);
        this.businessInformationManagement = new ArrayList<>();
        setMajor("cis");
        
    };

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