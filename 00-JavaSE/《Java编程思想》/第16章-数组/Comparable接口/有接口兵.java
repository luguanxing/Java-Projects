package Comparable�ӿ�;

public class �нӿڱ� implements Comparable<�нӿڱ�> {
	
	String ����;
	int ����;
	
	public �нӿڱ�(String ����, int ����) {
		this.���� = ����;
		this.���� = ����;
	}

	@Override
	public int compareTo(�нӿڱ� o) {
		//��С��������
		return this.���� - o.����;
	}

	@Override
	public String toString() {
		return "�� [����=" + ���� + ", ����=" + ���� + "]";
	}
	
}
