package ������;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ˫����� {
	
	private String[] army = {"���ô󲽱�", "�����䲽��", "��������"};
	
	//�ֶ�����Iterable�����ӿڵ�ʵ��
	public Iterable �����ı�() {
		Collection c = Arrays.asList(army);	//Collection����ʵ����Iterable�ӿڣ��������ת��
		return c;
	}
	
	//�ֶ�����Iterable�����ӿڵ�ʵ��
	public Iterable �����ı�() {
		return new Iterable() {				//����Iterable�����ӿڵ�ʵ�֣���Ҫʵ��iterator����
			@Override
			public Iterator iterator() {
				return new Iterator() {		//ʵ��iterator��������Ҫ����Iterator������
					int index = army.length - 1;
					@Override
					public boolean hasNext() {
						return index >= 0;
					}
					@Override
					public Object next() {
						return army[index--];
					}
				};
			}
		};
	}
	
	public static void main(String[] args) {
		˫����� �������� = new ˫�����();
		for (Object obj : ��������.�����ı�()) {
			System.out.print(obj + ", ");
		}
		System.out.println();
		for (Object obj : ��������.�����ı�()) {
			System.out.print(obj + ", ");
		}
	}
	
}
