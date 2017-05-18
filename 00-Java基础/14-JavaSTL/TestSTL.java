import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class TestSTL {

	public static void main(String[] args) {
		testArrayList();
		testLinkist();
		testIterator();
		testListIterator();
		testForEach();
		testSet();
		testMap();
	}

	public static void testArrayList() {
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("stu1");
		alist.add("stu2");
		alist.add("stu3");
		System.out.println("alist集合长度="+alist.size());
		System.out.println("alist第二个元素是"+alist.get(2));
		System.out.println("");
	}
	
	public static void testLinkist() {
		LinkedList<String> llist = new LinkedList<String>();
		llist.addFirst("linkstu1");
		llist.addFirst("linkstu2");		
		llist.addLast("linkstu3");
		System.out.println("llist集合长度="+llist.size());
		System.out.println("llist第1个元素是"+llist.getFirst());
		System.out.println("llist最后1个元素是"+llist.getLast());
		System.out.println("");
	}
	
	public static void testIterator() {
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("data1");
		alist.add("data2");
		alist.add("data3");
		Iterator<String> it = alist.iterator();
		int count = 1;
		while (it.hasNext()) {	//迭代器
			Object object = it.next();
			System.out.println("allist的第"+count+++"个元素是"+object);
		}
		System.out.println("");
	}
	
	
	public static void testListIterator() {
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("lidata1");
		alist.add("lidata2");
		alist.add("lidata3");
		System.out.println("alist="+alist);
		ListIterator<String> it = alist.listIterator(alist.size());	//反向遍历
		int count = 0;
		while (it.hasPrevious()) {	//迭代器
			Object object = it.previous();
			System.out.println("allist的第"+(alist.size()-(count++))+"个元素是"+object);
		}
		System.out.println("");
	}
	
	public static void testForEach() {
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("each1");
		alist.add("each2");
		alist.add("each3");
		int count = 1;
		for (Object object :alist) {	//foreach只能访问不能修改
			System.out.println("allist的第"+count+++"个元素是"+object);
		}
		System.out.println("");
	}
	
	public static void testSet() {
		HashSet hs = new HashSet();	//注意如果比较对象要重写equals方法
		hs.add("abc");
		hs.add("cde");
		hs.add("fff");
		hs.add("abc");
		hs.add("fff");
		System.out.println("hs="+hs);
		Iterator iterator = hs.iterator();
		int count = 1;
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			System.out.println("allist的第"+count+++"个元素是"+obj);
		}
		System.out.println("");
	}
	
	public static void testMap() {
		Map map = new HashMap();
		for (int i = 1; i <= 5; i++) {
			map.put(i, "data"+i);
		}
		System.out.println("map="+map);
		Set keyset = map.keySet();
		Iterator it = keyset.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = map.get(key);
			System.out.println("键="+key+"---->"+"值="+value);
		}
		System.out.println("");
	}
}

