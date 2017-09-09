class MaxPriorityThread implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName()+"�������"+i);
		}
	}
}

class MinPriorityThread implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName()+"�������"+i);
		}
	}
}

public class PriorityThread {

	public static void main(String[] args) {
		Thread minthread = new Thread(new MinPriorityThread(), "���ȼ��͵��߳�");
		Thread maxthread = new Thread(new MinPriorityThread(), "���ȼ��ߵ��߳�");		
		minthread.setPriority(Thread.MIN_PRIORITY);
		maxthread.setPriority(Thread.MAX_PRIORITY);
		minthread.start();
		maxthread.start();
	}

}
