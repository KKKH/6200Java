package week4_prosample;

public class Dog extends PetAnimal{
	public Dog() {
		
	}
	
	public Dog(String name) {
		setName(name);
	}
	
	void bark() {
		System.out.println("Bark");
	}
	
	public static void main(String[] args) {
		PetAnimal pet= new PetAnimal();
		pet.walk();
		pet.setAge(3);
		pet.setName("AReallyLongName");
		
		System.out.println("My pet is named " + pet.getName()+
				", his name is " + pet.getAge() + 
				", ID= " +pet.getId());
		
		Dog dog=new Dog();
		dog.bark();
		dog.walk();
		dog.setName("Thor");
		dog.setAge(Integer.valueOf("3"));
		
		System.out.println("My pet is named " + pet.getName()+
				", his name is " + pet.getAge() + 
				", ID= " +pet.getId());
		
		System.out.println("PetAnimal instances: "+
		PetAnimal.getIdCounter());
	}
}
