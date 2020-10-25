package week4_prosample;

public class PetAnimal {
	private int id;
	private static int idCounter=0;
	private int age=1;
	private String name="";
	
	static {
		System.out.println("Setting a static value in PetAnimal");
		idCounter=0;
	}
	
	public PetAnimal() {
		name="unknown";
		id=idCounter++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		PetAnimal.idCounter = idCounter;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age<0) age=0;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	private String fixName(String name) {
		if (name.length()<=10) return name;
		return (name.substring(0, 9));
	}
	
	public void setName(String name) {
		this.name = fixName(name);
	}
	
	void walk() {
		System.out.println("We are walking");
	}
}
