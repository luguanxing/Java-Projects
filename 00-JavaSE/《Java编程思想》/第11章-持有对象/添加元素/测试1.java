package 添加元素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class 测试1 {

	public static void main(String[] args) {
		
		//使用Arrays.asList将对象转为List
		Collection collection = new ArrayList(Arrays.asList(1,2,3));
		int[] nums = {4,5};
		collection.addAll(Arrays.asList(nums));
		collection.addAll(Arrays.asList(6,7,8));
		System.out.println(collection);
		
		try {
			List<Integer> list = Arrays.asList(1,2,3,4,5);
			list.add(6);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("无法在Arrays.asList上修改，必须新建new对象");
		}
		

	}

}
