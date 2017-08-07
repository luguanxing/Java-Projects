package 第05章_初始化与清理;

import 第05章_初始化与清理.兵.兵种;

public class 使用枚举 {
	
	public static void main(String[] args) {
		兵 bing1 = new 兵(兵种.国防生);
		兵 bing2 = new 兵(兵种.装甲兵);
		兵 bing3 = new 兵(兵种.飞行兵);
		bing1.自我介绍();
		bing2.自我介绍();
		bing3.自我介绍();
	}

}
