interface Animal {
	public void shout();
}

class Dog implements Animal {
	public void shout() {
		System.out.println("����!");
	}
}

class Cat implements Animal {
	public void shout() {
		System.out.println("����!");
	}
}


public class Polymorphism {

	public static void TestAnimal(Animal an) {
		System.out.print(an.getClass().getName()+":");
		an.shout();
		if (an instanceof Cat) {
			System.out.println("��һֻè!");
		} else {
			System.out.println("����è!");
		}
	}
	
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();

		TestAnimal(dog);
		TestAnimal(cat);		
	}
}