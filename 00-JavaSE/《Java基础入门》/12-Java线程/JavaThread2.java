class Mythread2 implements Runnable {
	public void run() {
		while (true) {
			System.out.println("子线程");
		}
	}
}

public class JavaThread2 {

	public static void main(String[] args) {
		Mythread2 mythread2 = new Mythread2();
		Thread thread = new Thread(mythread2);
		thread.start();
		while (true) {
			System.out.println("主线程");
		}
	}

}
