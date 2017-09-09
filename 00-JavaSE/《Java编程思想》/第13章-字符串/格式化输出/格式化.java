package 格式化输出;

import java.util.Formatter;

public class 格式化 {

	private Formatter f = new Formatter(System.out);
	
	public void 打印头() {
		f.format("%-10s %10s\n", "物品", "价格");
		f.format("%-10s %6s\n", "----", "-----");
	}
	
	public void 打印项(String item, double price) {
		f.format("%-10s %-8.2f\n", item, price);
	}
	
	public static void main(String[] args) {
		格式化 gsh = new 格式化();
		gsh.打印头();
		gsh.打印项("AK47", 500);
		gsh.打印项("AWP", 1555.5555);
	}

}
