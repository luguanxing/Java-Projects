package 第05章_初始化与清理;

public class 清理条件Finalize {

	public static void main(String[] args) throws Throwable {
		
		书 Java入门 = new 书("Java入门");
		书 Java网络编程 = new 书(true, "Java网络编程");
		书 Java编程思想 = new 书(false, "Java编程思想");
		
		Java入门.check();
		
		Java入门.finalize();
		Java网络编程.finalize();
		Java编程思想.finalize();
		System.gc();
		
	}

}
