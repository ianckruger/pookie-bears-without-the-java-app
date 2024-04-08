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
                            roadmap.setRoadmap(roadmap);
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
    if (ActiveUser != null) {
        return false;
    }
    DataWriter.saveUsers();
    ActiveUser = null;
    return true;
    

}


    

    

     




}