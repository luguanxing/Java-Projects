package 适配器设计模式;

public class 测试类 {

	public static void 指挥攻击(攻击者 attacker, Object 目标) {
		attacker.攻击(目标);
	}
	
	public static void main(String[] args) {
		兵[] 集团军 = {new 兵(), new 装甲兵(), new 火箭兵()};
		指挥攻击(new 指挥员(集团军[0]), "恐怖分子");
		指挥攻击(new 指挥员(集团军[1]), "反动分子");
		指挥攻击(new 指挥员(集团军[2]), "邪教分子");
	}

}
