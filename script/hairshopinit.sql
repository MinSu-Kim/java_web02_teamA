


-- ��
DROP SCHEMA IF EXISTS hairshop;

-- ��
CREATE SCHEMA hairshop;

-- ��ǰ
CREATE TABLE hairshop.Product (
	p_name     VARCHAR(20) NOT NULL COMMENT '�۾���', -- �۾���
	p_price    INT         NULL     COMMENT '����', -- ����
	p_division VARCHAR(10) NULL     COMMENT '�з�' -- �з�
)
COMMENT '��ǰ';

-- ��ǰ
ALTER TABLE hairshop.Product
	ADD CONSTRAINT PK_Product -- ��ǰ �⺻Ű
		PRIMARY KEY (
			p_name -- �۾���
		);

-- �۾�����
CREATE TABLE hairshop.WorkDialog (
	w_no         INT         NOT NULL COMMENT '������ȣ', -- ������ȣ
	w_wrokTime   DATE        NULL     COMMENT '�۾���¥', -- �۾���¥
	w_reservTime DATE        NULL     COMMENT '���೯¥', -- ���೯¥
	w_e_Name     VARCHAR(20) NULL     COMMENT '�̺�Ʈ��', -- �̺�Ʈ��
	w_d_No       INT         NULL     COMMENT '�����̳�', -- �����̳�
	w_c_No       INT         NULL     COMMENT '�մ�' -- �մ�
)
COMMENT '�۾�����';

-- �۾�����
ALTER TABLE hairshop.WorkDialog
	ADD CONSTRAINT PK_WorkDialog -- �۾����� �⺻Ű
		PRIMARY KEY (
			w_no -- ������ȣ
		);

ALTER TABLE hairshop.WorkDialog
	MODIFY COLUMN w_no INT NOT NULL AUTO_INCREMENT COMMENT '������ȣ';

-- �̺�Ʈ
CREATE TABLE hairshop.Event (
	e_name     VARCHAR(20) NOT NULL COMMENT '�ڵ����', -- �̺�Ʈ��
	e_startDay DATE        NULL     COMMENT '������', -- ������
	e_endDay   DATE        NULL     COMMENT '������', -- ������
	e_sale     INT         NULL     COMMENT '������' -- ������
)
COMMENT '�̺�Ʈ';

-- �̺�Ʈ
ALTER TABLE hairshop.Event
	ADD CONSTRAINT PK_Event -- �̺�Ʈ �⺻Ű
		PRIMARY KEY (
			e_name -- �̺�Ʈ��
		);

-- ������
CREATE TABLE hairshop.Tax (
	t_no     INT         NOT NULL COMMENT '�����ȣ', -- �����ȣ
	t_name   VARCHAR(20) NULL     COMMENT '�̸�', -- �̸�
	t_price  INT         NULL     COMMENT '����', -- ����
	t_date   DATE        NULL     COMMENT '��¥', -- ��¥
	t_p_name VARCHAR(20) NULL     COMMENT '�۾���' -- �۾���
)
COMMENT '������';

-- ������
ALTER TABLE hairshop.Tax
	ADD CONSTRAINT PK_Tax -- ������ �⺻Ű
		PRIMARY KEY (
			t_no -- �����ȣ
		);

ALTER TABLE hairshop.Tax
	MODIFY COLUMN t_no INT NOT NULL AUTO_INCREMENT COMMENT '�����ȣ';

-- �۾�����
CREATE TABLE hairshop.Choice (
	c_w_no   INT         NOT NULL COMMENT '������ȣ2', -- ������ȣ2
	c_p_name VARCHAR(20) NOT NULL COMMENT '�۾���' -- �۾���
)
COMMENT '�۾�����';

-- �۾�����
ALTER TABLE hairshop.Choice
	ADD CONSTRAINT PK_Choice -- �۾����� �⺻Ű
		PRIMARY KEY (
			c_w_no,   -- ������ȣ2
			c_p_name  -- �۾���
		);

-- �����̳�
CREATE TABLE hairshop.Designer (
	d_no    INT          NOT NULL COMMENT '��ȣ', -- ��ȣ
	d_grade VARCHAR(10)  NULL     COMMENT '��å', -- ��å
	d_name  VARCHAR(10)  NOT NULL COMMENT '�̸�', -- �̸�
	d_tel   VARCHAR(15)  NOT NULL COMMENT '����ó', -- ����ó
	d_tel2  VARCHAR(15)  NULL     COMMENT '��󿬶�', -- ��󿬶�
	d_addr  VARCHAR(10)  NULL     COMMENT '�����ȣ', -- �����ȣ
	d_addr2 VARCHAR(50)  NULL     COMMENT '�ּ�', -- �ּ�
	d_addr3 VARCHAR(50)  NULL     COMMENT '���ּ�', -- ���ּ�
	d_birth DATE         NULL     COMMENT '����', -- ����
	d_join  DATE         NULL     COMMENT '�Ի���', -- �Ի���
	d_memo  VARCHAR(100) NULL     COMMENT '�޸�' -- �޸�
)
COMMENT '�����̳�';

