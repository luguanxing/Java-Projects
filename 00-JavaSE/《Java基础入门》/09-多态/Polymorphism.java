interface Animal {
	public void shout();
}

class Dog implements Animal {
	public void shout() {
		System.out.println("汪汪!");
	}
}

class Cat implements Animal {
	public void shout() {
		System.out.println("喵喵!");
	}
}


public class Polymorphism {

	public static void TestAnimal(Animal an) {
		System.out.print(an.getClass().getName()+":");
		an.shout();
		if (an instanceof Cat) {
			System.out.println("是一只猫!");
		} else {
			System.out.println("不是猫!");
		}
	}
	
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();

		TestAnimal(dog);
		TestAnimal(cat);		
	}
}