package Comparable�ӿ�;

import java.util.Comparator;

public class �޽ӿڱ��Ƚ��� extends �޽ӿڱ� implements Comparator<�޽ӿڱ�> {

	public �޽ӿڱ��Ƚ���(String ����, int ����) {
		super(����, ����);
	}

	@Override
	public int compare(�޽ӿڱ� o1, �޽ӿڱ� o2) {
		return o2.���� - o1.����;
	}

}
