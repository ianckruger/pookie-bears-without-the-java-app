package backend;
import java.util.ArrayList;
import java.util.Scanner;


public class UserList {

    private static UserList users;
    private ArrayList<User> userList;
    private User ActiveUser;
    private User advisor;
    private Scanner scanner;

    private UserList() {
        this.ActiveUser = null;
        this.userList = new ArrayList<User>();
        this.scanner = new Scanner(System.in);
         
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

    // MOVING THE ADD IN

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
                        CourseList courseList = CourseList.getInstance();
                        Roadmap roadmap = Roadmap.getInstance();
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
        System.out.println("Hello "+student.getFirstName()+". What would you like to do?\n1. Display Roadmap\n2. Find Class");
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
     




}