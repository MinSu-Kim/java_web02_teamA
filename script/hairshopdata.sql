
use hairshop;

INSERT INTO hairshop.Level
(l_grade, l_sale)
values
('브론즈', 5),
('실버',10),
('골드',15);


INSERT INTO hairshop.event
(e_name, e_startDay, e_endDay, e_sale)
values
('생일', null,null, 10),
('광복절', '2019-8-15','2019-8-15',10 ),
('추석', '2019-9-12','2019-9-15', 10),
('크리스마스','2019-12-25','2019-12-25',10)
;

INSERT INTO hairshop.product
(p_name, p_price, p_division)
values
('커트', 10000, '미사용'),
('파마', 100000, '사용'),
('염색', 50000, '사용')
;


INSERT INTO hairshop.guest
(g_no, g_l_grade, g_name, g_tel, g_email, g_birth, g_join, g_point, g_memo)
values
(null, '골드', '김남호', '010-0000-0000', 'klr@naver.com', '1994-01-13', '2000-01-01', 0, null),
(null, '실버', '권영각', '010-0000-0000', 'klr@naver.com', '1994-01-13', '2000-01-01', 1000, null),
(null, '브론즈', '현종훈', '010-0000-0000', 'klr@naver.com', '1994-01-13', '2000-01-01', 2000, ''),
(null, '골드', '김다영', '010-0000-0000', 'klr@naver.com', '1994-01-13', '2000-01-01', 3000, '깐간합니다')
;

INSERT INTO hairshop.designer
(d_grade, d_name, d_tel, d_tel2, d_addr, d_addr2, d_addr3, d_birth, d_join, d_memo)
values
( '마스터', '차홍', '010-0000-0000', '053-000-0000', '151123', '대구광역시동구', '우방맨션 103동 301','2000-01-01', '2015-01-01','깐깐합니다'),
( '매니저', '김홍', '010-0000-0000', '053-000-0000', '151123', '대구광역시동구', '우방맨션 103동 302','2000-01-01', '2015-01-01','깐깐합니다'),
( '직원', '권홍', '010-0000-0000', '053-000-0000', '151123', '대구광역시동구', '우방맨션 103동 303','2000-01-01', '2015-01-01','깐깐합니다'),
( '직원', '현홍', '010-0000-0000', '053-000-0000', '151123', '대구광역시동구', '우방맨션 103동 304','2000-01-01', '2015-01-01','깐깐합니다')
;



INSERT INTO hairshop.tax
(t_name, t_price, t_date, t_p_name)
values
('월세', 500000, '2019-07-01', null),
('월급', 5000000, '2019-07-01', null),
('파마약', 50000, '2019-07-01', '파마')
;

delete from hairshop.workdialog;
INSERT INTO hairshop.workdialog
(w_wrokTime, w_reservTime, w_e_Name, w_d_No, w_g_No)
values
('2019-07-01', '2019-07-01-11-00', null, 1, 1),
(null, '2019-08-15-12-00', '광복절', 2, 2),
(null, '2019-09-12-13-00', '추석', 3, 2),
(null, '2019-09-15-14-00', '추석', 3, 2)
;



select * from guest;
select * from designer;
select * from event;
select * from level;
select * from product;
select * from tax;
select * from workdialog;

select * from designer;
select * from workdialog
where w_d_No=1 and
w_reservTime='2019-07-01'
;


	select 
		w_no,
		w_wrokTime,
		w_reservTime,
		w_e_name,
		w_d_no,
		w_g_no,
		g.g_no,
		g.g_name
		from workdialog w
		join guest g 
		on w.w_d_no=1 and w.w_g_no=g.g_no;

