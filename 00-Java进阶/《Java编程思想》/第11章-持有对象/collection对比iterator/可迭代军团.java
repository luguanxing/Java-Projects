package collection对比iterator;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class 可迭代军团 extends AbstractCollection {
	//继承AbstractCollection而不是实现Collection是因为不用实现所有的方法

	private String[] army = {"美国大兵", "苏联步兵", "德国步兵"};

	public static void main(String[] args) {
		可迭代军团 第一军 = new 可迭代军团();
		显示对比.show(第一军);
		显示对比.show(第一军.iterator());
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
