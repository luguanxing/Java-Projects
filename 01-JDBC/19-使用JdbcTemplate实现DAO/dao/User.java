package dao;
import java.util.Date;

public class User {
	private int id;
	private String name;
	private Date birthday;
	private float money;
	
	public User() {

	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(float money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return    "id=" + this.id + "\t"
				+ "name=" + this.name + "\t"
				+ "birthday=" + this.birthday + "\t"
				+ "money=" + this.money + "\t";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
	
	private void privateMethod() {
		
	}
	
	public void sayHello() {
		System.out.println("sayHello()!");
	}
}
