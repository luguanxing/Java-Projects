# 01-简单jdbc使用

------

学习jdbc的简单使用方法和原理

------


## 1.注册驱动
Class.forName(“com.mysql.jdbc.Driver”);<br>
    推荐这种方式，不会对具体的驱动类产生依赖。<br><br>
DriverManager.registerDriver(com.mysql.jdbc.Driver);<br>
    会造成DriverManager中产生两个一样的驱动，并会对具体的驱动类产生依赖。<br><br>
System.setProperty(“jdbc.drivers”, “driver1:driver2”);<br>
    虽然不会对具体的驱动类产生依赖；但注册不太方便，所以很少使用。 <br>
<br><br>
		
## 2.建立连接
  url格式：<br>
    JDBC:子协议:子名称//主机名:端口/数据库名？属性名=属性值&…<br>
    主机名:端口可以缺省为localhost:3306写作jdbc:mysql:///db_jdbc<br>
  其他参数如：useUnicode=true&characterEncoding=GBK<br>
<br><br>
    
## 3.创建语句
<br><br>

## 4.执行查询语句
<br><br>

## 5.处理执行结果(ResultSet)
<br><br>

## 6.释放资源,注意顺序
  数据库连接（Connection）是非常稀有的资源，用完后必须马上释放，如果Connection不能及时正确的关闭将导致系统宕机。
  Connection的使用原则是尽量晚创建，尽量早的释放。
<br><br>



