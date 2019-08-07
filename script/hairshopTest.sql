
use hairshop;

select * from guest;
select * from designer;
select * from event;
select * from level;
select * from product;
select * from tax;
select * from workdialog;
select * from designer;
select * from workdialog;
where w_d_No=1 and
w_reservTime='2019-07-01'
;


select 
w_no,
w_workTime,
w_reservTime,
w_e_name,
w_d_no,
w_g_no,
g.g_no,
g.g_name
from workdialog w
join guest g 
on w.w_d_no=1 and w.w_g_no=g.g_no;


select
w_no,
w_workTime,
w_reservTime,
w_e_name,
w_d_no,
w_g_no,
c_w_no,
c_p_name,
g_no,
g_l_grade,
g_name,
g_tel,
g_point,
g_memo
from workdialog w
left join choice c 
on w.w_no=c.c_w_no
left join guest g
on w.w_g_no=g.g_no;



select * from Designer
where d_id = 'user1';


SELECT *
		FROM workdialog w
		left join designer d
		on w.w_d_no=d.d_no
		left join event e
		on w.w_e_name=e.e_name
		left join choice c
		on w.w_no=c.c_w_no
		left join product p
		on c.c_p_name=p.p_name
		left join guest g
		on w_g_no=g.g_no
		where w.w_no=1
;



select * from workdialog order by rand() limit 1;
select e_name from event order by rand() limit 1;
select d_no from designer order by rand() limit 1;
select g_no from guest order by rand() limit 1;




set @var="";
SELECT FROM_UNIXTIME(RAND() * (@end - @start) + @start);
SELECT FROM_UNIXTIME(RAND() * (select UNIX_TIMESTAMP(now()) - @start) + @start);
select if(FROM_UNIXTIME(@w_reservTime)>FROM_UNIXTIME(now()),1,0);
set @w_reservTime:=(SELECT FROM_UNIXTIME(RAND() * (@end - @start) + @start) as the_date);
select UNIX_TIMESTAMP(@w_reservTime);
select UNIX_TIMESTAMP(now());
select if(UNIX_TIMESTAMP(@w_reservTime) > UNIX_TIMESTAMP(now()), FROM_UNIXTIME(RAND() * (select UNIX_TIMESTAMP(now()) - @start) + @start),null);
select @w_reservTime,@w_workTime;

/* 1.시작~끝 시간 설정 */
/* 7/1~8/31셋팅 */
set @start=UNIX_TIMESTAMP('2017-01-01 00:00:00');
set @end=UNIX_TIMESTAMP('2017-12-31 23:59:59');
/* 당일데이터만 삽입 */
set @start=UNIX_TIMESTAMP(concat(left(curdate(),10),' 08:00:00'));
set @end=UNIX_TIMESTAMP(concat(left(curdate(),10),' 23:00:00'));
 
select @start,@end;
/* set start,end가*/
/* 당일만이면 2번만 */
/* 여러날짜면 3번까지 ctrl x하세요 */


/* 2.랜덤 workDialog 삽입하기 */
INSERT INTO hairshop.workdialog
( `w_reservTime`,`w_workTime`, `w_priceTotal`, w_e_name, w_d_no, w_g_no)
values
(@w_reservTime:=(SELECT FROM_UNIXTIME(RAND() * (@end - @start) + @start)),
if(UNIX_TIMESTAMP(@w_reservTime) < UNIX_TIMESTAMP(now()), @w_reservTime,null),
100000,
(select e_name from event order by rand() limit 1),
(select d_no from designer order by rand() limit 1),
(select g_no from guest order by rand() limit 1))
;

insert into choice(c_w_no,c_p_name) values
((select LAST_INSERT_ID()),(select p_name from product order by rand() limit 1))
;


/* 3.불필요 데이터 삭제 */

delete from choice where c_w_no in (select w_no from workdialog where `w_reservTime` between '2015-01-01' and '2019-12-31'
and left(right(`w_reservTime`,8),2) between 0 and 7);
delete from choice where c_w_no in (select w_no from workdialog where `w_reservTime` between '2015-01-01' and '2019-12-31'
and left(right(`w_reservTime`,8),2) between 22 and 24);
delete from choice where c_w_no in (select w_no from workdialog where `w_workTime` between '2015-01-01' and '2019-12-31'
and left(right(`w_reservTime`,8),2) between 0 and 7);
delete from choice where c_w_no in (select w_no from workdialog where `w_workTime` between '2015-01-01' and '2019-12-31'
and left(right(`w_reservTime`,8),2) between 22 and 24);







delete from workdialog;
select * from workdialog;

/* 여기까지 드래그 */

/* 특정 날자 사이에 랜덤값  */
set @start=UNIX_TIMESTAMP('2019-07-01 00:00:00');
set @end=UNIX_TIMESTAMP('2019-08-31 23:59:59');

select @start,@end;

