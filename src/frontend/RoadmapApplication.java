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
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        User user = users.getAdvisor();
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = RoadmapAdvisorOptions(user);
            if (choice == 1) {
                System.out.println("Enter a student ID to find: ");
                String studentId = scanner.nextLine();
                for (User student : userList) {
                    if (student.getUserUUID().toString().equals(studentId) && student.getUserType().equalsIgnoreCase("student")) {
                        users.setActiveUser(student);
                        this.courseList = CourseList.getInstance();
                        this.roadmap = Roadmap.getInstance();

                    }
                }
            }
            else if (choice == 2) {
                if (users.getActive() != null) {
                    System.out.println("What note would you like to add?: ");
                    String note = scanner.nextLine();
                    Student student = (Student)users.getActive();
                    ArrayList<String> notes = student.getNotes();
                    notes.add(note);


                } else {
                    System.out.println("Load a student first.");
                }

                }
            }
    }

    public void student() {
        UserList users = UserList.getInstance();
        Student student = (Student)users.getActive();
        System.out.println("Hello "+user.getFirstName()+". What would you like to do?\n1. Display Roadmap\n2. Find Class");
        int choice = scanner.nextInt();

    }

    

    public int RoadmapAdvisorOptions(User user) {
        System.out.println("Hello "+user.getFirstName()+". What would you like to do?\n1. View Student\n2. Add note\n");
        scanner.next();
        int choice = scanner.nextInt();
        return choice;
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