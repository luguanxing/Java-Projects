package 数组实用方法;

import java.util.Arrays;
import java.util.Random;

public class 打印多维数组 {

	private static final Random rmd = new Random(System.currentTimeMillis());
	
	public static void main(String[] args) {
		
		int[][] array_2v = new int[rmd.nextInt(5)][];
		for (int i = 0; i < array_2v.length; i++) {
			array_2v[i] = new int[rmd.nextInt(5)];
			for (int j = 0; j < array_2v[i].length; j++) {
				array_2v[i][j] = rmd.nextInt(5);
			}
		}
		
		int[][][] array_3v = new int[rmd.nextInt(5)][][];
		for (int i = 0; i < array_3v.length; i++) {
			array_3v[i] = new int[rmd.nextInt(5)][];
			for (int j = 0; j < array_3v[i].length; j++) {
				array_3v[i][j] = new int[rmd.nextInt(5)];
				for (int k = 0; k < array_3v[i][j].length; k++)
					array_3v[i][j][k] = rmd.nextInt(5);
			}
		}
		
		System.out.println(Arrays.deepToString(array_2v));
		
		System.out.println(Arrays.deepToString(array_3v));
		
	}

}
