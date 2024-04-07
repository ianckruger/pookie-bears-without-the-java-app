package backend;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstant {

    public static void saveUsers() {
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserType().equalsIgnoreCase("Student")) 
                jsonUsers.add(completeStudent((Student) users.get(i)));
            else if (users.get(i).getUserType().equalsIgnoreCase("Advisor"))
                jsonUsers.add(completeAdvisor((Advisor) users.get(i)));
            else if (users.get(i).getUserType().equalsIgnoreCase("Parent"))
            jsonUsers.add(completeParent((Parent) users.get(i)));
                
        }

        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
        // Need to add other things like null objects so json works
        // Need to differentiate    
        
    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_USERNAME, user.getUserName());
        userDetails.put(USER_USER_ID, user.getUserUUID().toString());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_USER_TYPE, user.getUserType());

        return userDetails;
    }

    public static JSONObject completeStudent(Student user) {
        JSONObject userDetails = getUserJSON(user);
        userDetails.put(USER_GPA, user.getGPA());
        userDetails.put(USER_DEGREE_CREDITS, user.getDegreeCredits());
        userDetails.put(USER_EARNED_CREDIT_HOURS, user.getEarnedCreditHours());
        userDetails.put(USER_TOTAL_CURRENT_CREDITS, user.getTotalCurrentCredits());
        userDetails.put(USER_YEAR, user.getYear());
        userDetails.put(USER_CURRENT_MAJOR, user.getCurrentMajor());
        JSONArray parentsArray = new JSONArray();
        JSONArray advisorsArray = new JSONArray();
        for (String parent : user.getParents()) {
            parentsArray.add(parent);
        }
        for (String advisor : user.getAdvisors()) {
            advisorsArray.add(advisor);
        }
        userDetails.put(USER_PARENTS, advisorsArray);
        userDetails.put(USER_ADVISORS, parentsArray);
        return userDetails;
    }

    public static JSONObject completeAdvisor(Advisor user) {
        JSONObject userDetails = getUserJSON(user);
        JSONArray studentArray = new JSONArray();
        for (String parent : user.getStudents()) {
            studentArray.add(parent);
        }
        userDetails.put(USER_STUDENTS, studentArray);
        return userDetails;
    }

    public static JSONObject completeParent(Parent user) {
        JSONObject userDetails = getUserJSON(user);
        JSONArray childArray = new JSONArray();
        for (String parent : user.getChildren()) {
            childArray.add(parent);
        }
        userDetails.put(USER_CHILDREN, childArray);
        return userDetails;
    }

/* 
    public static void saveRoadMaps (ArrayList<Roadmap> roadmaps) {
        JSONArray jsonRoadmaps = new JSONArray();

        for (int i = 0; i < roadmaps.size(); i++) {
            jsonRoadmaps.add(getRoadmapJSON(roadmaps.get(i)));
        }

        try (FileWriter file = new FileWriter(ROADMAP_FILE_NAME)) {
            file.write(jsonRoadmaps.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static JSONObject getRoadmapJSON(Roadmap roadmap) {
        JSONObject roadmapDetails = new JSONObject();

        roadmapDetails.put(ROADMAP_ID, roadmap.getRoadmapID().toString());
        roadmapDetails.put(ROADMAP_MAJOR, roadmap.getMajor());

        return roadmapDetails;
        
    }
*/

}