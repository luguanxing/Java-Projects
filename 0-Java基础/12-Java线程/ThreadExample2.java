class TicketWindow2 implements Runnable {
	private int tickets = 100;
	public void run() {
		while (true) {
			if (tickets > 0) {
				Thread thread = Thread.currentThread();
				String threadname = thread.getName();
				System.out.println(threadname+"正在发售第"+tickets--+"张票");
			}
		}
	}
}

public class ThreadExample2 {

	public static void main(String[] args) {
		TicketWindow2 tw = new TicketWindow2();
		new Thread(tw, "窗口1").start();
		new Thread(tw, "窗口2").start();
		new Thread(tw, "窗口3").start();
	}

}
