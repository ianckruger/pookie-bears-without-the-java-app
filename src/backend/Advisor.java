package backend;

import java.util.ArrayList;
import java.util.UUID;

public class Advisor extends User {
    private ArrayList<String> students;
    private ArrayList<Student> student;
    private User advising;

 
    public Advisor(String userName, String firstName, String lastName, String password, String userType) {
        super(userName, firstName, lastName, password, userType);
        this.students = new ArrayList<String>();
        this.student = new ArrayList<Student>();
        this.advising = null;
 

    }
    public Advisor(String userName, String firstName, String lastName, String password, String userType, ArrayList<String> students, User advising) {
        super(userName,firstName, lastName, password, userType);
        this.student = new ArrayList<Student>();
        this.advising = advising;
        this.students = students;
    }

    public Advisor(String username, UUID userID, String firstName, String lastName, String password, String userType, ArrayList<String> students) {
        super(userID, username, firstName, lastName, password, userType);
        this.students = students;
        this.student = new ArrayList<Student>();
    }

    public User getAdvising() {
        return advising;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void addStudent(String studentId) {
        students.add(studentId);
    }
}