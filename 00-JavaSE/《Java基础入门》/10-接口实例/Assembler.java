interface PCIcard {	//接口
	void start();
	void end();
}

class NetWorkCard implements PCIcard {	//NetWorkCard类
	public void start() {
		System.out.println("网卡启动");
	}
	public void end() {
		System.out.println("网卡关闭");	
	}
}

class SoundCard implements PCIcard {	//SoundCard类
	public void start() {
		System.out.println("声卡启动");
	}
	public void end() {
		System.out.println("声卡关闭");	
	}
}

class MainBoard {	//MainBoard测试类
	public void CheckCard(PCIcard card) {
		System.out.println("这是一张"+card.getClass().getName());
	}
	public void TestCard(PCIcard card) {
		card.start();
		card.end();
	}
}

public class Assembler {
	public static void main(String[] args) {
		MainBoard mb = new MainBoard();
		
		NetWorkCard nc = new NetWorkCard();
		mb.CheckCard(nc);
		mb.TestCard(nc);
		
		SoundCard sc = new SoundCard();
		mb.CheckCard(sc);
		mb.TestCard(sc);
	}
}