package 匿名内部类;

public class 测试类 {

	public static void main(String[] args) {
		神秘兵工厂 factory = new 神秘兵工厂();
		
		兵 bing = factory.获得匿名兵();
		bing.攻击();
		
		System.out.println("");
		
		枪 qiang = factory.获得匿名枪("AK47");
		qiang.打();
	}

}
