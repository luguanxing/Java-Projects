abstract class Animal {	//��������Ժ��������;��庯��
	public String type = "����";
	public void check() {
		System.out.println("����һ������!");
	}
	abstract void introduce();
}
class Dog extends Animal {
	public void introduce() {
		System.out.println(type);
		System.out.println("����һֻ��!����!");
		check();
	}
}


interface Plant {	//�ӿ����еĺ������ǳ�����
	public String type = "ֲ��";
	abstract void introduce();
//	public void check() {
//		System.out.println("����һ��ֲ��!");
//	}
}
class Flower implements Plant {
	public void introduce() {
		System.out.println(type);
		System.out.println("����һ�仨!���ܽ�!");
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