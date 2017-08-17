package 域和静态方法不是多态;

public class Sub extends Super {

	public int field = 2;
	
	@Override
	public int getField() {
		return this.field;
	}
	
	public int getSuperField() {
		return super.getField();
	}

}
