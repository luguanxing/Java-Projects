package ��;�̬�������Ƕ�̬;

public class ������ {

	public static void main(String[] args) {
		���������();
		���Ծ�̬����();
	}

	public static void ���������() {
		Super sup = new Sub();
		System.out.println("sup.field="+sup.field);
		System.out.println("sup.getField()="+sup.getField());
		Sub sub = new Sub();
		System.out.println("sub.field="+sub.field);
		System.out.println("sub.getField()="+sub.getField());
		System.out.println("sub.getSuperField()="+sub.getSuperField());
	}
	
	public static void ���Ծ�̬����() {
		staticSuper sp = new staticSub();
		System.out.println(sp.staticGet());
		System.out.println(sp.dynamicGet());
		staticSub sb = new staticSub();
		System.out.println(sb.staticGet());
		System.out.println(sb.dynamicGet());
	}
	
}