-- �����̳�
ALTER TABLE hairshop.Designer
	ADD CONSTRAINT PK_Designer -- �����̳� �⺻Ű
		PRIMARY KEY (
			d_no -- ��ȣ
		);

ALTER TABLE hairshop.Designer
	MODIFY COLUMN d_no INT NOT NULL AUTO_INCREMENT COMMENT '��ȣ';

-- �մ�
CREATE TABLE hairshop.Guest (
	g_no    INT          NOT NULL COMMENT '��ȣ', -- ��ȣ
	g_grade VARCHAR(10)  NULL     COMMENT '���', -- ���
	g_name  VARCHAR(10)  NULL     COMMENT '�̸�', -- �̸�
	g_tel   VARCHAR(15)  NULL     COMMENT '����ó', -- ����ó
	g_email VARCHAR(50)  NULL     COMMENT '�̸���', -- �̸���
	g_birth DATE         NULL     COMMENT '����', -- ����
	g_join  DATE         NULL     COMMENT '������', -- ������
	g_point INT          NULL     COMMENT '��������Ʈ', -- ��������Ʈ
	g_memo  VARCHAR(100) NULL     COMMENT '�޸�' -- �޸�
)
COMMENT '�մ�';

-- �մ�
ALTER TABLE hairshop.Guest
	ADD CONSTRAINT PK_Guest -- �մ� �⺻Ű
		PRIMARY KEY (
			g_no -- ��ȣ
		);

ALTER TABLE hairshop.Guest
	MODIFY COLUMN g_no INT NOT NULL AUTO_INCREMENT COMMENT '��ȣ';

-- ���
CREATE TABLE hairshop.Grade (
	g_grade VARCHAR(10) NOT NULL COMMENT '���', -- ���
	g_sale  INT         NULL     COMMENT '������' -- ������
)
COMMENT '���';

-- ���
ALTER TABLE hairshop.Grade
	ADD CONSTRAINT PK_Grade -- ��� �⺻Ű
		PRIMARY KEY (
			g_grade -- ���
		);

-- �۾�����
ALTER TABLE hairshop.WorkDialog
	ADD CONSTRAINT FK_Event_TO_WorkDialog -- �̺�Ʈ -> �۾�����
		FOREIGN KEY (
			w_e_Name -- �̺�Ʈ��
		)
		REFERENCES hairshop.Event ( -- �̺�Ʈ
			e_name -- �̺�Ʈ��
		);

-- �۾�����
ALTER TABLE hairshop.WorkDialog
	ADD CONSTRAINT FK_Designer_TO_WorkDialog -- �����̳� -> �۾�����
		FOREIGN KEY (
			w_d_No -- �����̳�
		)
		REFERENCES hairshop.Designer ( -- �����̳�
			d_no -- ��ȣ
		);

-- �۾�����
ALTER TABLE hairshop.WorkDialog
	ADD CONSTRAINT FK_Guest_TO_WorkDialog -- �մ� -> �۾�����
		FOREIGN KEY (
			w_c_No -- �մ�
		)
		REFERENCES hairshop.Guest ( -- �մ�
			g_no -- ��ȣ
		);

-- ������
ALTER TABLE hairshop.Tax
	ADD CONSTRAINT FK_Product_TO_Tax -- ��ǰ -> ������
		FOREIGN KEY (
			t_p_name -- �۾���
		)
		REFERENCES hairshop.Product ( -- ��ǰ
			p_name -- �۾���
		);

-- �۾�����
ALTER TABLE hairshop.Choice
	ADD CONSTRAINT FK_WorkDialog_TO_Choice -- �۾����� -> �۾�����
		FOREIGN KEY (
			c_w_no -- ������ȣ2
		)
		REFERENCES hairshop.WorkDialog ( -- �۾�����
			w_no -- ������ȣ
		);

-- �۾�����
ALTER TABLE hairshop.Choice
	ADD CONSTRAINT FK_Product_TO_Choice -- ��ǰ -> �۾�����
		FOREIGN KEY (
			c_p_name -- �۾���
		)
		REFERENCES hairshop.Product ( -- ��ǰ
			p_name -- �۾���
		);

-- �մ�
ALTER TABLE hairshop.Guest
	ADD CONSTRAINT FK_Grade_TO_Guest -- ��� -> �մ�
		FOREIGN KEY (
			g_grade -- ���
		)
		REFERENCES hairshop.Grade ( -- ���
			g_grade -- ���
		);
	
