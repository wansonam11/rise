drop table tbl_msg;
drop table tbl_user;
drop sequence tbl_msg_seq;

create table tbl_user(
	userid	varchar2(25) constraint user_pk primary key,
	userpw  varchar2(25) not null,
	username  varchar2(25) not null,
	userpoint  number default 0
);

create table tbl_msg(
	mid  number constraint msg_pk primary key,
	receiver  varchar2(25) references tbl_user(userid),
	sender  varchar2(25) references tbl_user(userid),
	message  varchar2(200) not null,
	opendate  date,
	senddate  date default sysdate
);

create sequence tbl_msg_seq 
	start with 1
	increment by 1
	nocycle
	nocache;
	
insert into tbl_user (userid, userpw, username) values ('Jenni', '1234', 'blackpink');
insert into tbl_user (userid, userpw, username) values ('Rose', '2', 'blackpink');
insert into tbl_user (userid, userpw, username) values ('Jisoo', '3', 'blackpink');
insert into tbl_user (userid, userpw, username) values ('Lisa', '4', 'blackpink');
insert into tbl_user (userid, userpw, username) values ('Blinks', '5', 'blackpink');


