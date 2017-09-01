package 适配器;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class 双向军团 {
	
	private String[] army = {"加拿大步兵", "土耳其步兵", "法国步兵"};
	
	//手动返回Iterable匿名接口的实现
	public Iterable 正向阅兵() {
		Collection c = Arrays.asList(army);	//Collection本身实现了Iterable接口，因此向上转型
		return c;
	}
	
	//手动返回Iterable匿名接口的实现
	public Iterable 反向阅兵() {
		return new Iterable() {				//返回Iterable匿名接口的实现，需要实现iterator方法
			@Override
			public Iterator iterator() {
				return new Iterator() {		//实现iterator方法，需要返回Iterator匿名类
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
		双向军团 第三军团 = new 双向军团();
		for (Object obj : 第三军团.正向阅兵()) {
			System.out.print(obj + ", ");
		}
		System.out.println();
		for (Object obj : 第三军团.反向阅兵()) {
			System.out.print(obj + ", ");
		}
	}
	
}
