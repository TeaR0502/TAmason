--���Ӹ�ϵͳ���û�����Ȩ
CREATE USER TAmason IDENTIFIED BY 123456;
GRANT CONNECT,RESOURCE TO TAmason;
--�л������û�
CONN TAmason/123456;
--��������Ҫ������
CREATE SEQUENCE SEQ_USER_ID INCREMENT BY 1 START WITH 1000;
CREATE SEQUENCE SEQ_COMMENT_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_NEWS_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ORDER_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_PRODUCT_CATEGORY_ID INCREMENT BY 100 START WITH 1;
CREATE SEQUENCE SEQ_PRODUCT_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_DETAIL_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_CART_ID INCREMENT BY 1 START WITH 1;

--�����û���
create table TUSER
(
  ID            NUMBER(10) CONSTRAINT TUSER_ID_PK  PRIMARY KEY,--�û�id
  USERNAME      VARCHAR2(20) not null,--�û���
  PASSWORD      VARCHAR2(20) not null,-- ����
  SEX           VARCHAR2(4) not null,--�Ա�
  BIRTHDAY      DATE,--����
  IDENTITY_CODE VARCHAR2(60),--��֤��
  EMAIL         VARCHAR2(80),--����
  MOBILE        VARCHAR2(11),--�ֻ�
  ADDRESS       VARCHAR2(200) not null,--��ַ
  STATUS        NUMBER(6) not null--״̬
)

--�������۱�
create table TCOMMENT
(
  ID          NUMBER(10) CONSTRAINT TCOMMENT_ID_PK  PRIMARY KEY,--����id
  REPLY       VARCHAR2(200),--�ظ�
  CONTENT     VARCHAR2(200) not null,--����
  CREATE_TIME DATE not null,--����ʱ��
  NICK_NAME   VARCHAR2(50) not null--�ǳ�
)
--�������ű�
create table TNEWS
(
  ID          NUMBER(10)  CONSTRAINT TNEWS_ID_PK   PRIMARY KEY,--����id
  TITLE       VARCHAR2(80) not null,--����
  CONTENT     VARCHAR2(1000) not null,--����
  CREATE_TIME DATE not null--����ʱ��
)
--������
create table TORDER
(
  ID           NUMBER(10)   CONSTRAINT TORDER_ID_PK  PRIMARY KEY,--����id
  USER_ID      NUMBER(10),--�û�ID
  USER_NAME    VARCHAR2(50) not null,--�û���
  USER_ADDRESS VARCHAR2(200) not null,--�û���ַ
  CREATE_TIME  DATE not null,--����ʱ��
  COST         NUMBER(10,2) not null,--�������
  STATUS       NUMBER(6) not null,--����״̬
  ORDER_TYPE   NUMBER(6) not null,--????
  constraint USER_ID_FK foreign key(USER_ID) references TUSER(ID)
)
--��Ʒ����
create table TPRODUCT_CATEGORY
(
  ID        NUMBER(10)   CONSTRAINT TPRODUCT_CATEGORY_ID_PK   PRIMARY KEY,--��Ʒ���id
  NAME      VARCHAR2(50) not null,--��Ʒ�������
  PARENT_ID NUMBER(10) not null--����ID,���Ϊ0��Ϊ��Ŀ¼
)
--��Ʒ��
create table TPRODUCT
(
  ID          NUMBER(10)   CONSTRAINT TPRODUCT_ID_PK  PRIMARY KEY,--��Ʒid
  NAME        VARCHAR2(50) not null,--��Ʒ����
  DESCRIPTION VARCHAR2(100),--��Ʒ����
  PRICE       NUMBER(10,2) not null,--�۸�
  STOCK       NUMBER(10) not null,--���
  PARENT_ID   NUMBER(10) ,--����ID
  CHILD_ID    NUMBER(10) ,--����ID
  PICTUREFILE_NAME   VARCHAR2(200) not null,--ͼƬ
  constraint PARENT_ID_ID_FK foreign key (PARENT_ID) references TPRODUCT_CATEGORY (ID),
  constraint CHILD_ID_FK foreign key (CHILD_ID) references TPRODUCT_CATEGORY (ID)
)
--���������
create table ORDER_DETAIL
(
  ID       NUMBER(10)  CONSTRAINT ORDER_DETAIL_ID_PK PRIMARY KEY,--����������
  ORDER_ID        NUMBER(10),--�������
  PRODUCT_ID        NUMBER(10),--��Ʒ���
  QUANTITY NUMBER(10) not null,--��Ʒ����
  COST     NUMBER(10,2) not null,--�ܽ��
  constraint ORDER_ID_FK foreign key (ORDER_ID) references TORDER(ID),
  constraint PRODUCT_ID_FK foreign key (PRODUCT_ID) references TPRODUCT(ID)
)
--���ﳵ
CREATE TABLE CART 
   (ID NUMBER(10) CONSTRAINT CART_ID_PK PRIMARY KEY, --���ﳵid
	PRODUCT_ID NUMBER(10), --��ƷID
	QUANTITY NUMBER(10), --��Ʒ����
	USERID NUMBER(10)--�û�ID
   )

 --�����û����������
