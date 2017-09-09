abstract class Animal {	//抽象类可以含抽象函数和具体函数
	public String type = "动物";
	public void check() {
		System.out.println("这是一个动物!");
	}
	abstract void introduce();
}
class Dog extends Animal {
	public void introduce() {
		System.out.println(type);
		System.out.println("我是一只狗!汪汪!");
		check();
	}
}


interface Plant {	//接口所有的函数都是抽象函数
	public String type = "植物";
	abstract void introduce();
//	public void check() {
//		System.out.println("这是一个植物!");
//	}
}
class Flower implements Plant {
	public void introduce() {
		System.out.println(type);
		System.out.println("我是一朵花!不能叫!");
	}
}

public class Abstruct_Inerface {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.introduce();
		
		Flower flower = new Flower();
		flower.introduce();
	}
}