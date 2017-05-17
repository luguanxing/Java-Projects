class CStorage {
	private int[] cells = new int[10];
	private int inPos, outPos, count;
	public CStorage() {
		inPos = outPos = count = 0;
	}
	public synchronized void put(int num) throws InterruptedException {
		while (count == cells.length)
			this.wait();
		System.out.println(">>>cells["+inPos+"]放入数据"+num);
		cells[inPos++] = num;
		count++;
		if (inPos == cells.length)
			inPos = 0;
		this.notify();
	}
	public synchronized void get() throws InterruptedException {
		while (count == 0)
			this.wait();
		System.out.println("<<<<<cells["+outPos+"]取出数据"+cells[outPos]);
		outPos++;
		count--;
		if (outPos == cells.length)
			outPos = 0;
		this.notify();
	}
}

class CInput implements Runnable {
	private CStorage st;
	private int num;
	public CInput(CStorage st) {
		this.st = st;
	}
	@Override
	public void run() {
		while (true) {
			try {
				st.put(num++);
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}

class COutput implements Runnable {
	private CStorage st;
	public COutput(CStorage st) {
		this.st = st;
	}
	@Override
	public void run() {
		while (true) {
			try {
				st.get();
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}

public class CommunciateThreadsExample2 {

	public static void main(String[] args) {
		CStorage storage = new CStorage();
		CInput cinput = new CInput(storage);
		COutput coutput = new COutput(storage);
		new Thread(cinput).start();
		new Thread(coutput).start();
	}

}