SELECT UNIX_TIMESTAMP('2013-01-01 00:00:00') AS START, UNIX_TIMESTAMP('2013-01-31 23:59:59') AS end;

SELECT FROM_UNIXTIME(RAND() * (@end - @start) + @start) as the_date;





SELECT * from workdialog WHERE w_reservTime BETWEEN '2019-01-22' AND '2019-07-01-11-00';
/* 날자 혹은 시간만 검색 */
SELECT DATE_FORMAT("2016-04-08 11:12:14", '%Y-%m-%d') DATEONLY, DATE_FORMAT("2016-04-08 11:12:14",'%H:%i:%s') TIMEONLY;
select DATE_FORMAT("0000-00-00 08:00:00",'%k:%i:%s') DATEONLY, DATE_FORMAT("0000-00-00 10:00:00",'%k:%i:%s') TIMEONLY;

SELECT DATE_ADD(DATE_FORMAT("2016-04-08 11:12:14",'%H:%i:%s'), INTERVAL 3 hour);


/* 특정 날자 특정 시간 사이값만 출력 */
select * from workdialog where `w_reservTime` between '2019-01-01' and '2019-09-10';
select * from workdialog where `w_reservTime` between '2019-01-01' and '2019-09-13';
select * from workdialog where `w_reservTime` between '2019-01-01' and '2019-09-12 14:00';
select * from workdialog where `w_reservTime` between '2019-01-01' and '2019-09-12 10:00';



select * from workdialog where `w_reservTime` between 
DATE_FORMAT(concat(date_format(w_reservTime,'%Y-%m-%d'),"10:00:00"),'%k:%i:%s') and DATE_FORMAT(concat(date_format(w_reservTime,'%Y-%m-%d'),'%k:%i:%s');

select * from workdialog where `w_workTime` > DATE_ADD(NOW(),INTERVAL 1 hour);

select * from workdialog where `w_reservTime` between '2019-01-01' and '2019-09-14';

/* 특정날자 사이값중에  특정 시간 사이값만 출력 */
select * from workdialog where `w_reservTime` between '2019-01-01' and '2019-09-14'
and left(right(`w_reservTime`,8),2) between 8 and 21;

select * from workdialog;

insert into event (e_name, e_startday, e_endday, e_sale)
values("임시", '2019-06-30', '2019-07-15', 10);

SELECT g_name, w_workTime, p_name, p_price
FROM workdialog w
left join designer d
on w.w_d_no=d.d_no
left join choice c
on w.w_no=c.c_w_no
left join product p
on c.c_p_name=p.p_name
left join guest g
on w_g_no=g.g_no;


INSERT into choice
(c_w_no, c_p_name)
values
(1, '염색'),
(2, '커트'),
(3, '커트'),
(4, '파마'),
(5, '고오급염색'),
(7, '염색'),
(8, '파마'),
(9, '커트'),
(10, '염색'),
(11, '고오급파마')
;



select 
w_no as '번호', w_reservTime as '예약일시', d.d_name as '디자이너', d.d_grade as '직책', g.g_name as '손님명',
g.g_l_grade as '손님등급', p.p_name as '작업명', w_e_name as '이벤트', w_priceTotal as '가격', w_workTime as '완료일시'
from workdialog w
		left join designer d on w.w_d_no = d.d_no
		left join guest g on w.w_g_no = g.g_no
		left join event e on w.w_e_name = e.e_name
		left join level v on g.g_l_grade = v.l_grade
		left join choice c on w.w_no = c.c_w_no
		left join product p on c.c_p_name = p.p_name
		left join tax t on p.p_name = t.t_name
order by w_reservTime desc
;


w_no, w_reservTime, e_name, w_priceTotal, w_workTime, d_name, d_grade, g_name, l_grade, p_name;

select g_id, g_name, w_reservTime, w_priceTotal, d_name, d_grade, p_name, w_workTime
from workdialog w
left join designer d on w.w_d_no = d.d_no
left join guest g on w.w_g_no = g.g_no
left join event e on w.w_e_name = e.e_name
left join level v on g.g_l_grade = v.l_grade
left join choice c on w.w_no = c.c_w_no
left join product p on c.c_p_name = p.p_name
left join tax t on p.p_name = t.t_name
where g_id='a' and w_worktime is null
order by w_reservTime desc;






















select * from product where p_secession = '0' order by p_name;
select * from product;






SELECT *
		FROM workdialog w
		left join designer d
		on w.w_d_no=d.d_no
		left join event e
		on w.w_e_name=e.e_name
		left join choice c
		on w.w_no=c.c_w_no
		left join product p
		on c.c_p_name=p.p_name
		left join guest g
		on w_g_no=g.g_no
		where w.w_d_no=1;



select * from level;

select * from guest where g_name like '%김%';

select * from guest;

update guest
set g_l_grade='브론즈'
where g_id='ddd';



