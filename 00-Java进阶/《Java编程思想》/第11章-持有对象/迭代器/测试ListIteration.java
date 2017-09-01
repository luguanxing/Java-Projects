package µü´úÆ÷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ²âÊÔListIteration {

	public static void main(String[] args) {
		
		List list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(1,2,3,'a',"haha",6));
		
		ListIterator it = list.listIterator();
		
		while(it.hasNext()) {
			System.out.print(it.nextIndex() + "->" + it.next() + ", ");
		}
		
		System.out.println();
		
		while (it.hasPrevious()) {
			System.out.print(it.previousIndex() + "->" + it.previous() + ", ");
		}
		
	}

}
