```text
实现多张表主键不重复问题，本例仅展示两张表主键不重复

参考资料
MyBatis新增时的序列主键
https://blog.csdn.net/east_mrchiu/article/details/70184652

mysql数据库实现nextval函数
https://www.jianshu.com/p/104a216e7db3

【mybatis】认识selectKey
https://www.cnblogs.com/xinruyi/p/11073258.html

下面是需要提前执行的sql
```

```text

CREATE TABLE `t_user1` (
	`user_id` INT(11) NOT NULL,
	`user_name` VARCHAR(255) NOT NULL,
	`password` VARCHAR(255) NOT NULL,
	`phone` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`user_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `t_user2` (
	`user_id` INT(11) NOT NULL,
	`user_name` VARCHAR(255) NOT NULL,
	`password` VARCHAR(255) NOT NULL,
	`phone` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`user_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `sequence` (
	`seq_name` VARCHAR(50) NOT NULL,
	`current_val` INT(11) NOT NULL,
	`increment_val` INT(11) NOT NULL DEFAULT '1',
	PRIMARY KEY (`seq_name`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

INSERT INTO sequence VALUES ('seq_test', '0', '1');

delimiter #
create function currval(v_seq_name VARCHAR(50))   
returns integer(11) 
begin
 declare value integer;
 set value = 0;
 select current_val into value  from sequence where seq_name = v_seq_name;
   return value;
end;

delimiter #
create function nextval (v_seq_name VARCHAR(50)) returns integer(11) 
begin
    update sequence set current_val = current_val + increment_val  where seq_name = v_seq_name;
    return currval(v_seq_name);
end;

```