package 访问外部类成员;

//采用包含内部类实现而不用亲自实现是因为这样能组合多个不同实现
public class 序列 {
	
	private Object[] items;
	private int next = 0;
	
	public 序列(int size) {
		items = new Object[size];
	}
	
	public void 加入(Object obj) {
		if (next < items.length)
			items[next++] = obj;
	}

	private class 正向选择器 implements 选择器 {
		private int i = 0;
		@Override
		public boolean isEnd() {
			//能访问到外部类
			return i == items.length;
		}
		@Override
		public Object current() {
			return items[i];
		}
		@Override
		public void next() {
			if (!isEnd())
				i++;
		}
	}
	
	private class 反向选择器 implements 选择器 {
		private int i = items.length-1;
		@Override
		public boolean isEnd() {
			return i < 0;
		}
		@Override
		public Object current() {
			return items[i];
		}
		@Override
		public void next() {
			if (!isEnd())
				i--;
		}
	}
	
	public 选择器 获得正向选择器() {
		return new 正向选择器();
	}
	
	public 选择器 获得反向选择器() {
		return new 反向选择器();
	}
	
}
