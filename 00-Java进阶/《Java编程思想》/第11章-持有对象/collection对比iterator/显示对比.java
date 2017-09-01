package collection�Ա�iterator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ��ʾ�Ա� {
	
	public static void show(Collection collection) {
		System.out.print("ʹ��Collection����ʾ��");
		for (Object object : collection) {
			System.out.print(object + ", ");
		}
		System.out.println();
	}
	
	public static void show(Iterator it) {
		System.out.print("ʹ��Iterator����ʾ��");
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		List list = Arrays.asList(1, "haha", 3);
		show(list);
		show(list.iterator());
		

	}

}
