package collection对比iterator;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class 可迭代军团2 implements Iterable {
	//实现Iterable便可使用foreach方法
	
	private String[] army = {"中国大兵", "朝鲜步兵", "俄罗斯步兵"};

	public static void main(String[] args) {
		可迭代军团2 第二军 = new 可迭代军团2();
		
		显示对比.show(第二军.iterator());
		
		for (Object object : 第二军) {
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
