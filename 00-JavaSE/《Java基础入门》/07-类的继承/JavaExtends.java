class Animal {
	public String name;
	public Animal() {
		name = "����";
	}
	public Animal(String name) {
		this.name = name;
	}
	public void Shout() {
		System.out.print("����һֻ"+name+"! ");
	}
}

class Dog extends Animal {
	public Dog() {	//���ø��෽��
		super("С��");
	}
	public void Shout() {	//���¸��෽��
		super.Shout();
		System.out.println("������!");
	}
}

public class JavaExtends {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.Shout();
		System.out.println("");
		Dog dog = new Dog();
		dog.Shout();
	}
}