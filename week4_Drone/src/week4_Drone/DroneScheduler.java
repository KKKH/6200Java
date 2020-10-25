package week4_Drone;

//designed by Jiawei Zhang
//NUID:001531280

import java.util.ArrayList;
import java.util.HashMap;

public class DroneScheduler {
	private ArrayList<Drone> holdingTask=new ArrayList<>();
	private HashMap<String, Drone> taskHashMap=new HashMap<String, Drone>();
	
	public void add(Drone drone) {
		System.out.println("Drone"+drone.getId()+" added.");
		this.holdingTask.add(drone);
		this.taskHashMap.put(String.valueOf(drone.getId()), drone);
	}
	
	public void remove(Drone drone) {
		System.out.println("Drone"+drone.getId()+" removed.");
		this.holdingTask.remove(drone);
		this.taskHashMap.remove(String.valueOf(drone.getId()), drone);
	}
	
	public void checkhashmap(int key) {
		String hashkey=String.valueOf(key);
		if(taskHashMap.containsKey(hashkey)) {
			System.out.println("We found object ID: " + hashkey);
		}
	}
	
	public void printScheduler() {
		for(Drone i: this.holdingTask) {
			System.out.println("Name:"+ i.getName() + "  ID:" + i.getId() +  
					"  Heading:" + i.getHeading() + "  Speed:" + i.getSpeed() + 
					"  Task name:"+i.getTaskName() + "  Objective:"+i.getObjective()+
					"  Date:"+i.getDate() + "  Time:"+ i.getTime()+
					"  Load:" + i.getLoad_usage()+ "/" + i.getLoad_capacity() + 
					"  Battery:" + String.format("%.2f", i.getBatt_usage()) + "/" + i.getBatt_capacity() +
					"  Location:(" + String.format("%.2f", i.getX_axis()) + "," + String.format("%.2f", i.getY_axis()) + ")" 
					);
		}
	}
}

