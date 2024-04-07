package backend;

import java.util.ArrayList;


public class RoadmapList {

    private static RoadmapList roadmaps;
    private ArrayList<Roadmap> roadmapList;
    private Roadmap activeRoadmap;

    private RoadmapList() {
        this.activeRoadmap = null;
        // roadmapList = DataLoader.readRoadmaps();
    }

    public static RoadmapList getInstance() {
        if(roadmaps == null) {
            roadmaps = new RoadmapList();
            //roadmaps.roadmapList = DataLoader.readRoadmaps();
        }
        return roadmaps;
    }

    public ArrayList<Roadmap> getRoadmaps() {
        return roadmapList;
    } 

    public void addRoadmap(Roadmap roadmap) {
        roadmapList.add(roadmap);
    }

}