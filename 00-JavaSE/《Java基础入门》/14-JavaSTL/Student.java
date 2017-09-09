
public class Student implements Comparable {
		public String name;
		public int age;
		
		public Student(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		@Override
		public int compareTo(Object obj) {
			Student stu = (Student)obj;
			if (this.age > stu.age)	//先排年龄
				return 1;
			if (this.age == stu.age) {	//后排名字
				return this.name.compareTo(stu.name);
			}
			return -1;
		}
		
		@Override
		public String toString() {
			return "["+ name + ","+ age + "]";
		}
}