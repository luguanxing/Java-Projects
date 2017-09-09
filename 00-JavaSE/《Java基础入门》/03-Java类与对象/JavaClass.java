class Person {
	private String name;	//˽�г�Ա
	private int age;
	
	public Person() {	//���캯������������
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
	public void finalize() {
		System.out.println("finalize.");
	}
	
	public String GetName() {	//����
		return this.name;
	}
	public int GetAge() {
		return this.age;
	}
	public void speak() {
		System.out.println("My name is "+this.name+", I am "+this.age+" years old.");
	}
}


public class JavaClass {
	public static void main(String[] args) {
		Person person0 = new Person();
		Person person1 = new Person("123");
		Person person2 = new Person(321);
		Person person3 = new Person("123", 321);
			
		person0.speak();
		person1.speak();
		person2.speak();
		person3.speak();
		
		person0 = null;
		person1 = null;
		person2 = null;
		person3 = null;
		
		System.gc();
		for (int i = 0; i < 100000; i++) {
			//wait for finalizing
		}
	}
}