class Mythread1 extends Thread {
	public void run() {
		while (true) {
			System.out.println("���߳�");
		}
	}	
}

public class JavaThread1 {
	
	public static void main(String[] args) {
		Mythread1 mythread1 = new Mythread1();
		mythread1.start();
		while (true) {
			System.out.println("���߳�");
		}
	}
}
