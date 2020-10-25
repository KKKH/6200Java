package week4_prosample;

import java.util.ArrayList;

public class Kannel {
	private ArrayList<PetAnimal>petList;
	
	public Kannel(){
		petList=new ArrayList<PetAnimal>();
	}
	
	public void run() {
		add(new Dog("Fido"));
		add(new Dog("Thor"));
		add(new Dog("Fenja"));
		list();
	}
	
	public void add(PetAnimal pAnimal) {
		petList.add(pAnimal);
	}
	
	public void list() {
		for(PetAnimal pet:petList) {
			System.out.print("Pet: "+pet);
		}
	}
	
	public static void main(String[] args) {
		Kannel ken1 = new Kannel();
		ken1.run();
	}
	
}
