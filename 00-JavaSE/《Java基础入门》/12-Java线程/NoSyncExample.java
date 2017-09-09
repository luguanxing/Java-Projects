class TicketWindow3 implements Runnable {
	private int tickets = 10;
	public void run() {
		while (true) {
			if (tickets > 0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				Thread thread = Thread.currentThread();
				String threadname = thread.getName();
				System.out.println(threadname+"正在发售第"+tickets--+"张票");
				Thread.yield();
			} else {
				break;
			}
		}
	}
}

public class NoSyncExample {

	public static void main(String[] args) {
		TicketWindow3 tw = new TicketWindow3();
		new Thread(tw, "窗口1").start();
		new Thread(tw, "窗口2").start();
		new Thread(tw, "窗口3").start();
		new Thread(tw, "窗口a").start();
		new Thread(tw, "窗口b").start();
		new Thread(tw, "窗口c").start();
	}
}
