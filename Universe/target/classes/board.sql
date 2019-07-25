drop table board;
create table board(
	bno       number constraint board_pk primary key,
	title     varchar2(100)  not null,
	contents  varchar2(500),
	writer    varchar2(50)  not null,
	regdate   date default sysdate,
	viewcnt   number default 0
	);
	
drop sequence board_seq;
create sequence board_seq
	start with 1
	increment by 1
	nocycle
	nocache;
	
select * from board;
insert into board(bno, title, contents, writer)
(select board_seq.nextval, title, contents, writer from board);

select count(*) from board;
select max(bno) from board;

select bno, title, contents, writer, regdate, viewcnt, rownum
from (select bno, title, contents, writer, regdate, viewcnt, rownum rn 
	from (select bno, title, contents, writer, regdate, viewcnt 
	    from board order by bno desc))
where rn between 1 and 10;
	

alter table board
drop column replycnt;

alter table board
add (replycnt number default 0);

update board set replycnt=(select count(bno) from reply where bno=9)
where bno=9;

update board set replycnt=(select count(bno) from reply where bno=10)
where bno=10;

update board set replycnt=(select count(*) from reply where reply.bno=board.bno);


	
