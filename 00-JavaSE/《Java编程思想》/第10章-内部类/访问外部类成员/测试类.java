package 访问外部类成员;

public class 测试类 {

	public static void main(String[] args) {
		序列 xl = new 序列(10);
		for (int i = 0; i < 10; i++)
			xl.加入(i);
		选择器 xzq1 = xl.获得正向选择器();
		while (!xzq1.isEnd()) {
			System.out.print(xzq1.current() + " ");
			xzq1.next();
		}
		System.out.println("");
		选择器 xzq2 = xl.获得反向选择器();
		while (!xzq2.isEnd()) {
			System.out.print(xzq2.current() + " ");
			xzq2.next();
		}
	}

}
