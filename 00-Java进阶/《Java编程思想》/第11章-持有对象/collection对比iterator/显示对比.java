package collection对比iterator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class 显示对比 {
	
	public static void show(Collection collection) {
		System.out.print("使用Collection类显示：");
		for (Object object : collection) {
			System.out.print(object + ", ");
		}
		System.out.println();
	}
	
	public static void show(Iterator it) {
		System.out.print("使用Iterator类显示：");
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
