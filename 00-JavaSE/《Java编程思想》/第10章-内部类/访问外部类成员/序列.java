package �����ⲿ���Ա;

//���ð����ڲ���ʵ�ֶ���������ʵ������Ϊ��������϶����ͬʵ��
public class ���� {
	
	private Object[] items;
	private int next = 0;
	
	public ����(int size) {
		items = new Object[size];
	}
	
	public void ����(Object obj) {
		if (next < items.length)
			items[next++] = obj;
	}

	private class ����ѡ���� implements ѡ���� {
		private int i = 0;
		@Override
		public boolean isEnd() {
			//�ܷ��ʵ��ⲿ��
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
	
	private class ����ѡ���� implements ѡ���� {
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
	
	public ѡ���� �������ѡ����() {
		return new ����ѡ����();
	}
	
	public ѡ���� ��÷���ѡ����() {
		return new ����ѡ����();
	}
	
}
