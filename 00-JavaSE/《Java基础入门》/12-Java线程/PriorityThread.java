class MaxPriorityThread implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName()+"正在输出"+i);
		}
	}
}

class MinPriorityThread implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName()+"正在输出"+i);
		}
	}
}

public class PriorityThread {

	public static void main(String[] args) {
		Thread minthread = new Thread(new MinPriorityThread(), "优先级低的线程");
		Thread maxthread = new Thread(new MinPriorityThread(), "优先级高的线程");		
		minthread.setPriority(Thread.MIN_PRIORITY);
		maxthread.setPriority(Thread.MAX_PRIORITY);
		minthread.start();
		maxthread.start();
	}

}
