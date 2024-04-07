package backend;
import java.util.ArrayList;


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


    public boolean registerStudent(String userName, String firstName, String lastName, String password, String userType, double gpa, String year, String currentMajor, int earnedCreditHours, int totalCurrentCredits, int degreeCredits, ArrayList<String> parents, ArrayList<String> advisors) {
        UserList userlist = UserList.getInstance();
        if ( userType.equals("student")) {
            Student student = new Student(userName, firstName, lastName, password, userType, gpa, year, currentMajor, earnedCreditHours, totalCurrentCredits,   degreeCredits,  parents, advisors);
            userList.add(ActiveUser);
            DataWriter.saveUsers();
            return true;
        }
        return false;
    }

    public boolean registerParent(String userName, String firstName, String lastName, String password, String userType, ArrayList<String> children, User child) {
        UserList userlist = UserList.getInstance();
        if(userType.equals("parent")) {
            Parent parent = new Parent(userName, firstName, lastName, password, userType, children, child );
            userList.add(ActiveUser);
            DataWriter.saveUsers();
            return true;
        }
        return false;
    }

    public boolean registerAdvisor(String userName, String firstName, String lastName, String password, String userType, ArrayList<String> students, User advising) {
        UserList userlist = UserList.getInstance();
        if(userType.equals("advisor")) {
            Advisor advisor = new Advisor(userName, firstName, lastName, password, userType, students, advising);
            userList.add(ActiveUser);
            DataWriter.saveUsers();
            return true;

        }
        return false;
    }

    public void setAdvisor(User user) {
        this.advisor = user;
    }

    public User getAdvisor() {
        return this.advisor;
    }

     




}