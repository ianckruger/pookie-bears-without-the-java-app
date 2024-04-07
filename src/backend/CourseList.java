package backend;
import java.util.ArrayList;

public class CourseList {

    private static CourseList courses;
    private ArrayList<Class> courseList;

    private CourseList() {
        this.courseList = new ArrayList<Class>();
    }

    public static CourseList getInstance() {
        if (courses == null) {
            courses = new CourseList();
            courses.courseList = DataLoader.readCourses();
            if (courses.courseList.isEmpty()) {
                System.out.println("No courses found in the course list.");
            } else {
                System.out.println("Courses loaded successfully:");
            }
        }
        return courses;
            
        
    }

    public ArrayList<Class> getCourses() {
        return courseList;
    }

    public void addCourse(Class course) {
        courseList.add(course);
    }
    

}
