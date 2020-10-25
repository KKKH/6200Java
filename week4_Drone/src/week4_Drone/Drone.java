package week4_Drone;

//designed by Jiawei Zhang
//NUID:001531280

import java.util.Scanner;

public class Drone {
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTaskName() {
		return TaskName;
	}

	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
	
	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}
	
	public String getObjective() {
		return Objective;
	}

	public void setObjective(String objective) {
		Objective = objective;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public double getX_axis() {
		return X_axis;
	}

	public void setX_axis(double x_axis) {
		X_axis = x_axis;
	}

	public double getY_axis() {
		return Y_axis;
	}

	public void setY_axis(double y_axis) {
		Y_axis = y_axis;
	}

	public double getTime() {
		return Time;
	}

	public void setTime(double time) {
		Time = time;
	}
	
	public double getHeading() {
		return Heading;
	}

	public void setHeading(double heading) {
		Heading = heading;
	}

	public double getSpeed() {
		return Speed;
	}

	public void setSpeed(double speed) {
		Speed = speed;
	}

	public double getLoad_capacity() {
		return Load_capacity;
	}

	public void setLoad_capacity(double load_capacity) {
		if(load_capacity>10)load_capacity=10;
		if(load_capacity<0)load_capacity=0;
		Load_capacity = load_capacity;
	}

	public double getLoad_usage() {
		return Load_usage;
	}

	public void setLoad_usage(double load_usage) {
		if(load_usage>10)load_usage=10;
		if(load_usage<0)load_usage=0;
		Load_usage = load_usage;
	}

	public double getBatt_capacity() {
		return Batt_capacity;
	}

	public void setBatt_capacity(double batt_capacity) {
		if(batt_capacity>100)batt_capacity=100;
		if(batt_capacity<0)batt_capacity=0;
		Batt_capacity = batt_capacity;
	}

	public double getBatt_usage() {
		return Batt_usage;
	}

	public void setBatt_usage(double batt_usage) {
		if(batt_usage>100)batt_usage=100;
		if(batt_usage<0)batt_usage=0;
		Batt_usage = batt_usage;
	}

	private String Name;
	private String TaskName;
	private String Date;
	private String Objective;
	private int Id;
	private static int IdCounter=1;
	private double X_axis; //current X position form (0,0), kilometer
	private double Y_axis; //current Y position form (0,0), kilometer
	private double Time;
	private double Heading;
	private double Speed; //minutes per kilometer 1 capacity	
	private double Load_capacity;
	private double Load_usage;
	private double Batt_capacity;
	private double Batt_usage;
	/*
	 * Default constructor
	 */
	public Drone() {
		Load_capacity=10.0;
		Batt_capacity=100.0;
		Heading=0;
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
				"  Task name:"+TaskName + "  Objective:"+Objective+
				"  Date:"+Date + "  Time:"+ Time+
				"  Load:" + Load_usage+ "/" + Load_capacity + 
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
