package ���Ԫ��;

import java.util.Arrays;
import java.util.List;

public class ����2 {

	class level1 {};
	class level2_1 extends level1 {};
	class level2_2 extends level1 {};
	class level3_1 extends level2_1 {};
	class level3_2 extends level2_1 {};
	class level3_3 extends level2_1 {};
	
	public static void main(String[] args) {
		
		//�ڲ�����봴���ⲿ��ʵ��������
		����2 T = new ����2();
		
		List<level1> list1 = Arrays.asList(T.new level1(), T.new level2_1(), T.new level3_1());
		
		List<level1> list2 = Arrays.asList(T.new level3_3(), T.new level3_1());
		
		List<level1> list3 = Arrays.<level1>asList(T.new level3_3(), T.new level3_1());

	}

}
