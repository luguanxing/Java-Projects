class Storage {
	private int[] cells = new int[10];
	private int inPos, outPos;
	public void put(int num) {
		System.out.println(">>>cells["+inPos+"]��������"+num);
		cells[inPos++] = num;
		if (inPos == cells.length)
			inPos = 0;
	}
	public void get() {
		System.out.println("<<<<<cells["+outPos+"]ȡ������"+cells[outPos]);
		outPos++;
		if (outPos == cells.length)
			outPos = 0;
	}
}

class Input implements Runnable {
	private Storage st;
	private int num;
	public Input(Storage st) {
		this.st = st;
	}
	@Override
	public void run() {
		while (true) {
			st.put(num++);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}

class Output implements Runnable {
	private Storage st;
	public Output(Storage st) {
		this.st = st;
	}
	@Override
	public void run() {
		while (true) {
			st.get();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}

public class CommunciateThreadsExample1 {

	public static void main(String[] args) {
		Storage storage = new Storage();
		Input input = new Input(storage);
		Output output = new Output(storage);
		new Thread(input).start();
		new Thread(output).start();
	}

}
