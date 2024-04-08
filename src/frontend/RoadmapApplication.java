package frontend;

import java.util.ArrayList;
import java.util.Scanner;

import backend.User;
import backend.UserList;
import backend.Advisor;
import backend.CeState;
import backend.CisState;
import backend.CourseList;
import backend.CsceState;
import backend.DataLoader;
import backend.DataWriter;
import backend.Parent;
import backend.Roadmap;
import backend.RoadmapList;
import backend.Student;

public class RoadmapApplication {

    private UserList userlist;
    private Roadmap roadmap;
    private User user;
    private Scanner scanner;
    private CourseList courseList;
    


    public RoadmapApplication() {
        this.userlist = UserList.getInstance();
        this.scanner = new Scanner(System.in);
 
        
    }


    public boolean login(String userName, String password) {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        try (Scanner scanner = new Scanner(System.in)) {
            if (userList != null) {
                for (User user : userList) {
                    if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                        // If user is a student
                        if (user.getUserType().equalsIgnoreCase("student")) {
                            Student student = (Student) user;
                            users.setActiveUser(student);
                            CourseList courseList = CourseList.getInstance();
                            Roadmap roadmap = Roadmap.getInstance();
                            setRoadmap(roadmap);
                            roadmap.setMajorState(student.getCurrentMajor());
                            return true;
                        } else if (user.getUserType().equalsIgnoreCase("advisor")) {
                            users.setAdvisor(user);
                            return true;
                        }
                        
                    }
                }
            }
        } 
        return false; // Return false if no user is found or incorrect credentials
    }


    public void advisor() {
        UserList userList = UserList.getInstance();
        userList.advisor();
    }

    public void student() {
        UserList userList = UserList.getInstance();
        userList.student();
    }
     


 
 
    public boolean register(String userName, String firstName, String lastName, String password, String userType) {
         if ( userType.equalsIgnoreCase("student")) {
            Student student = new Student(userName, firstName, lastName, password, userType);
            userlist.addUser(student);
            DataWriter.saveUsers();
            return true;
        } else if(userType.equalsIgnoreCase("parent")) {
            Parent parent = new Parent(userName, firstName, lastName, password, userType);
            userlist.addUser(parent);
            DataWriter.saveUsers();
            return true;
        } else if(userType.equalsIgnoreCase("advisor")) {
            Advisor advisor = new Advisor(userName, firstName, lastName, password, userType);
            userlist.addUser(advisor);
            DataWriter.saveUsers();
            return true;
        }

 
        return false;

    }

    public boolean isUsernameTaken(String userName) {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        for (User user : userList) {
            if(user.getUserName().equals(userName) && user.getUserName() != null) {
                return true;
            }

        }
        return false;

    }

    public boolean logout() {
        if (user != null) {
            return false;
        }
        DataWriter.saveUsers();
        user = null;
        return true;

    }

    public boolean printStudentProgress() {
        Student student = (Student)userlist.getActive();
 
        if(student != null) {
            String major = student.getCurrentMajor();
            if (major != null ) {
               System.out.println(roadmap.displayClasses());
                return true;
            } else {
                System.out.println("Student's major type not found.");
                 return false;
            }
        } else {
            System.out.println("Student is null");
            return false;
        }
        
        
         
    }

    public boolean addNoteToStudent(String note) {
        if (note != null) {
            System.out.println(note);
            return true;
        }
        return false;

    }

    public void setRoadmap(Roadmap roadmap) {
        this.roadmap = roadmap;
    }


   
}