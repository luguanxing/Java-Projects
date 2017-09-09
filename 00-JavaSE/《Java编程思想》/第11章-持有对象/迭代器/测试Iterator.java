package 迭代器;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class 测试Iterator {

	//通过collection接口的Iterator遍历显示
	private static void display(Iterator it) {
		System.out.print("[");
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.print(obj);
			if (it.hasNext())
				System.out.print(", ");
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList(Arrays.asList(1, 2, "haha"));
		LinkedList linkedList = new LinkedList(list);
		HashSet hashSet = new HashSet(list);
		
		display(list.iterator());
		display(linkedList.iterator());
		display(hashSet.iterator());
	}

}
