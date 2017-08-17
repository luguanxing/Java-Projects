package 域和静态方法不是多态;

class staticSub extends staticSuper {

	public static String staticGet() {
		return "Derived staticGet";
	}
	
	@Override
	public String dynamicGet() {
		return "Derived dynamicGet";
	}

}
