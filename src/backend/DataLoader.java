package backend;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstant {

        public static ArrayList<User> readUsers() {
            UserList users = UserList.getInstance();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray) parser.parse(reader);


            for(int i=0; i < userJSON.size(); i++) {
                JSONObject userObject = (JSONObject)userJSON.get(i);
                String userType = (String)userObject.get(USER_USER_TYPE);

                if (userType.equalsIgnoreCase("Student")) {
                    User student = createStudent(userObject, userType);
                    users.addUser(student);
                } else if (userType.equalsIgnoreCase("Advisor")){
                    User advisor = createAdvisor(userObject, userType);
                    users.addUser(advisor);
                } else if (userType.equalsIgnoreCase("Parent")) {
                    User parent = createParent(userObject, userType);
                    users.addUser(parent);
                } else {
                    System.out.println("Gyatt");
                }
            }

            for(User user : users.getUsers()) {

                if(user.getUserType().equalsIgnoreCase("Student")) {
                    Student student = (Student) user;

                    if(!student.getAdvisors().isEmpty()) {
                        for(int i=0; i < student.getAdvisors().size(); i++) {
                            String uuid = student.getAdvisors().get(i);

                            for(User user1 : users.getUsers()) {
                                if(user1.getUserUUID().toString().equals(uuid)) {
                                    Advisor advisor = (Advisor) user1;
                                    student.getAdvisor().add(advisor);
                                }
                            }
                        }
                     }

                     if(!student.getParents().isEmpty()) {
                        for(int i=0; i < student.getParents().size(); i++) {
                            String uuid = student.getParents().get(i);

                            for(User user1 : users.getUsers()) {
                                if(user1.getUserUUID().toString().equals(uuid)) {
                                    Parent parent = (Parent) user1;
                                    student.getParent().add(parent);
                                }
                            }
                        }
                     }
                }

                if(user.getUserType().equalsIgnoreCase("Advisor")) {
                    Advisor advisor = (Advisor) user;
                    
                    if(!advisor.getStudents().isEmpty()) {
                        for(int i=0; i < advisor.getStudents().size(); i++) {
                            String uuid = advisor.getStudents().get(i);

                            for(User user1 : users.getUsers()) {
                                if(user1.getUserUUID().toString().equals(uuid)) {
                                    Student student = (Student) user1;
                                    advisor.getStudent().add(student);
                                }
                            }
                        }
                     }

                }

                if(user.getUserType().equalsIgnoreCase("Parent")) {
                    Parent parent = (Parent) user;
                    
                    if(!parent.getChildren().isEmpty()) {
                        for(int i=0; i < parent.getChildren().size(); i++) {
                            String uuid = parent.getChildren().get(i);

                            for(User user1 : users.getUsers()) {
                                if(user1.getUserUUID().toString().equals(uuid)) {
                                    Student student = (Student) user1;
                                    parent.getChilds().add(student);
                                }
                            }
                        }
                     }

                }

            }

            

            return users.getUsers();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public static User createStudent(JSONObject userObject,String userType) {
        String userName = (String)userObject.get(USER_USERNAME);
        String firstName = (String)userObject.get(USER_FIRST_NAME);
        String lastName = (String)userObject.get(USER_LAST_NAME);
        String password = (String)userObject.get(USER_PASSWORD);
        String tempuserID = (String)userObject.get(USER_USER_ID);
        UUID userID = UUID.fromString(tempuserID);
        double gpa = (double)userObject.get(USER_GPA);
        String year = (String)userObject.get(USER_YEAR);
        String currentMajor = (String)userObject.get(USER_CURRENT_MAJOR);
        int earnedCreditHours = ((Number)userObject.get(USER_EARNED_CREDIT_HOURS)).intValue();
        int totalCurrentCredits = ((Number)userObject.get(USER_TOTAL_CURRENT_CREDITS)).intValue();
        int degreeCredits = ((Number)userObject.get(USER_DEGREE_CREDITS)).intValue();
        JSONArray Jparents = (JSONArray)userObject.get(USER_PARENTS); // might need to modify this
        JSONArray Jadvisors = (JSONArray)userObject.get(USER_ADVISORS);
        JSONArray Jnotes = (JSONArray)userObject.get(USER_NOTES);

        ArrayList<String> notes = new ArrayList<>();
        if(!notes.isEmpty()) {
            for (int i = 0; i < Jnotes.size(); i++) {
                String addThis = (String)Jnotes.get(i);
                notes.add(addThis);
            }

        }
        

        ArrayList<String> parents = new ArrayList<>();
        for (int i = 0; i < Jparents.size(); i++) {
            String addThis = (String)Jparents.get(i);
            parents.add(addThis);
        }
        ArrayList<String> advisors = new ArrayList<>();
        for (int i = 0; i < Jadvisors.size(); i++) {
            String addThis = (String)Jadvisors.get(i);
            advisors.add(addThis);
        }
        // the JSONArray objects currently store String IDS for each user
        // To properly add arrays of users we would need to search each user for their ID, and see if they match.
        // We are passing in empty arrays right now to ensure we can create a scenario


        User user = new Student(userName, userID, firstName, lastName, password, userType, gpa, year, currentMajor, earnedCreditHours, totalCurrentCredits, degreeCredits, parents, advisors, notes);
        return user;
    }

    public static User createAdvisor(JSONObject userObject, String userType) {
        String userName = (String)userObject.get(USER_USERNAME);
        String firstName = (String)userObject.get(USER_FIRST_NAME);
        String lastName = (String)userObject.get(USER_LAST_NAME);
        String password = (String)userObject.get(USER_PASSWORD);
        String tempuserID = (String)userObject.get(USER_USER_ID);
        UUID userID = UUID.fromString(tempuserID);
        JSONArray jstudents = (JSONArray)userObject.get(USER_STUDENTS);

        ArrayList<String> students = new ArrayList<>();
        for (int i = 0; i < jstudents.size(); i++) {
            String addThis = (String)jstudents.get(i);
            students.add(addThis);
        }



        
        User user = new Advisor(userName, userID, firstName, lastName, password, userType, students);
        return user;
    }

    public static User createParent(JSONObject userObject, String userType) {
        String userName = (String)userObject.get(USER_USERNAME);
        String firstName = (String)userObject.get(USER_FIRST_NAME);
        String lastName = (String)userObject.get(USER_LAST_NAME);
        String password = (String)userObject.get(USER_PASSWORD);
        String tempuserID = (String)userObject.get(USER_USER_ID);
        UUID userID = UUID.fromString(tempuserID);
        JSONArray jchildren = (JSONArray)userObject.get(USER_CHILDREN);

        ArrayList<String> children = new ArrayList<>();
        for (int i = 0; i < jchildren.size(); i++) {
            String addThis = (String)jchildren.get(i);
            children.add(addThis);
        }

        User user = new Parent(userName, userID, firstName, lastName, password, userType, children);
        return user;
    }






    public static ArrayList<Class> readCourses() {
        CourseList courses = CourseList.getInstance();
        UserList users = UserList.getInstance();
        
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            FileReader STCreader = new FileReader(STUDENT_COURSE_FILE_NAME);

            User user = users.getActive();
            String userID = user.getUserUUID().toString();
            
            JSONParser parser = new JSONParser();

            JSONArray courseJSON = (JSONArray) parser.parse(reader);
            JSONArray courseAndStudentJSON = (JSONArray) parser.parse(STCreader);

            for(int i=0; i < courseJSON.size(); i++) {
                JSONObject courseObject = (JSONObject)courseJSON.get(i);
                // find some way to get the object based on the user id thats passed in and then this current course ID

                String courseSubjectCode = (String)courseObject.get(COURSE_SUBJECT_CODE);
                String courseNumber = (String)courseObject.get(COURSE_NUMBER);
                String courseTitle = (String)courseObject.get(COURSE_TITLE);
                String tempID = (String)courseObject.get(COURSE_ID);
                UUID courseID = UUID.fromString(tempID);
                int credits = ((Number)courseObject.get(COURSE_CREDITS)).intValue();
                String applicationArea = (String)courseObject.get(COURSE_APPLICATION_AREA);
                String description = (String)courseObject.get(COURSE_DESCRIPTION);

                // Have to initialize them outside if statement or else they cant be 
                // passed through and created in the constructor
                String yearTaken = "Not taken";
                boolean transferred = false;
                boolean inProgress = false;
                boolean completed = false;
                double grade = 0.0;

                
                for (int j=0; j < courseAndStudentJSON.size(); j++) {    
                    JSONObject courseAndStudentObject = (JSONObject)courseAndStudentJSON.get(j);
                    String courseStudentID = (String)courseAndStudentObject.get(STUDENT_COURSE_STUDENT_ID);
                    String courseMatchID = (String)courseAndStudentObject.get(STUDENT_COURSE_ID);
                    if(userID.equals(courseStudentID)&& tempID.equals(courseMatchID)) {
                        yearTaken = (String)courseAndStudentObject.get(STUDENT_COURSE_SEMESTER_TAKEN);
                        transferred = (Boolean)courseAndStudentObject.get(STUDENT_COURSE_TRANSFERRED);
                        inProgress = (Boolean)courseAndStudentObject.get(STUDENT_COURSE_IN_PROGRESS);
                        completed = (Boolean)courseAndStudentObject.get(STUDENT_COURSE_COMPLETED);
                        grade = ((Number)courseAndStudentObject.get(STUDENT_COURSE_GRADE)).doubleValue();
                        break;
                    }
                }

                

                JSONArray prereqs = (JSONArray)courseObject.get(COURSE_PREREQ);

                ArrayList<String> actualPrereqs = new ArrayList<>();
                for (int j = 0; j < prereqs.size(); j++) {
                    String addThis = (String)prereqs.get(j);
                    actualPrereqs.add(addThis);
                }

                Class course = new Class(courseSubjectCode, courseNumber, courseTitle, courseID, credits, applicationArea, actualPrereqs, description, yearTaken, completed, inProgress, transferred, grade);
                courses.addCourse(course);

                
                // AHHAHAHAGAGAHAG I DONT KNOW WHERE TO IMPLEMENT THE STUDENT INFORMATION FOR COURSE SPECIFIC THINGS
                // maybe since user will be called first before everything like classes and roadmap, we can load every class
                // specific to the user code?

                // ok so we call the course and roadmap information after the user logs in
                // 


            }

            // implement prereq retriever
            for(Class course : courses.getCourses()) {
                if (!course.getPrereqIDs().isEmpty()){
                    for ( String prereq : course.getPrereqIDs()) {
                        for (Class prereqCourse : courses.getCourses() ) {
                            if (prereqCourse.getCourseID().toString().equals(prereq)) {
                                course.getPrereqs().add(prereqCourse);
                                break;
                            }
                        }
                    }  
                }
            }
            return courses.getCourses();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Roadmap readRoadmap() {
        // initialize empty roadmap
        UserList users = UserList.getInstance();
        Student user = (Student) users.getActive();
        Roadmap roadmap = new Roadmap(user.getCurrentMajor());
        CourseList courses = CourseList.getInstance();
        try {
            FileReader reader1 = new FileReader(ROADMAP_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray roadmapJSON = (JSONArray) parser.parse(reader1);
            

            for(int i=0; i<roadmapJSON.size(); i++) {
                JSONObject roadmapObject = (JSONObject)roadmapJSON.get(i);
                String roadmapID = (String)roadmapObject.get(ROADMAP_ID);
                String major = (String)roadmapObject.get(ROADMAP_MAJOR);
                
                

                if(major.equalsIgnoreCase("cis")) {
                    System.out.println("Loading CIS");
                    CisState state = new CisState(roadmap);
                    // default state
                    JSONArray majorClasses = (JSONArray)roadmapObject.get(ROADMAP_MAJOR_CLASSES);
                   
                    if(majorClasses.size() != 0) {
                        for (int j = 0; j < majorClasses.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (majorClasses.get(j).equals(course.getCourseID().toString())) {
                                    state.getMajorClasses().add(course);
                                }
                            }
                        }
                    }
                    JSONArray carolinaCore = (JSONArray)roadmapObject.get(ROADMAP_CAROLINA_CORE);
                    if(carolinaCore.size()!= 0) {
                        for (int j = 0; j < carolinaCore.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (carolinaCore.get(j).equals(course.getCourseID().toString())) {
                                    state.getCarolinaCore().add(course);
                                }
                            }
                        }
                    }
                    JSONArray electives = (JSONArray)roadmapObject.get(ROADMAP_ELECTIVES);
                    if(electives.size()!= 0) {
                        for (int j = 0; j < electives.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (electives.get(j).equals(course.getCourseID().toString())) {
                                    state.getElectives().add(course);
                                }
                            }
                        }
                    }
                    JSONArray libArts = (JSONArray)roadmapObject.get(ROADMAP_LIBERAL_ARTS_ELECTIVES);
                    if(libArts.size()!= 0) {
                        for (int j = 0; j < libArts.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (libArts.get(j).equals(course.getCourseID().toString())) {
                                    state.getLiberalArtsElectives().add(course);
                                }
                            }
                        }
                    }
                    JSONArray foundational = (JSONArray)roadmapObject.get(ROADMAP_FOUNDATIONAL_COURSES);
                    if(foundational.size()!= 0) {
                        for (int j = 0; j < foundational.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (foundational.get(j).equals(course.getCourseID().toString())) {
                                    state.getFoundationalCourses().add(course);
                                }
                            }
                        }
                    }
                    JSONArray lowerDivisonComputing = (JSONArray)roadmapObject.get(ROADMAP_LOWER_DIVISION_COMPUTING);
                    if(lowerDivisonComputing.size()!= 0) {
                        for (int j = 0; j < lowerDivisonComputing.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (lowerDivisonComputing.get(j).equals(course.getCourseID().toString())) {
                                    state.getLowerDivisionComputing().add(course);
                                }
                            }
                        }
                    }
                    JSONArray bussinessFoundation = (JSONArray)roadmapObject.get(ROADMAP_BUSINESS_INFORMATION_MANAGEMENT);
                    if(bussinessFoundation.size()!= 0) {
                        for (int j = 0; j < bussinessFoundation.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (bussinessFoundation.get(j).equals(course.getCourseID().toString())) {
                                    state.getBusinessInformationManagement().add(course);
                                }
                            }
                        }
                    }
                    roadmap.setCisState(state);


                } else if (major.equalsIgnoreCase("ce")) {
                    System.out.println("Loading CE");
                    CeState state = new CeState(roadmap);
                    JSONArray majorClasses = (JSONArray)roadmapObject.get(ROADMAP_MAJOR_CLASSES);
                    if(majorClasses.size()!= 0) {
                        for (int j = 0; j < majorClasses.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (majorClasses.get(j).equals(course.getCourseID().toString())) {
                                    state.getMajorClasses().add(course);
                                }
                            }
                        }
                    }
                    JSONArray carolinaCore = (JSONArray)roadmapObject.get(ROADMAP_CAROLINA_CORE);
                    if(carolinaCore.size()!= 0) {
                        for (int j = 0; j < carolinaCore.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (carolinaCore.get(j).equals(course.getCourseID().toString())) {
                                    state.getCarolinaCore().add(course);
                                }
                            }
                        }
                    }
                    JSONArray electives = (JSONArray)roadmapObject.get(ROADMAP_ELECTIVES);
                    if(electives.size()!= 0) {
                        for (int j = 0; j < electives.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (electives.get(j).equals(course.getCourseID().toString())) {
                                    state.getElectives().add(course);
                                }
                            }
                        }
                    }
                    JSONArray libArts = (JSONArray)roadmapObject.get(ROADMAP_LIBERAL_ARTS_ELECTIVES);
                    if(libArts.size()!= 0) {
                        for (int j = 0; j < libArts.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (libArts.get(j).equals(course.getCourseID().toString())) {
                                    state.getLiberalArtsElectives().add(course);
                                }
                            }
                        }
                    }
                    JSONArray foundational = (JSONArray)roadmapObject.get(ROADMAP_FOUNDATIONAL_COURSES);
                    if(foundational.size()!= 0) {
                        for (int j = 0; j < foundational.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (foundational.get(j).equals(course.getCourseID().toString())) {
                                    state.getFoundationalCourses().add(course);
                                }
                            }
                        }
                    }
                    JSONArray lowerDivisonComputing = (JSONArray)roadmapObject.get(ROADMAP_LOWER_DIVISION_COMPUTING);
                    if(lowerDivisonComputing.size()!= 0) {
                        for (int j = 0; j < lowerDivisonComputing.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (lowerDivisonComputing.get(j).equals(course.getCourseID().toString())) {
                                    state.getLowerDivisionComputing().add(course);
                                }
                            }
                        }
                    }
                    JSONArray eletricEng = (JSONArray)roadmapObject.get(ROADMAP_ELECTRICAL_ENGINEERING);
                    if(eletricEng.size()!= 0) {
                        for (int j = 0; j < eletricEng.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (eletricEng.get(j).equals(course.getCourseID().toString())) {
                                    state.getElectricalEngineering().add(course);
                                }
                            }
                        }
                    }
                    roadmap.setCeState(state);



                } else if (major.equalsIgnoreCase("csce")){
                    System.out.println("Loading CSCE");
                    CsceState state = new CsceState(roadmap);

                    JSONArray majorClasses = (JSONArray)roadmapObject.get(ROADMAP_MAJOR_CLASSES);
                    if(majorClasses.size()!= 0) {
                        for (int j = 0; j < majorClasses.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (majorClasses.get(j).equals(course.getCourseID().toString())) {
                                    state.getMajorClasses().add(course);
                                }
                            }
                        }
                    }   
                    JSONArray carolinaCore = (JSONArray)roadmapObject.get(ROADMAP_CAROLINA_CORE);
                    if(carolinaCore.size()!= 0) {
                        for (int j = 0; j < carolinaCore.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (carolinaCore.get(j).equals(course.getCourseID().toString())) {
                                    state.getCarolinaCore().add(course);
                                }
                            }
                        }
                    }
                    JSONArray electives = (JSONArray)roadmapObject.get(ROADMAP_ELECTIVES);
                    if(electives.size()!= 0) {
                        for (int j = 0; j < electives.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (electives.get(j).equals(course.getCourseID().toString())) {
                                    state.getElectives().add(course);
                                }
                            }
                        }
                    }
                    JSONArray libArts = (JSONArray)roadmapObject.get(ROADMAP_LIBERAL_ARTS_ELECTIVES);
                    if(libArts.size()!= 0) {
                        for (int j = 0; j < libArts.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (libArts.get(j).equals(course.getCourseID().toString())) {
                                    state.getLiberalArtsElectives().add(course);
                                }
                            }
                        }
                    }
                    JSONArray foundational = (JSONArray)roadmapObject.get(ROADMAP_FOUNDATIONAL_COURSES);
                    if(foundational.size()!= 0) {
                        for (int j = 0; j < foundational.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (foundational.get(j).equals(course.getCourseID().toString())) {
                                    state.getFoundationalCourses().add(course);
                                }
                            }
                        }
                    }
                    JSONArray lowerDivisonComputing = (JSONArray)roadmapObject.get(ROADMAP_LOWER_DIVISION_COMPUTING);
                    if(lowerDivisonComputing.size()!= 0) {
                        for (int j = 0; j < lowerDivisonComputing.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (lowerDivisonComputing.get(j).equals(course.getCourseID().toString())) {
                                    state.getLowerDivisionComputing().add(course);
                                }
                            }
                        }
                    }
                    JSONArray labScience = (JSONArray)roadmapObject.get(ROADMAP_LAB_SCIENCE_ELECTIVE);
                    if(labScience.size()!= 0) {
                        for (int j = 0; j < labScience.size(); j++) {
                            for(Class course : courses.getCourses() ) {
                                if (labScience.get(j).equals(course.getCourseID().toString())) {
                                    state.getLabScienceElective().add(course);
                                }
                            }
                        }
                    }
                    roadmap.setCsState(state);

                }


        }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return roadmap;

    }

    


}



































































