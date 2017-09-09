package 巧用finally;

public class 操作对象 {

	public static void 一定成功的打开() {}
	public static void 可能失败的打开() {}
	public static void 一定成功的操作() {}
	public static void 可能失败的操作() {}
	public static void 一定成功的关闭() {}
	public static void 可能失败的关闭() {}
	
	public static void 测试1() {
		try {
			一定成功的打开();
			可能失败的操作();
		} catch (Exception e) {

		} finally {
			一定成功的关闭();
		}
	}
	
	public static void 测试2() {
		try {
			可能失败的打开();
			try {
				可能失败的操作();
			} catch (Exception 操作失败) {
				try {
					可能失败的关闭();
				} catch (Exception 关闭失败) {
					//关闭失败
				}
			} finally {
				一定成功的关闭();
			}
		} catch (Exception 初始化失败) {
			//打开失败,不用关闭
		} finally {
			//一般不再这里关闭，或者使用 if (obj!= null) obj.close();
		}
	}
	
	public static void main(String[] args) {


	}

}
