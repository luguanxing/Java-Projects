package ����ʶ�ĵݹ�;

public class toStringTest {
	
	@Override
	public String toString() {
		return "��ȷ��toString -> " + super.toString();
	}

//	@Override
//	public String toString() {
//		return "�����this.toString�������޵ݹ� -> " + this;
//	}

	public static void main(String[] args) {
		
		System.out.println(new toStringTest());
		
	}

}
