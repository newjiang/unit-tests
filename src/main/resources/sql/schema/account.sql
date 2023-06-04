drop table if exists account;
create table account
(
    id    bigint(20) not null comment '主键id',
    name  varchar(30) null default null comment '姓名',
    age   int(2) null default null comment '年龄',
    email varchar(50) null default null comment '邮箱',
    phone varchar(11) null default null comment '手机号码',
    primary key (id)
);