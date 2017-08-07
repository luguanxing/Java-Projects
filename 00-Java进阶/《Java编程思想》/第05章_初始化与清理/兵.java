package 第05章_初始化与清理;

public class 兵 {

	public enum 兵种 {
		国防生, 军校生, 义务兵, 装甲兵, 飞行兵, 炮兵, 机械化步兵
	}
	
	兵种 type;
	
	public 兵(兵种 type) {
		this.type = type;
	}

	public void 自我介绍() {
		System.out.println("我是一个"+type);
		switch (type) {
			case 国防生:
			case 军校生:
					System.out.println("好好学习，天天向上！");
				break;
			case 义务兵:
					System.out.println("专业打杂！");
				break;
			case 飞行兵:
					System.out.println("我会飞！");
				break;
			default:
					System.out.println("打仗冲锋陷阵！");
				break;
		}
		System.out.println();
	}
}
