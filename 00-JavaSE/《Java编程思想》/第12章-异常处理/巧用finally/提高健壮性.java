package 巧用finally;

public class 提高健壮性 {

	public static void main(String[] args) {

		int 尝试次数 = 0;
		
		while (true) {
			
			try {
				System.out.println("第" + (++尝试次数) + "次尝试");
				throw new Exception("某错误");
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (尝试次数 >= 3) {
					System.out.println("多次尝试均失败");
					break;
				}
			}
			
		}

	}

}
