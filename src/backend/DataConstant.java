package backend;
import java.lang.reflect.Array;
import java.util.UUID;

public abstract class DataConstant {

    // USERS JSON FILE
    protected static final String USER_FILE_NAME = "json/users.json";
    protected static final String USERS = "users";

    // USERS JSON KEYS students
    protected static final String USER_USERNAME = "userName";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_USER_TYPE = "userType";
    protected static final String USER_USER_ID = "userID";
    protected static final String USER_GPA = "gpa";
    protected static final String USER_YEAR = "year";
    protected static final String USER_CURRENT_MAJOR = "currentMajor";
    protected static final String USER_EARNED_CREDIT_HOURS = "earnedCreditHours";
    protected static final String USER_TOTAL_CURRENT_CREDITS = "totalCurrentCredits";
    protected static final String USER_DEGREE_CREDITS = "degreeCredits";
    protected static final String USER_PARENTS = "parents";
    protected static final String USER_ADVISORS = "advisors";
    // PARENT USERS JSON KEYS
    protected static final String USER_CHILDREN = "children";
    // ADVISOR USERS JSON KEYS
    protected static final String USER_STUDENTS = "students";
    // ROADMAP JSON FILE
    protected static final String ROADMAP_FILE_NAME = "json/roadmap.json";
    protected static final String ROADMAPS = "roadmap";

    // ROADMAP JSON KEYS
    protected static final String ROADMAP_ID = "roadmapID";
    protected static final String ROADMAP_MAJOR = "major";
    protected static final String ROADMAP_NOTES = "notes";
    protected static final String ROADMAP_MAJOR_CLASSES = "majorClasses";
    protected static final String ROADMAP_CAROLINA_CORE = "carolinaCore";
    protected static final String ROADMAP_ELECTIVES = "electives";
    protected static final String ROADMAP_LIBERAL_ARTS_ELECTIVES = "liberalArtsElectives";
    protected static final String ROADMAP_FOUNDATIONAL_COURSES = "foundationalCourses";
    protected static final String ROADMAP_LOWER_DIVISION_COMPUTING = "lowerDivisionComputing";

    // ROADMAP - CSCE
    protected static final String ROADMAP_LAB_SCIENCE_ELECTIVE = "labScienceElective";

    // ROADMAP - CIS
    protected static final String ROADMAP_BUSINESS_INFORMATION_MANAGEMENT = "bussinessInformationManagement";

    // ROADMAP - CE
    protected static final String ROADMAP_ELECTRICAL_ENGINEERING = "electricalEngineering";

    // COURSE JSON FILE
    protected static final String COURSE_FILE_NAME = "json/class.json";
    protected static final String COURSES = "class";

    // COURSE JSON KEYS
    protected static final String COURSE_SUBJECT_CODE = "courseSubjectCode";
    protected static final String COURSE_NUMBER = "courseNumber";
    protected static final String COURSE_TITLE = "courseTitle";
    protected static final String COURSE_ID = "courseID";
    protected static final String COURSE_CREDITS = "credits";
    protected static final String COURSE_APPLICATION_AREA = "applicationArea";
    protected static final String COURSE_PREREQ = "prerequisites";
    protected static final String COURSE_DESCRIPTION = "description";

    // STUDENT COURSE JSON FILE
    protected static final String STUDENT_COURSE_FILE_NAME = "json/studentCourses.json";
    protected static final String STUDENT_COURSES = "studentCourses";

    // STUDENT COURSE JSON KEYS
    protected static final String STUDENT_COURSE_STUDENT_ID = "studentID";
    protected static final String STUDENT_COURSE_ID = "courseID";
    protected static final String STUDENT_COURSE_TRANSFERRED = "transferred";
    protected static final String STUDENT_COURSE_IN_PROGRESS = "inProgress";
    protected static final String STUDENT_COURSE_COMPLETED = "completed";
    protected static final String STUDENT_COURSE_SEMESTER_TAKEN = "semesterTaken";
    protected static final String STUDENT_COURSE_GRADE = "grade";

}
