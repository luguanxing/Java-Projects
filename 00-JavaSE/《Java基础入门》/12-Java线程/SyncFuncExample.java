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
		if (tickets > 0) {	//����ʱҲҪ�ж�,�������ʱ�����Ѿ��Ǹ���
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			Thread thread = Thread.currentThread();
			String threadname = thread.getName();
			System.out.println(threadname+"���ڷ��۵�"+tickets--+"��Ʊ");
		}
	}
}


public class SyncFuncExample {

	public static void main(String[] args) {
		TicketWindowSyncFuc tw = new TicketWindowSyncFuc();
		new Thread(tw, "����1").start();
		new Thread(tw, "����2").start();
		new Thread(tw, "����3").start();
		new Thread(tw, "����a").start();
		new Thread(tw, "����b").start();
		new Thread(tw, "����c").start();
	}

}
