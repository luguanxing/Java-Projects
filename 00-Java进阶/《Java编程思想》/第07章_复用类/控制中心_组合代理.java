package 第07章_复用类;

public class 控制中心_组合代理 {
	private 控制器 kzq = new 控制器();
	public void 上() {System.out.print("控制器使用:");kzq.上();}
	public void 下() {System.out.print("控制器使用:");kzq.下();}
	public void 左() {System.out.print("控制器使用:");kzq.左();}
	public void 右() {System.out.print("控制器使用:");kzq.右();}
}
