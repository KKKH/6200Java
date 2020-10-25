package week3_DroneController;

//designed by Jiawei Zhang
//NUID:001531280

import java.util.Scanner;

public class DroneTest {
	Drone mavic1= new Drone();
	Drone mavic2= new Drone();
	Drone mavic3= new Drone();
	Drone mavic4= new Drone();
	Drone mavic5= new Drone();
	Drone[] droneArray=new Drone[5];
	
	public DroneTest() {
		System.out.println("==============================");
		System.out.println("Drone constructor called");
		/*
		 * Name, Id, X_axis, Y_axis
		 * Heading, Speed,
		 * Load_usage, Load_capacity, Batt_usage, Batt_capacity,
		 */
		mavic1 = new Drone("Mavic1", 1, 0.0, 0.0, 
				0.0, 1.0,
				0.0, 10.0, 10.0, 100.0 );
		mavic2 = new Drone("Mavic2", 2, 1.0, 1.0, 
				45.0, 2.0,
				2.0, 10.0, 20.0, 100.0);
		mavic3 = new Drone("Mavic3", 3, -1.0, 1.0, 
				-45.0, 3.0,
				4.0, 10.0, 30.0, 100.0 );
		mavic4 = new Drone("Mavic4", 4, -1.0, -1.0, 
				135.0, 4.0,
				6.0, 10.0, 40.0, 100.0 );
		mavic5 = new Drone("Mavic5", 5, 1.0, -1.0, 
				-135.0, 5.0,
				8.0, 10.0, 50.0, 100.0 );
		droneArray[0]=mavic1;
		droneArray[1]=mavic2;
		droneArray[2]=mavic3;
		droneArray[3]=mavic4;
		droneArray[4]=mavic5;
		System.out.println("End of Drone constructor");
		System.out.println("==============================");
	}
	
	public void default_arrangement() {
		System.out.println(mavic1);
		System.out.println(mavic2);
		System.out.println(mavic3);
		System.out.println(mavic4);
		System.out.println(mavic5);
		System.out.println("All drones have arranged.");
	}
	
	public void run(DroneTest droneTest) {
		int time=0; //unit time
		boolean a=true, b=true, c=true, d=true, e=true;//the flag to detect whether all drones arrives at destination
		while(true) {
			System.out.println("===============================");
			System.out.println("Time: "+time);
			droneTest.mavic1.update();
			droneTest.mavic2.update();
			droneTest.mavic3.update();
			droneTest.mavic4.update();
			droneTest.mavic5.update();
			if(droneTest.mavic1.Batt_usage>0) {
				droneTest.mavic1.moveToDestination(droneTest.mavic1.X_axis, droneTest.mavic1.Y_axis, droneTest.mavic1.Heading, droneTest.mavic1.Speed, droneTest.mavic1.Load_usage, droneTest.mavic1.Batt_usage);	
			}
			if(droneTest.mavic1.Batt_usage<0||droneTest.mavic1.Batt_usage==0){
				droneTest.mavic1.Batt_usage=0;
				a=false;			
			}
			if(droneTest.mavic2.Batt_usage>0) {
				droneTest.mavic2.moveToDestination(droneTest.mavic2.X_axis, droneTest.mavic2.Y_axis, droneTest.mavic2.Heading, droneTest.mavic2.Speed, droneTest.mavic2.Load_usage, droneTest.mavic2.Batt_usage);
			}
			if(droneTest.mavic2.Batt_usage<0||droneTest.mavic2.Batt_usage==0){
				droneTest.mavic2.Batt_usage=0;
				b=false;
			}	
			
			if(droneTest.mavic3.Batt_usage>0) {
				droneTest.mavic3.moveToDestination(droneTest.mavic3.X_axis, droneTest.mavic3.Y_axis, droneTest.mavic3.Heading, droneTest.mavic3.Speed, droneTest.mavic3.Load_usage, droneTest.mavic3.Batt_usage);
				droneTest.mavic3.Batt_usage=0;
				c=false;
			}
			if(droneTest.mavic3.Batt_usage<0||droneTest.mavic3.Batt_usage==0){
				droneTest.mavic3.Batt_usage=0;
				c=false;
			}			
			if(droneTest.mavic4.Batt_usage>0) {
				droneTest.mavic4.moveToDestination(droneTest.mavic4.X_axis, droneTest.mavic4.Y_axis, droneTest.mavic4.Heading, droneTest.mavic4.Speed, droneTest.mavic4.Load_usage, droneTest.mavic4.Batt_usage);
				droneTest.mavic4.Batt_usage=0;
				d=false;
			}
			if(droneTest.mavic4.Batt_usage<0||droneTest.mavic4.Batt_usage==0){
				droneTest.mavic4.Batt_usage=0;
				d=false;
			}
			if(droneTest.mavic5.Batt_usage>0) {
				droneTest.mavic5.moveToDestination(droneTest.mavic5.X_axis, droneTest.mavic5.Y_axis, droneTest.mavic5.Heading, droneTest.mavic5.Speed, droneTest.mavic5.Load_usage, droneTest.mavic5.Batt_usage);
				droneTest.mavic5.Batt_usage=0;
				e=false;
			}
			if(droneTest.mavic5.Batt_usage<0||droneTest.mavic5.Batt_usage==0){
				droneTest.mavic5.Batt_usage=0;
				e=false;
			}
			System.out.println("===============================");
			time++;
			if(a==false&&b==false&&c==false&&d==false&&e==false) {
				System.out.println("===============================");
				System.out.println("Time: "+time);
				droneTest.mavic1.update();
				droneTest.mavic2.update();
				droneTest.mavic3.update();
				droneTest.mavic4.update();
				droneTest.mavic5.update();
				System.out.println("===============================");
				break;
			}
		}
	}
	
	public static void main(String args[]) {	
		System.out.println("Welcome to drone controller");
		while(true) {
			System.out.println("Input 'new' to generate drones");
			Scanner input=new Scanner(System.in);
			String generate= input.next();
			if(generate.equals("new")) {
				break;
			}
			else
				System.out.println("No drones constructed.");
		}
		DroneTest droneTest=new DroneTest();
		droneTest.default_arrangement(); //drones dafault arrangement
		while(true) {
			System.out.println("Input 'moving' to get drones' moving data");
			Scanner input=new Scanner(System.in);
			String generate= input.next();
			if(generate.equals("moving")) {
				break;
			}
			else
				System.out.println("No drones in moving.");
		}
		droneTest.run(droneTest);
	}
}
