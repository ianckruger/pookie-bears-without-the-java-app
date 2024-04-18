package backend;

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
import java.util.ArrayList;

public class RoadmapApplication {

    private UserList userlist;
    private Roadmap roadmap;
    private User user;
    // private Scanner scanner;
    private CourseList courseList;
    private static  RoadmapApplication application;

    


    public RoadmapApplication() {
        this.userlist = UserList.getInstance();
    }

    public static RoadmapApplication  getInstance(){
        if( application == null){
            application = new  RoadmapApplication();
        }
        
        return application;
    }

    public boolean register(String userName, String firstName, String lastName, String password, String userType) {
        if(userlist.register(userName, firstName, lastName, password, userType)) {
           return true;
        } else
        return false;

   }

    public boolean login(String userName, String password, Scanner scanner) {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        if(users.login(userName, password, scanner)) {
            return true;
        }
        return false;
       
    }


    public void advisor(int choice, Scanner scanner) {
        UserList userList = UserList.getInstance();
        userList.advisor(choice, scanner);
    }

    public void student(Scanner scanner) {
        UserList userList = UserList.getInstance();
        userList.student(scanner);
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
            System.out.println(major);
            if (major != null ) {
                Roadmap roadmap = Roadmap.getInstance();
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

    public boolean printEightSemesterPlan() {
        Student student = (Student)userlist.getActive();
        if(student != null) {
            String major = student.getCurrentMajor();
            if(major != null) {
                Roadmap roadmap = Roadmap.getInstance();
                System.out.println(roadmap.EightSemesterPlan());
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
    public ArrayList<Class> getClasses() {
        Student student = (Student)userlist.getActive();
        if(student != null) {
            String major = student.getCurrentMajor();
            if(major != null) {
                return roadmap.getClasses();
            } 
        }   
        return null;
    }

    public ArrayList<Class> getCompletedClasses() {
        Student student = (Student)userlist.getActive();
        if(student != null) {
            String major = student.getCurrentMajor();
            if(major!= null) {
                return roadmap.getCompletedClasses();
            }
        }
        return null;
    }

    public ArrayList<Class> getIncompletedClasses() {
        Student student = (Student)userlist.getActive();
        if(student != null) {
            String major = student.getCurrentMajor();
            if(major!= null) {
                return roadmap.getIncompletedClasses();
            }
        }
        return null;
    }







   
}