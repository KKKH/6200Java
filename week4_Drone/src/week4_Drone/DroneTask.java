package week4_Drone;

//designed by Jiawei Zhang
//NUID:001531280

public class DroneTask extends DroneTest{

	public void DronesSet(){		
		mavic1.setTaskName("Alpha");
		mavic1.setObjective("pond");
		mavic1.setDate("10/Oct");
		mavic1.setTime(0.0);
		mavic1.setId(1);
		
		mavic2.setTaskName("Alpha");
		mavic2.setObjective("river");
		mavic2.setDate("10/Oct");
		mavic2.setTime(0.0);
		mavic2.setId(2);

		mavic3.setTaskName("Beta");
		mavic3.setObjective("campus");
		mavic3.setDate("10/Oct");
		mavic3.setTime(0.0);
		mavic3.setId(1);

		mavic4.setTaskName("Beta");
		mavic4.setObjective("tree");
		mavic4.setDate("10/Oct");
		mavic4.setTime(0.0);
		mavic4.setId(4);

		mavic5.setTaskName("Beta");
		mavic5.setObjective("rock");
		mavic5.setDate("10/Oct");
		mavic5.setTime(0.0);
		mavic5.setId(1);

	}
}
