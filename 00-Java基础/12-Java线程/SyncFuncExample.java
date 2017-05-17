class TicketWindowSyncFuc implements Runnable {
	private Object lock = new Object();
	private int tickets = 10;
	public void run() {
		while (tickets > 0) {
			if (tickets > 0) {
				SaleTicket();
			} else {
				break;
			}
		}
	}
	private synchronized void SaleTicket() {
		if (tickets > 0) {	//进入时也要判断,否则进来时可能已经是负数
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			Thread thread = Thread.currentThread();
			String threadname = thread.getName();
			System.out.println(threadname+"正在发售第"+tickets--+"张票");
		}
	}
}


public class SyncFuncExample {

	public static void main(String[] args) {
		TicketWindowSyncFuc tw = new TicketWindowSyncFuc();
		new Thread(tw, "窗口1").start();
		new Thread(tw, "窗口2").start();
		new Thread(tw, "窗口3").start();
		new Thread(tw, "窗口a").start();
		new Thread(tw, "窗口b").start();
		new Thread(tw, "窗口c").start();
	}

}
