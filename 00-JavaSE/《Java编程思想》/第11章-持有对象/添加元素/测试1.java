package ���Ԫ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ����1 {

	public static void main(String[] args) {
		
		//ʹ��Arrays.asList������תΪList
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
			System.out.println("�޷���Arrays.asList���޸ģ������½�new����");
		}
		

	}

}
