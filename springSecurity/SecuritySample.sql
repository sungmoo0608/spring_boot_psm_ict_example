desc mvc_board;
select * from mvc_board;

create table users(
    username varchar2(50) primary key,
    password varchar2(100) not null,
    enabled char(1) default '1' 
);

create table authorities(
     username varchar2(50) not null,
     authority varchar2(50) not null,
     constraint fk_authorities_users foreign key(username) references users(username)
);

commit;

select * from users;

insert into users(username,password) values ('admin','admin');
insert into users(username,password) values ('user','user');
insert into users(username,password) values ('member','member');

insert into authorities(username,authority) values('user','ROLE_USER');
insert into authorities(username,authority) values('member','ROLE_MANAGER');
insert into AUTHORITIES (username,AUTHORITY) values('admin','ROLE_MANAGER');
insert into AUTHORITIES (username,AUTHORITY) values('admin','ROLE_ADMIN');
insert into AUTHORITIES (username,AUTHORITY) values('admin','ROLE_USER');

select * from authorities;

DELETE from authorities where authority = 'ROLE_USER';