/* 
    // Roadmap parsing logic same as user parsing

    // THIS IS ALL GOING TO BE RECONSTRUCTED LATER PROBABLY
    public static ArrayList<RoadmapList> readRoadmaps() {
        RoadmapList roadmaps = RoadmapList.getInstance();

        try {
            FileReader reader = new FileReader(ROADMAP_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray roadmapJSON = (JSONArray) parser.parse(reader);

            for(int i=0; i < roadmapJSON.size(); i++) {
                JSONObject roadmapObject = (JSONObject)roadmapJSON.get(i);
                String major = (String)roadmapObject.get(ROADMAP_MAJOR);

                if(major == "CSCE") {
                    Roadmap csceRoadmap = createCSCERoadmap(roadmapObject, major);
                    roadmaps.addRoadmap(csceRoadmap);
                } else if(major == "CE") {
                    Roadmap ceRoadmap = createCERoadmap(roadmapObject, major);
                    roadmaps.addRoadmap(ceRoadmap);
                } else if(major == "CIS") {
                    Roadmap cisRoadmap = createCISRoadmap(roadmapObject, major);
                    roadmaps.addRoadmap(cisRoadmap);
                }
                else {
                    System.out.println("Unknown major");
                }
                
            }
            return roadmaps.getRoadmaps();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //Roadmap creation methods
    public static Roadmap createCSCERoadmap(JSONObject roadmapObject, String major) {
        UUID roadmapID = (UUID)roadmapObject.get(ROADMAP_ID);
        String majorName = (String)roadmapObject.get(ROADMAP_MAJOR);
        ArrayList<Roadmap> majorClasses = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_MAJOR_CLASSES);
        ArrayList<Roadmap> carolinaCore = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_CAROLINA_CORE);
        Object programRequirements = roadmapObject.get(ROADMAP_PROGRAM_REQUIREMENTS); // I think this is right? Fix in future.
        ArrayList<Roadmap> electives = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_ELECTIVES);

        Roadmap roadmap = new Roadmap(roadmapID, majorName, majorClasses, carolinaCore, programRequirements, electives);
        return roadmap;
    }

    public static Roadmap createCERoadmap(JSONObject roadmapObject, String major) {
        UUID roadmapID = (UUID)roadmapObject.get(ROADMAP_ID);
        String majorName = (String)roadmapObject.get(ROADMAP_MAJOR);
        ArrayList<Roadmap> majorClasses = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_MAJOR_CLASSES);
        ArrayList<Roadmap> carolinaCore = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_CAROLINA_CORE);
        Object programRequirements = roadmapObject.get(ROADMAP_PROGRAM_REQUIREMENTS); // I think this is right? Fix in future.
        ArrayList<Roadmap> electives = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_ELECTIVES);

        Roadmap roadmap = new Roadmap(roadmapID, majorName, majorClasses, carolinaCore, programRequirements, electives);
        return roadmap;
    }

    public static Roadmap createCISRoadmap(JSONObject roadmapObject, String major) {
        UUID roadmapID = (UUID)roadmapObject.get(ROADMAP_ID);
        String majorName = (String)roadmapObject.get(ROADMAP_MAJOR);
        ArrayList<Roadmap> majorClasses = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_MAJOR_CLASSES);
        ArrayList<Roadmap> carolinaCore = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_CAROLINA_CORE);
        Object programRequirements = roadmapObject.get(ROADMAP_PROGRAM_REQUIREMENTS); // I think this is right? Fix in future.
        ArrayList<Roadmap> electives = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_ELECTIVES);

        Roadmap roadmap = new Roadmap(roadmapID, majorName, majorClasses, carolinaCore, programRequirements, electives);
        return roadmap;
    }

}

*/