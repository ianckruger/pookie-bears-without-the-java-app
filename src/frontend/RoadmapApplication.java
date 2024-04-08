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

    public boolean register(String userName, String firstName, String lastName, String password, String userType) {
        if(userlist.register(userName, firstName, lastName, password, userType)) {
           return true;
        } else
        return false;

   }

    public boolean login(String userName, String password) {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        if(users.login(userName, password)) {
            return true;
        }
        return false;
       
    }


    public void advisor() {
        UserList userList = UserList.getInstance();
        userList.advisor();
    }

    public void student() {
        UserList userList = UserList.getInstance();
        userList.student();
    }

    

    public int RoadmapAdvisorOptions(User user) {
        UserList userList = UserList.getInstance();
        userList.RoadmapAdvisorOptions();
    }

    public boolean addAdvisee(String advisorUsername, String studentId) {
         UserList userList = UserList.getInstance();
        
        // Loop through the user list to find the advisor and student
        for (User user : userList.getUsers()) {
            // Check if the user is an advisor and has the provided username
            if (user.getUserType().equalsIgnoreCase("advisor") && user.getUserName().equals(advisorUsername)) {
                Advisor advisor = (Advisor) user; // Cast the user to an advisor
                // Find the student object based on the studentId
                for (User student : userList.getUsers()) {
                    if (student.getUserUUID().toString().equals(studentId) && student.getUserType().equalsIgnoreCase("student")) {
                        // Add the student to the advisor's list of students
                        advisor.addStudent(studentId);
                        return true;
                    }
                }
            }
        }
        return false; // Return false if advisor or student not found, or student is not of type "student"
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
        if(userlist.logout()) {
            return true;
        }
        return false;

    }

    public boolean printStudentProgress() {
        Student student = (Student)userlist.getActive();
 
        if(student != null) {
            String major = student.getCurrentMajor();
            if (major != null ) {
                Roadmap roadmap = Roadmap.getInstance()
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