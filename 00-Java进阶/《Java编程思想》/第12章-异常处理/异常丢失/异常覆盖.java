package 异常丢失;

public class 异常覆盖 {
	
	public static void 某方法() throws Exception {
		try {
			throw new Exception("严重错误");
		} catch (Exception e) {
			
		} finally {
			//一个异常还没解决就引发另一个异常
			throw new Exception("小错误");
		}
	}
	
	public static void main(String[] args) {
		try {
			某方法();
		} catch (Exception e) {
			System.out.println("发生了" + e);
		}
	}

}
