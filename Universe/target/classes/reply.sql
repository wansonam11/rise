drob table reply;

create table reply(
	rno number constraint reply_pk primary key,
	bno number constraint reply_fk references board(bno),
	replytext varchar2(500),
	replyer varchar2(30),
	regdate date default sysdate,
	updatedate date default sysdate
);

drop sequence reply_seq;
create sequence reply_seq
		increment by 1
		start with 1
		nocycle
		nocache;
		
insert into reply (rno, bno, replytext, replyer) values (reply_seq.nextval, 36, '´ñ±Û4', '´ñ±Û4');
insert into reply (rno, bno, replytext, replyer) values (reply_seq.nextval, 36, '´ñ±Û5', '´ñ±Û4'); 
insert into reply (rno, bno, replytext, replyer) values (reply_seq.nextval, 36, '´ñ±Û6', '´ñ±Û4');  
insert into reply (rno, bno, replytext, replyer) values (reply_seq.nextval, 36, '´ñ±Û4', '´ñ±Û4');  
insert into reply (rno, bno, replytext, replyer) values (reply_seq.nextval, 36, '´ñ±Û4', '´ñ±Û4');  
insert into reply (rno, bno, replytext, replyer) values (reply_seq.nextval, 36, '´ñ±Û4', '´ñ±Û4');

select * from reply;

alter table reply
drop constraint reply_fk;


alter table reply
add constraint reply_fk foreign key(bno) references board(bno) on delete cascade;

alter table reply
add constraint reply_fk foreign key(bno) references board(bno) on delete cascade set null;
