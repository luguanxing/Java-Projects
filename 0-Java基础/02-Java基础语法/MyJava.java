public class MyJava {

	public static void main(String[] args) {
		System.out.println("Java Program Start now!\n");
		
		//基本数据类型
		int myint = 123;
		long mylong = 1234567890123L;
		float myfloat = 1.23f;
		double mydouble = 1.23;
		double mydouble2 = 1.23d;
		boolean mybool = true;
		byte mybyte = 12;
		
		//基本运算
		mybyte = (byte)myint;
		myint = mybyte;
		mybyte = 1;
		myint = (byte)(mybyte+mybyte);
		mybyte = (byte)(mybyte+mybyte);
		mybyte += mybyte;
		
		//数组
		int []Array = new int[100];
		int []Array2 = new int[]{1,2,3};
		int []Array3 = {1,2,3};
		
		int [][]Matrix = new int[10][10];
		int [][]Matrix2 = new int[10][];
		Matrix2[0] = new int[5];
		Matrix2[1] = new int[]{1,2,3};
		int [][]Matrix3 = {{1,2,3},{4,5}};
		
		printRect(3, 5);
	}
	
	//方法
	public static void  printRect(int height, int width) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.println("\n");	
	}


}
