package 第五章_初始化与清理;

public class Finalize {

	public static void main(String[] args) throws Throwable {
		
		Book Java入门 = new Book("Java入门");
		Book Java网络编程 = new Book(true, "Java网络编程");
		Book Java编程思想 = new Book(false, "Java编程思想");
		
		Java入门.check();
		
		Java入门.finalize();
		Java网络编程.finalize();
		Java编程思想.finalize();
		System.gc();
		
	}

}