insert into TUSER values (SEQ_USER_ID.NEXTVAL, '����', '1234', 'Ů', to_date('02-07-1989', 'dd-mm-yyyy'), '500235198907026299', 'sa@sina.com', '13011092066', '����', 1);
insert into TUSER values (SEQ_USER_ID.NEXTVAL, '����', '1234', '��', to_date('02-07-1988', 'dd-mm-yyyy'), '500235198907026299', 'sa@sina.com', '13011092066', '����', 1);
insert into TUSER values (SEQ_USER_ID.NEXTVAL, '���ǳ�', '1234', '��', to_date('02-09-1990', 'dd-mm-yyyy'), '123123123123123', 'web@sohu.com', '12312312312', '����', 1);
insert into TUSER values (SEQ_USER_ID.NEXTVAL, '����', '1234', 'Ů', to_date('02-07-1988', 'dd-mm-yyyy'), '500235198907026299', 'sa@sina.com', '13011092066', '����', 1);
insert into TUSER values (SEQ_USER_ID.NEXTVAL, 'admin', '1234', 'Ů', to_date('02-07-1988', 'dd-mm-yyyy'), '12345678912345612X', 'sa@sina.com', '13011092066', '�Ϻ�', 1);

--������������
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '���¿�ʼǱ�', 'i7��ǿ���ã��Ͽ�������!', to_date('08-03-2012 20:56:57', 'dd-mm-yyyy hh24:mi:ss'), '����');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '�Ź�����', '�Ź��������������Ź�', to_date('08-03-2012 20:56:57','dd-mm-yyyy hh24:mi:ss'),'����');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '��Ա�ػ��¿�ʼ', '���ִ�����������ʧʧ������!', to_date('08-03-2012 20:56:57', 'dd-mm-yyyy hh24:mi:ss'),'��Ա');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '�����Ա��Ӯǧ������', '���ǻ�Ա�ҿ�������������', to_date('09-03-2012 16:49:14', 'dd-mm-yyyy hh24:mi:ss'),'������');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, 'Ӯ˫����������', 'Ԫ��ʥ�������������������', to_date('09-03-2012 16:50:17', 'dd-mm-yyyy hh24:mi:ss'), '˫��',);
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '���겻ҹ�ģ�ͨ��Ҳ�ǿ�����', '���겻ҹ�ģ�ͨ��Ҳ�ǿ�����', to_date('09-03-2012 16:53:11', 'dd-mm-yyyy hh24:mi:ss'),'����');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '���ֶһ���ʼ��', '���ֶһ���ʼ�˻��ֶһ���ʼ�˻��ֶһ���ʼ��',to_date('09-03-2012 16:55:50', 'dd-mm-yyyy hh24:mi:ss'),'�һ�');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '���֪ͨ', '��ʼ�����ʼ�����ʼ�����ʼ���!',to_date('10-03-2012 16:56:50', 'dd-mm-yyyy hh24:mi:ss'),'���');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '�Ź�����1����', '�Ź�����1�����Ź�����1�����Ź�����1����!',to_date('10-03-2012 16:54:11', 'dd-mm-yyyy hh24:mi:ss'),'�Ź�');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '����', '��ʲ��', to_date('21-03-2012 09:22:04', 'dd-mm-yyyy hh24:mi:ss'),'�ɷ�');

