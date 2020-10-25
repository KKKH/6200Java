package week3_DroneController;

//designed by Jiawei Zhang
//NUID:001531280

import java.util.Scanner;

public class Drone {
	String Name;
	int Id;
	double X_axis; //current X position form (0,0), kilometer
	double Y_axis; //current Y position form (0,0), kilometer
	double Heading;
	double Speed; //minutes per kilometer 1 capacity
	
	double Load_capacity;
	double Load_usage;
	double Batt_capacity;
	double Batt_usage;
	/*
	 * Default constructor
	 */
	public Drone() {
		Load_capacity=10.0;
		Batt_capacity=100.0;
		Heading=0;
	}
	
	/*
	 * Drone constructor
	 * Name, name of drone
	 * Id, id of drone
	 * X_axis, current X position form (0,0), kilometer
	 * Y_axis, current Y position form (0,0), kilometer
	 * Heading, drone heading
	 * Speed, current speed of drone
	 * Load_usage, current load of drone
	 * Load_capacity, load capacity of drone
	 * Batt_usage, current battery of drone
	 * Batt_capacity, battery capacity of drone
	 */
	public Drone(String Name, int Id, double X_axis, double Y_axis, double Heading, double Speed, double Load_usage,  double Load_capacity, double Batt_usage, double Batt_capacity) {
		System.out.println("Drone custom constructor" +Name);
		
		this.Name=Name;
		this.Id=Id;
		this.X_axis=X_axis;
		this.Y_axis=Y_axis;
		this.Heading=Heading;
		this.Speed=Speed;
		this.Load_usage=Load_usage;
		this.Load_capacity=Load_capacity;
		this.Batt_usage=Batt_usage;
		this.Batt_capacity=Batt_capacity;
	}
	
	//move the done to destination in unit time
	public void moveToDestination(double X_axis, double Y_axis, double Heading, double Speed, double Load_usage, double batt_usage) {
		if(Load_usage==0) {
			this.X_axis= Speed*Math.cos(Math.toRadians(Heading))+X_axis; 
			this.Y_axis= Speed*Math.sin(Math.toRadians(Heading))+Y_axis;
		}
		else {
			this.X_axis= Speed*Math.cos(Math.toRadians(Heading))*(0.5*Load_usage)+X_axis; 
			this.Y_axis= Speed*Math.sin(Math.toRadians(Heading))*(0.5*Load_usage)+Y_axis;
		}
		//drone move in each direction in speed and heading and affected by 0.5*Load_usage in a unit time;
		this.Batt_usage= batt_usage-Speed-0.1*Load_usage;
		//drone's battery consumption decided by Speed and affected by 0.1*Load_usage in a unit time;
	}
	
	//output information of dones
	public void update() {
		System.out.println("Name:"+ Name + "  ID:" + Id +  
				"  Heading:" + Heading + "  Speed:" + Speed + 
				"  Load:" + Load_usage + "/" + Load_capacity + 
				"  Battery:" + String.format("%.2f", Batt_usage) + "/" + Batt_capacity +
				"  Location:(" + String.format("%.2f", X_axis) + "," + String.format("%.2f", Y_axis) + ")" 
				);
	}
	
	public String toString() {
		return "Name:"+ Name + "  ID:" + Id + "  Location:(" + X_axis + "," + Y_axis+")" + 
				"  Heading:" + Heading + "  Speed:" + Speed + 
				"  Load:" + Load_usage + "/" + Load_capacity + 
				"  Battery:" + Batt_usage + "/" + Batt_capacity;
	}
}
