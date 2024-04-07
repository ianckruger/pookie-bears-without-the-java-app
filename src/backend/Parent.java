package backend;

import java.util.ArrayList;
import java.util.UUID;

public class Parent extends User {
    private User child;
    private ArrayList<String> children;
    private ArrayList<Student> childs;

 
    public Parent(String userName, String firstName, String lastName, String password, String userType) {
        super(userName, firstName, lastName, password, userType);
        this.child = null;
        this.children = new ArrayList<String>();
    }

    public Parent(String userName, String firstName, String lastName, String password, String userType, ArrayList<String> children, User child) {
        super(userName, firstName, lastName, password, userType);
        this.child = child;
        this.children = children;

    }

    public Parent(String username, UUID userID, String firstName, String lastName, String password, String userType, ArrayList<String> children) {
        super(userID, username, firstName, lastName, password, userType);
        this.children = children;

    }

    public User getChild() {
        return child;
    };

    public ArrayList<String> getChildren() {
        return children;
    };

    public ArrayList<Student> getChilds() {
        return childs;
    };
    
}