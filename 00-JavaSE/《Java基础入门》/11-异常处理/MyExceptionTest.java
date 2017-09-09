class MyException extends Exception {	//自定义异常
	public MyException() {
		super();
	}
	public MyException(String message) {
		super(message);
	}
	public void Explain() {
		System.out.println("自定义异常信息:"+super.getMessage());
	}
}

public class MyExceptionTest {
	
	public static void MyCheck (int num) throws MyException {	//可能抛出异常的函数应声明
		if (num < 0) {
			throw new MyException(num+"是负数!");
		} else {
			System.out.println(num+"是正数");
		}
	}
	
	public static void main(String[] args) {
		//测试系统异常
		try {
			int result = 1/0;
		} catch (Exception e) {
			System.out.println("异常信息:"+e.getMessage());
		} finally {
			System.out.println("已处理系统异常\n");
		}
		
		//测试自定义异常
		try {
			MyCheck(1);
			MyCheck(-1);	//抛出后不会再往下执行
			MyCheck(0);
		} catch (MyException e) {
			e.Explain();
			return; 	//这里加了return也要执行后面finally,除非是exit()方法
		} finally {
			System.out.println("已处理自定义异常");
		}
		
		System.out.println("结束测试");	//这里不会被执行到，因为上面已执行return
	}
}