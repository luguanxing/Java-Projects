package 第五章_初始化与清理;


public class showEnum {

	public enum 兵种 {
		国防生, 军校生, 义务兵, 装甲兵, 飞行兵, 炮兵, 机械化步兵
	}
	
	public static void main(String[] args) {
		兵 bing1 = new 兵(兵种.国防生);
		兵 bing2 = new 兵(兵种.装甲兵);
		兵 bing3 = new 兵(兵种.飞行兵);
		bing1.自我介绍();
		bing2.自我介绍();
		bing3.自我介绍();
	}

}
