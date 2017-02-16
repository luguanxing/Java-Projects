class Person {
	private String name;	//私有成员
	private int age;
	
	public Person() {	//私有成员
		name = "undefined";
		age = 0;
	}
	public Person(String name) {
		this();
		this.name = name;
	}
	public Person(int age) {
		this();
		this.age = age;
	}
	public Person(String name, int age) {
		this();
		this.name = name;
		this.age = age;
	}
	
	public String GetName() {	//方法
		return this.name;
	}
	public int GetAge() {
		return this.age;
	}
	public void speak() {
		System.out.println("My name is "+this.name+", I am "+this.age+" years old.");
	}
}


public class JavaObject {
	public static void main(String[] args) {
		Person person0 = new Person();
		Person person1 = new Person("123");
		Person person2 = new Person(321);
		Person person3 = new Person("123", 321);
			
		person0.speak();
		person1.speak();
		person2.speak();
		person3.speak();
	}
}