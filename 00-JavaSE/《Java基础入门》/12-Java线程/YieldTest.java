
class YieldThread1 extends Thread {
	public YieldThread1(String name) {
		super(name);
	}
	public void run() {
		for (int i = 1; i <= 10; i++) {
			if (i==5) {
				System.out.println(Thread.currentThread().getName() + "--->�߳��ò�");
				Thread.yield();
			}
			System.out.println(Thread.currentThread().getName() + "->" + i);
		}
	}
}

class YieldThread2 extends Thread {
	public YieldThread2(String name) {
		super(name);
	}
	public void run() {
		for (int i = 1; i <= 10; i++) {
			if (i==2 || i==5 || i==7 || i==9) {
				System.out.println(Thread.currentThread().getName() + "--->�߳��ò�");
				Thread.yield();
			}
			System.out.println(Thread.currentThread().getName() + "->" + i);
		}
	}
}

public class YieldTest {

	public static void main(String[] args) {
		Thread t1 = new YieldThread1("�߳�A");
		Thread t2 = new YieldThread2("�߳�B");
		t1.start();
		t2.start();
	}

}
