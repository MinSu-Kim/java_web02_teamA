
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

