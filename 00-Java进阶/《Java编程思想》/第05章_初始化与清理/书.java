package ��05��_��ʼ��������;

public class �� {
	
	String bookName = "������";
	boolean isChecked = false;
	
	public ��(String bookName) {
		isChecked = false;
		this.bookName = bookName;
	}
	public ��(boolean check, String bookName) {
		isChecked = check;
		this.bookName = bookName;
	}
	public void check() {
		isChecked = true;
	}
	
	protected void finalize() throws Throwable {
		if (!isChecked) {
			System.out.println("��δ��顶" + bookName + "���Ȿ�飡");
			super.finalize();
		}
	}
}
