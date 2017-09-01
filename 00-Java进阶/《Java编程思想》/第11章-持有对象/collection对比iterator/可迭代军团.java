package collection�Ա�iterator;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class �ɵ������� extends AbstractCollection {
	//�̳�AbstractCollection������ʵ��Collection����Ϊ����ʵ�����еķ���

	private String[] army = {"�������", "��������", "�¹�����"};

	public static void main(String[] args) {
		�ɵ������� ��һ�� = new �ɵ�������();
		��ʾ�Ա�.show(��һ��);
		��ʾ�Ա�.show(��һ��.iterator());
	}

	@Override
	public Iterator iterator() {
		return new Iterator() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < army.length;
			}
			@Override
			public Object next() {
				return army[index++];
			}
		};
	}

	@Override
	public int size() {
		return army.length;
	}

}
