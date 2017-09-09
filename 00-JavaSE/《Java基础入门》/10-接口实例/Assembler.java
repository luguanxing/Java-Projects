interface PCIcard {	//�ӿ�
	void start();
	void end();
}

class NetWorkCard implements PCIcard {	//NetWorkCard��
	public void start() {
		System.out.println("��������");
	}
	public void end() {
		System.out.println("�����ر�");	
	}
}

class SoundCard implements PCIcard {	//SoundCard��
	public void start() {
		System.out.println("��������");
	}
	public void end() {
		System.out.println("�����ر�");	
	}
}

class MainBoard {	//MainBoard������
	public void CheckCard(PCIcard card) {
		System.out.println("����һ��"+card.getClass().getName());
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