class TicketWindowSync implements Runnable {
	private Object lock = new Object();
	private int tickets = 10;
	public void run() {
		while (true) {
			synchronized (lock) {
				if (tickets > 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					Thread thread = Thread.currentThread();
					String threadname = thread.getName();
					System.out.println(threadname+"���ڷ��۵�"+tickets--+"��Ʊ");
					Thread.yield();
				} else {
					break;
				}
			}
		}
	}
}

public class SyncExample {

	public static void main(String[] args) {
		TicketWindowSync tw = new TicketWindowSync();
		new Thread(tw, "����1").start();
		new Thread(tw, "����2").start();
		new Thread(tw, "����3").start();
		new Thread(tw, "����a").start();
		new Thread(tw, "����b").start();
		new Thread(tw, "����c").start();
	}
}
