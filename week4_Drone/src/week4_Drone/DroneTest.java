package week4_Drone;

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
		 * Use setter to set parameters for drones
		 */
		mavic1.setName("Mavic1");
		mavic1.setX_axis(0.0);
		mavic1.setY_axis(0.0);
		mavic1.setHeading(0.0);
		mavic1.setSpeed(1.0);
		mavic1.setLoad_usage(0.0);
		mavic1.setLoad_capacity(10.0);
		mavic1.setBatt_usage(10.0);
		mavic1.setBatt_capacity(100.0);
		
		mavic2.setName("Mavic2");
		mavic2.setX_axis(1.0);
		mavic2.setY_axis(1.0);
		mavic2.setHeading(45.0);
		mavic2.setSpeed(2.0);
		mavic2.setLoad_usage(2.0);
		mavic2.setLoad_capacity(10.0);
		mavic2.setBatt_usage(20.0);
		mavic2.setBatt_capacity(100.0);

		mavic3.setName("Mavic3");
		mavic3.setX_axis(-1.0);
		mavic3.setY_axis(-1.0);
		mavic3.setHeading(-45.0);
		mavic3.setSpeed(3.0);
		mavic3.setLoad_usage(4.0);
		mavic3.setLoad_capacity(10.0);
		mavic3.setBatt_usage(30.0);
		mavic3.setBatt_capacity(100.0);
		
		mavic4.setName("Mavic4");
		mavic4.setX_axis(-1.0);
		mavic4.setY_axis(-1.0);
		mavic4.setHeading(135.0);
		mavic4.setSpeed(4.0);
		mavic4.setLoad_usage(6.0);
		mavic4.setLoad_capacity(10.0);
		mavic4.setBatt_usage(40.0);
		mavic4.setBatt_capacity(100.0);
		
		mavic5.setName("Mavic5");
		mavic5.setX_axis(1.0);
		mavic5.setY_axis(-1.0);
		mavic5.setHeading(-135.0);
		mavic5.setSpeed(5.0);
		mavic5.setLoad_usage(8.0);
		mavic5.setLoad_capacity(10.0);
		mavic5.setBatt_usage(50.0);
		mavic5.setBatt_capacity(100.0);
		
		droneArray[0]=mavic1;
		droneArray[1]=mavic2;
		droneArray[2]=mavic3;
		droneArray[3]=mavic4;
		droneArray[4]=mavic5;
		System.out.println("End of Drone constructor");
		System.out.println("==============================");
	}
	
	public static void run() {
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
		DroneTask droneTask=new DroneTask();
		droneTask.DronesSet(); //from DroneTask.java		
		DroneScheduler droneScheduler=new DroneScheduler();
		
		System.out.println("Add drones.");
		droneScheduler.add(droneTask.mavic1);
		droneScheduler.add(droneTask.mavic2);
		droneScheduler.add(droneTask.mavic3);
		droneScheduler.add(droneTask.mavic4);
		droneScheduler.add(droneTask.mavic5);
		droneScheduler.printScheduler();
		System.out.println("==============================");
		
		System.out.println("Remove drones.");
		droneScheduler.remove(droneTask.mavic2);
		droneScheduler.remove(droneTask.mavic4);
		droneScheduler.printScheduler();
		System.out.println("==============================");

		droneScheduler.checkhashmap(1);
		System.out.println("==============================");

		

		int time=0; //unit time
		boolean a=true, b=true, c=true, d=true, e=true;//the flag to detect whether all drones arrives at destination
		while(true) {
			System.out.println("===============================");
			System.out.println("Time: "+time);
			droneTask.mavic1.update();
			droneTask.mavic2.update();
			droneTask.mavic3.update();
			droneTask.mavic4.update();
			droneTask.mavic5.update();
			if(droneTask.mavic1.getBatt_usage()>0) {
				droneTask.mavic1.moveToDestination(droneTask.mavic1.getX_axis(), droneTask.mavic1.getY_axis(), droneTask.mavic1.getHeading(), droneTask.mavic1.getSpeed(), droneTask.mavic1.getLoad_usage(), droneTask.mavic1.getBatt_usage());	
			}
			if(droneTask.mavic1.getBatt_usage()<0||droneTask.mavic1.getBatt_usage()==0){
				droneTask.mavic1.setBatt_usage(0);
				a=false;			
			}
			if(droneTask.mavic2.getBatt_usage()>0) {
				droneTask.mavic2.moveToDestination(droneTask.mavic2.getX_axis(), droneTask.mavic2.getY_axis(), droneTask.mavic2.getHeading(), droneTask.mavic2.getSpeed(), droneTask.mavic2.getLoad_usage(), droneTask.mavic2.getBatt_usage());
			}
			if(droneTask.mavic2.getBatt_usage()<0||droneTask.mavic2.getBatt_usage()==0){
				droneTask.mavic2.setBatt_usage(0);
				b=false;
			}	
			
			if(droneTask.mavic3.getBatt_usage()>0) {
				droneTask.mavic3.moveToDestination(droneTask.mavic3.getX_axis(), droneTask.mavic3.getY_axis(), droneTask.mavic3.getHeading(), droneTask.mavic3.getSpeed(), droneTask.mavic3.getLoad_usage(), droneTask.mavic3.getBatt_usage());
				droneTask.mavic3.setBatt_usage(0);
				c=false;
			}
			if(droneTask.mavic3.getBatt_usage()<0||droneTask.mavic3.getBatt_usage()==0){
				droneTask.mavic3.setBatt_usage(0);
				c=false;
			}			
			if(droneTask.mavic4.getBatt_usage()>0) {
				droneTask.mavic4.moveToDestination(droneTask.mavic4.getX_axis(), droneTask.mavic4.getY_axis(), droneTask.mavic4.getHeading(), droneTask.mavic4.getSpeed(), droneTask.mavic4.getLoad_usage(), droneTask.mavic4.getBatt_usage());
				droneTask.mavic4.setBatt_usage(0);
				d=false;
			}
			if(droneTask.mavic4.getBatt_usage()<0||droneTask.mavic4.getBatt_usage()==0){
				droneTask.mavic4.setBatt_usage(0);
				d=false;
			}
			if(droneTask.mavic5.getBatt_usage()>0) {
				droneTask.mavic5.moveToDestination(droneTask.mavic5.getX_axis(), droneTask.mavic5.getY_axis(), droneTask.mavic5.getHeading(), droneTask.mavic5.getSpeed(), droneTask.mavic5.getLoad_usage(), droneTask.mavic5.getBatt_usage());
				droneTask.mavic5.setBatt_usage(0);
				e=false;
			}
			if(droneTask.mavic5.getBatt_usage()<0||droneTask.mavic5.getBatt_usage()==0){
				droneTask.mavic5.setBatt_usage(0);
				e=false;
			}
			System.out.println("===============================");
			time++;
			if(a==false&&b==false&&c==false&&d==false&&e==false) {
				System.out.println("===============================");
				System.out.println("Time: "+time);
				droneTask.mavic1.update();
				droneTask.mavic2.update();
				droneTask.mavic3.update();
				droneTask.mavic4.update();
				droneTask.mavic5.update();
				System.out.println("===============================");
				break;
			}
		}
	}
	
	public static void main(String args[]) {	
		run();
	}
}
