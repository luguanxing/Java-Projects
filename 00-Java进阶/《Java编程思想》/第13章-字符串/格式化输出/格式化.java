package ��ʽ�����;

import java.util.Formatter;

public class ��ʽ�� {

	private Formatter f = new Formatter(System.out);
	
	public void ��ӡͷ() {
		f.format("%-10s %10s\n", "��Ʒ", "�۸�");
		f.format("%-10s %6s\n", "----", "-----");
	}
	
	public void ��ӡ��(String item, double price) {
		f.format("%-10s %-8.2f\n", item, price);
	}
	
	public static void main(String[] args) {
		��ʽ�� gsh = new ��ʽ��();
		gsh.��ӡͷ();
		gsh.��ӡ��("AK47", 500);
		gsh.��ӡ��("AWP", 1555.5555);
	}

}