--��������
insert into TNEWS values (SEQ_NEWS_ID.nextval, '��Ա�ػ��¿�ʼ', '���ִ�����������ʧʧ������!', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into TNEWS values (SEQ_NEWS_ID.nextval, '�����Ա��Ӯǧ������', '���ǻ�Ա�ҿ�������������', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into TNEWS values (SEQ_NEWS_ID.nextval, '���ֶһ���ʼ��', '���ֶһ���ʼ�˻��ֶһ���ʼ�˻��ֶһ���ʼ��', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into TNEWS values (SEQ_NEWS_ID.nextval, '���֪ͨ', '��ʼ�����ʼ�����ʼ�����ʼ���!', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into TNEWS values (SEQ_NEWS_ID.nextval, '�Ź�����1����', '�Ź�����1�����Ź�����1�����Ź�����1����', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into TNEWS values (SEQ_NEWS_ID.nextval, '��Դ��֭��˦��', '˦��˦��˦��˦��˦��˦��', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into TNEWS values (SEQ_NEWS_ID.nextval, 'ƻ���ֻ���ҪǮ', '��Ҫ��ҪǮ��ҪǮ��ҪǮ��ҪǮ', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));

--���붩����Ϣ
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1004', 'admin', '����', to_date('19-03-2012 11:18:52', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '����', '����', to_date('20-03-2012 23:25:31', 'dd-mm-yyyy hh24:mi:ss'), 22191, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1001', '����', '����', to_date('19-03-2012 11:18:53', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '����', '����', to_date('19-03-2012 11:18:54', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '����', '����', to_date('19-03-2012 11:18:55', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '����', '����', to_date('19-03-2012 11:18:55', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '����', '����', to_date('19-03-2012 11:18:56', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '����', '����', to_date('19-03-2012 11:18:57', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '����', '����', to_date('19-03-2012 11:18:58', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '����', '����', to_date('19-03-2012 11:18:59', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);


--�����Ʒ������Ϣ
insert into TPRODUCT_CATEGORY values (19, '����', 2);
insert into TPRODUCT_CATEGORY values (21, 'Ʒ��', 0);
insert into TPRODUCT_CATEGORY values (22, '�Ź�', 0);
insert into TPRODUCT_CATEGORY values (1, 'ͼ��', 0);
insert into TPRODUCT_CATEGORY values (2, '�ٻ�', 0);
insert into TPRODUCT_CATEGORY values (28, 'qq', 1);
insert into TPRODUCT_CATEGORY values (7, '�Ҿ�', 2);
insert into TPRODUCT_CATEGORY values (8, '��ױ', 22);
insert into TPRODUCT_CATEGORY values (9, 'ĸӤ', 2);
insert into TPRODUCT_CATEGORY values (10, 'ʳƷ', 2);
insert into TPRODUCT_CATEGORY values (11, '�ֻ�����', 2);
insert into TPRODUCT_CATEGORY values (12, '�Ҿ�����', 2);
insert into TPRODUCT_CATEGORY values (13, '�ֱ���Ʒ', 2);
insert into TPRODUCT_CATEGORY values (14, 'Ь��', 21);
insert into TPRODUCT_CATEGORY values (15, '�ҵ�', 2);
insert into TPRODUCT_CATEGORY values (16, '���԰칫', 2);
insert into TPRODUCT_CATEGORY values (17, '����ľ�', 21);
insert into TPRODUCT_CATEGORY values (18, '������Ʒ', 21);
insert into TPRODUCT_CATEGORY values (20, '��Ʊ��ֵ', 2);
insert into TPRODUCT_CATEGORY values (4, '����', 1);
insert into TPRODUCT_CATEGORY values (5, '�˶�����', 0);
insert into TPRODUCT_CATEGORY values (23, '��������', 0);

--�����Ʒ��Ϣ
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�ֿ���ͨ�ͱ��ʺ�ʥ��7����', 'ʥ��7����', 69, 2000, 2, 7, 'images/product/2.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'ŷ�������Ᵽʪ�ļ���', '���Ᵽʪ�ļ���', 279, 50, 2, 8, 'images/product/3.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����ʼǱ����� ���ٶ����Դ�', '���ٶ����Դ� I7������', 4199, 50, 2, 16, 'images/product/4.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�·�˿�ɿ���', '108.00', 100, 111, 1, 4, 'images/product/1.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'Genius925����ʩ��������ˮ����׹', '��������ˮ����׹', 69, 50, 2, 12, 'images/product/6.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����2018M�����õ���� ����ʵ��', '�����õ���� ����ʵ��', 268, 50, 2, 15, 'images/product/7.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '���ɸߵ�������20�� �����ʽ', '�ߵ�������20�� �����ʽ', 198, 50, 2, 14, 'images/product/8.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '������MP4 ȫ���������ʽ���� 4G', 'ȫ���������ʽ���� 4G', 289, 50, 2, 11, 'images/product/0.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�����̽�װ���3�׶��׶��䷽�̷�', '���3�׶��׶��䷽�̷�', 186, 50, 1, 10, 'images/product/10.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�·�˿�ɿ���', '�ɿ���500g/��', 108, 100, 1, 10, 'images/product/1.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�ֿ���ͨ�ͱ��ʺ�ʥ��7����', 'ʥ��7����', 69, 2000, 2, 7, 'images/product/2.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'ŷ�������Ᵽʪ�ļ���', '���Ᵽʪ�ļ���', 279, 50, 2, 8, 'images/product/3.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����ʼǱ����� ���ٶ����Դ�', '���ٶ����Դ� I7������', 4199, 50, 2, 16, 'images/product/4.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '��ɫ����', 199, 100, 2, 19, 'images/product/clothes2.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'Genius925����ʩ��������ˮ����׹', '��������ˮ����׹', 69, 50, 2, 12, 'images/product/6.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����2018M�����õ���� ����ʵ��', '�����õ���� ����ʵ��', 268, 50, 2, 15, 'images/product/7.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '���ɸߵ�������20�� �����ʽ', '�ߵ�������20�� �����ʽ', 198, 50, 2, 14, 'images/product/8.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '������MP4 ȫ���������ʽ���� 4G', 'ȫ���������ʽ���� 4G', 289, 50, 2, 11, 'images/product/0.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�����̽�װ���3�׶��׶��䷽�̷�', '���3�׶��׶��䷽�̷�', 186, 50, 1, 10, 'images/product/10.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '�п�', 99, 100, 2, 19, 'images/product/clothes3.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '��ɫ����', 96, 100, 2, 19, 'images/product/clothes5.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '��ɫ����', 299, 100, 2, 19, 'images/product/clothes6.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '��ɫ����', 199, 100, 2, 19, 'images/product/clothes7.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '��ɫ����', 599, 100, 2, 19, 'images/product/clothes8.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '��ɫ����', 399, 100, 2, 19, 'images/product/clothes9.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', 'ǳ��ɫ����', 499, 100, 2, 19, 'images/product/clothes10.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '��ɫ����', 68, 100, 2, 19, 'images/product/clothes4.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'ƤЬ', '��ɫƤЬ', 299, 100, 21, 14, 'images/product/shoes1.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'ƤЬ', '��ɫƤЬ', 299, 100, 21, 14, 'images/product/shoes2.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'ƤЬ', '��ɫƤЬ', 299, 100, 21, 14, 'images/product/shoes3.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'ƤЬ', '��ɫƤЬ', 299, 100, 21, 14, 'images/product/shoes4.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'ƤЬ', '��ɫƤЬ', 299, 100, 21, 14, 'images/product/shoes5.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'ƤЬ', '��ɫƤЬ', 299, 100, 21, 14, 'images/product/shoes6.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'ƤЬ', '��ɫƤЬ', 299, 100, 21, 14, 'images/product/shoes7.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'ƤЬ', '��ɫƤЬ', 299, 100, 21, 14, 'images/product/shoes8.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'ƤЬ', '��ɫƤЬ', 299, 100, 21, 14, 'images/product/shoes9.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'ƤЬ', '��ɫƤЬ', 299, 100, 21, 14, 'images/product/shoes10.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�۾�', '̫����', 299, 100, 2, 12, 'images/product/sunglass1.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�۾�', '̫����', 299, 100, 2, 12, 'images/product/sunglass2.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�۾�', '̫����', 299, 100, 2, 12, 'images/product/sunglass3.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�۾�', '̫����', 299, 100, 2, 12, 'images/product/sunglass4.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�۾�', '̫����', 299, 100, 2, 12, 'images/product/sunglass5.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�۾�', '̫����', 299, 100, 2, 12, 'images/product/sunglass6.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�۾�', '̫����', 299, 100, 2, 12, 'images/product/sunglass7.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�۾�', '̫����', 299, 100, 2, 12, 'images/product/sunglass8.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�۾�', '̫����', 299, 100, 2, 12, 'images/product/sunglass9.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '�۾�', '̫����', 299, 100, 2, 12, 'images/product/sunglass10.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '�ʵ�', 1299, 100, 2, 15, 'images/product/television1.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '�ʵ�', 1299, 100, 2, 15, 'images/product/television2.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '�ʵ�', 2299, 100, 2, 15, 'images/products/television3.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '�ʵ�', 2299, 100, 2, 15, 'images/product/television4.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '�ʵ�', 3299, 100, 2, 15, 'images/product/television5.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '�ʵ�', 2299, 100, 2, 15, 'images/product/television6.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '�ʵ�', 4299, 100, 2, 15, 'images/product/television7.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '�ʵ�', 5299, 100, 2, 15, 'images/product/television8.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '�ʵ�', 2299, 100, 2, 15, 'images/product/television9.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '����', '�ʵ�', 6299, 100, 2, 15, 'images/product/television10.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '������', '��֤��İ���', 22122, 100, 2, 13, 'images/product/20.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '������', '��֤��İ���', 22122, 100, 22, 22, 'images/product/20.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '˫ɫ��', '����', 2, 1000, 2, 20, 'images/product/21.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '���ν��', '��Ʒ�', 222, 1000, 21, 17, 'images/product/23.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'GPS', '������', 2222, 1000, 21, 18, 'images/product/24.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '123', null, 100, 111, 2, 9, 'images\product\133214492473826.jpg');
