package 第五章_初始化与清理;

public class Book {
	
	String bookName = "无名书";
	boolean isChecked = false;
	
	public Book(String bookName) {
		isChecked = false;
		this.bookName = bookName;
	}
	public Book(boolean check, String bookName) {
		isChecked = check;
		this.bookName = bookName;
	}
	public void check() {
		isChecked = true;
	}
	
	protected void finalize() throws Throwable {
		if (!isChecked) {
			System.out.println("还未检查《" + bookName + "》这本书！");
			super.finalize();
		}
	}
}
