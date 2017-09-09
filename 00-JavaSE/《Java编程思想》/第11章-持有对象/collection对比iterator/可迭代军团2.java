package collection�Ա�iterator;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class �ɵ�������2 implements Iterable {
	//ʵ��Iterable���ʹ��foreach����
	
	private String[] army = {"�й����", "���ʲ���", "����˹����"};

	public static void main(String[] args) {
		�ɵ�������2 �ڶ��� = new �ɵ�������2();
		
		��ʾ�Ա�.show(�ڶ���.iterator());
		
		for (Object object : �ڶ���) {
			System.out.print(object + ", ");
		}
		
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

}
