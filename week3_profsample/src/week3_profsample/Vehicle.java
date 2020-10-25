package week3_profsample;

public class Vehicle {
	int passengers;
	double fuelCap;
	double kpl;
	
	String make;
	String model;
	String license;
	
	
	public Vehicle() {
		System.out.println("Vehicle default constructor");
		passengers=4;
		fuelCap=180.0;
		kpl=30.0;
		
		make="Unknown";
		model="Unknown";
		license="Unknown";
	}	
	
	public Vehicle(String license, String make, String model, int passengers, double fuelCap, double kpl) {
		System.out.println("Vehicle custom constructor" + make);
		
		this.license=license;
		this.make=make;
		this.model=model;
		
		this.passengers=passengers;
		this.fuelCap=fuelCap;
		this.kpl=kpl;
	}
	
	public void setPassengers(int passengers) {
		if(passengers<0)passengers=0;
		if(passengers>7)passengers=7;
		this.passengers=passengers;
	}
	
	public double getKpl() {
		return kpl;
	}
	
	public void setKpl(double kpl) {
		this.kpl=kpl;
	}
	
	double range() {
		return (fuelCap*kpl);
	}
	
	public String toFormattedString() {
		return String.format(" Vehicle %1$8s %2$8s %3$04d", make, model, passengers);
	}
	
	public String toString() {
		return "Vehicle[lic=" + license+
				",make=" + make + 
				",model=" + model + 
				",pass=" + passengers + 
				",fuelcap=" + fuelCap +
				",kpl=" + kpl +"]";
	}
}
