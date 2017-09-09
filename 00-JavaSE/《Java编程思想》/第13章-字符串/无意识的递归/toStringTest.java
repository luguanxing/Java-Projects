package 无意识的递归;

public class toStringTest {
	
	@Override
	public String toString() {
		return "正确的toString -> " + super.toString();
	}

//	@Override
//	public String toString() {
//		return "错误的this.toString导致无限递归 -> " + this;
//	}

	public static void main(String[] args) {
		
		System.out.println(new toStringTest());
		
	}

}
