package backend;
import java.util.ArrayList;

public class StatusState {
    private MajorState majorState;


    public StatusState(MajorState majorState) {
        this.majorState = majorState;
    }


    public String GetDefaultClasses(MajorState majorState) {
            StringBuilder msString = new StringBuilder();
    
            msString.append("\nMajor Classes: \n");
            if(!majorState.getMajorClasses().isEmpty()) {
                for (Class course : majorState.getMajorClasses()) {
                   msString.append(course.toString());
                }
            } else {
                msString.append("No major classes available\n");
            }
            
            msString.append("\nCarolina Core: \n");
            if(!majorState.getCarolinaCore().isEmpty()) {
                for (Class course : majorState.getCarolinaCore()) {
                    msString.append(course.toString());
                }
            }
    
            msString.append("\nElectives: \n");
            if(!majorState.getElectives().isEmpty()) {
                for (Class course : majorState.getElectives()) {
                    msString.append(course.toString());
                }
            }
    
            msString.append("\nLiberal Arts Electives: \n");
            if(!majorState.getLiberalArtsElectives().isEmpty()) {
                for (Class course : majorState.getLiberalArtsElectives()) {
                    msString.append(course.toString());
                }
            }
    
            msString.append("\nFoundational Courses: \n");
            if (!majorState.getFoundationalCourses().isEmpty()) {
                for (Class course : majorState.getFoundationalCourses()) {
                    msString.append(course.toString());
                }
            }
    
            msString.append("\nLower Division Computing: \n");
            if (!majorState.getLowerDivisionComputing().isEmpty()) {
                for (Class course : majorState.getLowerDivisionComputing()) {
                    msString.append(course.toString());
                }
            }
            
    
    
    
            return msString.toString();
    
    }





}