package week3_profsample;

public class VehicleTest {
	Vehicle minivan;
	Vehicle sportscar;
	Vehicle sportscar2;
	Vehicle[] carArray = new Vehicle[5];
	
	public VehicleTest() {
		System.out.println("VehicleTest Constructor called");
		minivan = new Vehicle("FRD123","FORD","Aerostar",
				6,40,35);
		sportscar= new Vehicle("AUD001","AUDI","A8",
				5,50,60);
		sportscar2=new Vehicle("AUD002","AUDI","A8",
				5,50,60);
		
		carArray[0]=minivan;
		carArray[2]=sportscar;
		carArray[4]=sportscar2;
		
		System.out.println("End of constructor");
	}
	
	public void run() {
		System.out.println("The range is "+minivan.range());
		System.out.println("Minivan: "+minivan);
		System.out.println("Sportscar: "+sportscar);
		System.out.println("Sportscar: "+sportscar2);
		
		System.out.println("Minivan: "+minivan.toFormattedString());
		System.out.println("Sportscar: "+sportscar.toFormattedString());
		System.out.println("Sportscar: "+sportscar2.toFormattedString());
	}
	
	public void printAutos() {
		for(Vehicle veh:carArray) {
			if (veh==null)continue;
			System.out.println("->" +veh.toFormattedString());
		}
	}
	
	public static void main(String[] args) {
		VehicleTest vehicleTest=new VehicleTest();
		vehicleTest.run();
		vehicleTest.printAutos();
	}
}
