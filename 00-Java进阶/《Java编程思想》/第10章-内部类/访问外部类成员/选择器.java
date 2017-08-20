package 访问外部类成员;

//选择器接口，具体实现可不一样，如正向选择器，反向选择器
public interface 选择器 {
	boolean isEnd();
	Object current();
	void next();
}
