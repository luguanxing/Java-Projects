
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
		Thread thread = new Thread(new JoinThread(), "子线程");
		thread.start();
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				//join后直到子线程完成才继续
				System.out.println("--->子线程插队开始<---");
				thread.join();
				System.out.println("--->子线程插队完成<---");
			}
			System.out.println("主线程" + "->" + i);
			Thread.sleep(200);
		}
	}

}
