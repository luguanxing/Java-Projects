package ������_��ʼ��������;

import ������_��ʼ��������.showEnum.����;

public class �� {

	���� type;
	
	public ��(���� type) {
		this.type = type;
	}

	public void ���ҽ���() {
		System.out.println("����һ��"+type);
		switch (type) {
			case ������:
			case ��У��:
					System.out.println("�ú�ѧϰ���������ϣ�");
				break;
			case �����:
					System.out.println("רҵ���ӣ�");
				break;
			case ���б�:
					System.out.println("�һ�ɣ�");
				break;
			default:
					System.out.println("���̳������");
				break;
		}
		System.out.println();
	}
}
