import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class TestAPI {

	public static void main(String[] args) {
		testMath();
		testTime();
	}

	public static void testMath() {
		Random rmd = new Random();
		System.out.print("10��[0,100)�����:");
		for (int i = 0; i < 10; i++)
			System.out.print(rmd.nextInt(100)+" ");
		System.out.println("");
		System.out.print("5��boolean�����:");
		for (int i = 0; i < 10; i++)
			System.out.print(rmd.nextBoolean()+" ");
		System.out.println("");
		System.out.println("");
	}
	
	public static void testTime() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("��ǰʱ��(+8ʱ��):"+df.format(new Date()));
	}
	
}
