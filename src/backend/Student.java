package backend;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;


public class Student extends User {

    private double gpa;
    private String year;
    private String currentMajor;
    private int earnedCreditHours;
    private int totalCurrentCredits;
    private int degreeCredits;
    private ArrayList<String> parent;
    private ArrayList<String> advisor;
    private ArrayList<Advisor> advisors;
    private ArrayList<Parent> parents;
    private ArrayList<String> notes;

    public Student(String userName, String firstName, String lastName, String password, String userType) {
        super(userName, firstName, lastName, password, userType);
        this.gpa = 0;
        this.year = "";
        this.currentMajor = "csce";
        this.earnedCreditHours = 0;
        this.totalCurrentCredits = 0;
        this.degreeCredits = 0;
        this.parent = new ArrayList<String>();
        this.advisor = new ArrayList<String>();
        this.advisors = new ArrayList<Advisor>();
        this.parents = new ArrayList<Parent>();
        
    }
    public Student(String userName, String firstName, String lastName, String password, String userType, double gpa, String year, String currentMajor, int earnedCreditHours, int totalCurrentCredits, int degreeCredits, ArrayList<String> parents, ArrayList<String> advisors) {
        super(userName, firstName, lastName, password, userType);
        this.gpa = gpa;
        this.year = year;
        this.currentMajor = currentMajor;
        this.earnedCreditHours = earnedCreditHours;
        this.totalCurrentCredits = totalCurrentCredits;
        this.degreeCredits = degreeCredits;
        this.parent = parents;
        this.advisor = advisors;
    }

    public Student(String username, UUID userID, String firstName, String lastName, String password, String userType, double gpa, String year, String currentMajor, int earnedCreditHours, int totalCurrentCredits, int degreeCredits, ArrayList<String> parents, ArrayList<String> advisors, ArrayList<String> notes) {
        super(userID, username, firstName, lastName, password, userType);
        this.notes = notes;
        this.gpa = gpa;
        this.year = year;
        this.currentMajor = currentMajor;
        this.earnedCreditHours = earnedCreditHours;
        this.totalCurrentCredits = totalCurrentCredits;
        this.degreeCredits = degreeCredits;
        this.parent = parents;
        this.advisor = advisors;
    }

    public double getGPA() {
        return gpa;
    }

    public int getDegreeCredits() {
        return degreeCredits;
    }

    public String getYear() {
        return year;
    }

    public String getCurrentMajor() {
        return currentMajor;
    }

    public void setCurrentMajor(String currentMajor) {
        this.currentMajor = currentMajor;

    }

    public int getEarnedCreditHours() {
        return earnedCreditHours;
    }

    public int getTotalCurrentCredits() {
        return totalCurrentCredits;
    }

    public ArrayList<String> getParents() {
        return parent;
    }

    public ArrayList<String> getAdvisors() {
        return advisor;
    }

    public ArrayList<Parent> getParent() {
        return parents;
    }

    public ArrayList<Advisor> getAdvisor() {
        return advisors;
    }

    public ArrayList<String> getNotes() {
        return this.notes;
    }

    public void setNotes (ArrayList<String> notes) {
        this.notes = notes;
    }
    
    

     
}