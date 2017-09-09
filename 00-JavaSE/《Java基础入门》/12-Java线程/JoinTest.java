
class JoinThread implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + "--->" + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new JoinThread(), "���߳�");
		thread.start();
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				//join��ֱ�����߳���ɲż���
				System.out.println("--->���̲߳�ӿ�ʼ<---");
				thread.join();
				System.out.println("--->���̲߳�����<---");
			}
			System.out.println("���߳�" + "->" + i);
			Thread.sleep(200);
		}
	}

}
