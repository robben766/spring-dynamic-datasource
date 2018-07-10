# spring-dynamic-datasource
springboot + dynamic datasource

## 说明
根据业务不同动态切换数据源，可以达到垂直分表
会分别往2个不同的数据库插入数据：年龄大于等于30的插入db2中，小于30的插入db1中
## 初始化
创建2个mysql的数据库，并且建立相同的两张表
```sql
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
```
## 启动
运行TestInsert测试文件即可

## todo
基于这种动态数据源的是事务需要用到分布式事务