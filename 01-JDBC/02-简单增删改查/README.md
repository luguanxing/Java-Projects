# 基本的CRUD（创建、读取、更新、删除） 


### CRUD总结
增、删、改用Statement.executeUpdate来完成，返回整数(匹配的记录数)，这类操作相对简单。
查询用Statement.executeQuery来完成，返回的是ResultSet对象，ResultSet中包含了查询的结果；查询相对与增、删、改要复杂一些，因为有查询结果要处理。
<br><br>


```
Connection conn = null;
Statement st=null;
ResultSet rs = null;
try {
	//获得Connection
	//创建Statement
	//处理查询结果ResultSet
} finally {
	//释放资源ResultSet, Statement,Connection
}

```
