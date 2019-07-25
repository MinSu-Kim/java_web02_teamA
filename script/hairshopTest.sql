
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

