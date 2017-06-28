# SQL注入,PreparedStatement和Statement

在SQL中包含特殊字符或SQL的关键字(如：' or 1 or ')时Statement将出现不可预料的结果（出现异常或查询的结果不正确），可用PreparedStatement来解决。<br><br>

### PreperedStatement（从Statement扩展而来）相对Statement的优点：
1.没有SQL注入的问题。<br>
2.Statement会使数据库频繁编译SQL(DriverManager.getConnection比较耗时)，可能造成数据库缓冲区溢出，PreparedStatement和Statement处理数据量大时理论上比Statement快<br>
3.数据库和驱动可以对PreperedStatement进行优化（只有在相关联的数据库连接没有关闭的情况下有效）。 <br>
<br>
### 区别:
1.executeQuery()注意PreperedStatement没有参数<br>
2.有string类型或增删改最好使用PreperedStatement<br>

