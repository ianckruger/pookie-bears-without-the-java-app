package backend;
import java.util.ArrayList;
import java.util.Scanner;


public class UserList {

    private static UserList users;
    private ArrayList<User> userList;
    private User ActiveUser;
    private User advisor;

    private UserList() {
        this.ActiveUser = null;
        this.userList = new ArrayList<User>();                
         
    }

    public static UserList getInstance() {
        if(users == null) {
            users = new UserList();
            users.userList = DataLoader.readUsers();
        }
        return users;
    }
    
    public ArrayList<User> getUsers() {
        return userList;
    }

    public User getActive() {
        return this.ActiveUser;
    }

    public void setActiveUser(User user) {
        this.ActiveUser = user;
    }

    public void addUser(User user) {
        userList.add(user);
    }
    public void setAdvisor(User user) {
        this.advisor = user;
    }

    public User getAdvisor() {
        return this.advisor;
    }

    // MOVING THE ADD IN

    public void SelectStudent(String id) {
        for (User student : userList) {
            if (student.getUserUUID().toString().equals(id) && student.getUserType().equalsIgnoreCase("student")) {
                users.setActiveUser(student);
                CourseList courseList = CourseList.getInstance();
                Roadmap roadmap = Roadmap.getInstance();
            }
        }
    }

    public void printStudentProgress() {
        Student student = (Student) ActiveUser;
 
        if(student != null) {
            String major = student.getCurrentMajor();
            System.out.println(major);
            if (major != null ) {
                Roadmap roadmap = Roadmap.getInstance();
               System.out.println(roadmap.displayClasses());
            }
        }
         
    }

    

    public void student(Scanner scanner) {
        UserList users = UserList.getInstance();
        Student student = (Student)users.getActive();
        System.out.println("Hello "+student.getFirstName()+". What would you like to do?\n1. Display Roadmap\n2. Find Class");
        int choice = scanner.nextInt();

    }

    


    public void addAdvisee(String advisorUsername, String studentId) {
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
                    }
                }
            }
        }
    // Return false if advisor or student not found, or student is not of type "student"
    }
    public boolean login(String userName, String password, Scanner scanner) {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
            if (userList != null) {
                for (User user : userList) {
                    if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                        // If user is a student
                        if (user.getUserType().equalsIgnoreCase("student")) {
                            Student student = (Student) user;
                            users.setActiveUser(student);
                            CourseList courseList = CourseList.getInstance();
                            Roadmap roadmap = Roadmap.getInstance();
                            roadmap.setRoadmap(roadmap);
                            
                            return true;
                        } else if (user.getUserType().equalsIgnoreCase("advisor")) {
                            users.setAdvisor(user);
                            return true;
                        }
                        
                    }
                }
            }
        return false; // Return false if no user is found or incorrect credentials

    }

    public boolean register(String userName, String firstName, String lastName, String password, String userType) {
        if ( userType.equalsIgnoreCase("student")) {
           Student student = new Student(userName, firstName, lastName, password, userType);
           addUser(student);
           DataWriter.saveUsers();
           return true;
       } else if(userType.equalsIgnoreCase("parent")) {
           Parent parent = new Parent(userName, firstName, lastName, password, userType);
           addUser(parent);
           DataWriter.saveUsers();
           return true;
       } else if(userType.equalsIgnoreCase("advisor")) {
           Advisor advisor = new Advisor(userName, firstName, lastName, password, userType);
           addUser(advisor);
           DataWriter.saveUsers();
           return true;
       }


       return false;

   }

   public boolean logout() {
    if (ActiveUser == null && advisor == null) {
        return false;
    }
    DataWriter.saveUsers();
    ActiveUser = null;
    return true;
    }



    public void addNote(String note) {
        Student user = (Student)this.ActiveUser;
        user.getNotes().add(note);
    }



    

    

     




}