class Animal {
	public String name;
	public Animal() {
		name = "动物";
	}
	public Animal(String name) {
		this.name = name;
	}
	public void Shout() {
		System.out.print("我是一只"+name+"! ");
	}
}

class Dog extends Animal {
	public Dog() {	//调用父类方法
		super("小狗");
	}
	public void Shout() {	//重新父类方法
		super.Shout();
		System.out.println("汪汪汪!");
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