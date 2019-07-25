
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


set @start=UNIX_TIMESTAMP('2019-07-01 00:00:00');
set @end=UNIX_TIMESTAMP('2019-08-31 23:59:59');
 
select @start;
select @start;

set @var="";
SELECT FROM_UNIXTIME(RAND() * (@end - @start) + @start);
SELECT FROM_UNIXTIME(RAND() * (select UNIX_TIMESTAMP(now()) - @start) + @start);
select if(FROM_UNIXTIME(@w_reservTime)>FROM_UNIXTIME(now()),1,0);
set @w_reservTime:=(SELECT FROM_UNIXTIME(RAND() * (@end - @start) + @start) as the_date);
select UNIX_TIMESTAMP(@w_reservTime);
select UNIX_TIMESTAMP(now());
select if(UNIX_TIMESTAMP(@w_reservTime) > UNIX_TIMESTAMP(now()), FROM_UNIXTIME(RAND() * (select UNIX_TIMESTAMP(now()) - @start) + @start),null);
select @w_reservTime,@w_workTime;

/* 랜덤 workDialog 삽입하기 */
INSERT INTO hairshop.workdialog
( `w_reservTime`,`w_workTime`, `w_priceTotal`, w_e_name, w_d_no, w_g_no)
values
(@w_reservTime:=(SELECT FROM_UNIXTIME(RAND() * (@end - @start) + @start) as the_date),
if(UNIX_TIMESTAMP(@w_reservTime) > UNIX_TIMESTAMP(now()), FROM_UNIXTIME(RAND() * (select UNIX_TIMESTAMP(now()) - @start) + @start),null),
10000,
(select e_name from event order by rand() limit 1),
(select d_no from designer order by rand() limit 1),
(select g_no from guest order by rand() limit 1))
;

delete from workdialog;
select * from workdialog;


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
and left(right(`w_reservTime`,8),2) between 8 and 22;





select * from workdialog;


