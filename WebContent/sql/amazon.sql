--增加该系统的用户并授权
CREATE USER TAmason IDENTIFIED BY 123456;
GRANT CONNECT,RESOURCE TO TAmason;
--切换到该用户
CONN TAmason/123456;
--增加所需要的序列
CREATE SEQUENCE SEQ_USER_ID INCREMENT BY 1 START WITH 1000;
CREATE SEQUENCE SEQ_COMMENT_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_NEWS_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ORDER_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_PRODUCT_CATEGORY_ID INCREMENT BY 100 START WITH 1;
CREATE SEQUENCE SEQ_PRODUCT_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_DETAIL_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_CART_ID INCREMENT BY 1 START WITH 1;

--创建用户表
create table TUSER
(
  ID            NUMBER(10) CONSTRAINT TUSER_ID_PK  PRIMARY KEY,--用户id
  USERNAME      VARCHAR2(20) not null,--用户名
  PASSWORD      VARCHAR2(20) not null,-- 密码
  SEX           VARCHAR2(4) not null,--性别
  BIRTHDAY      DATE,--生日
  IDENTITY_CODE VARCHAR2(60),--验证码
  EMAIL         VARCHAR2(80),--邮箱
  MOBILE        VARCHAR2(11),--手机
  ADDRESS       VARCHAR2(200) not null,--地址
  STATUS        NUMBER(6) not null--状态
);

--创建评论表
create table TCOMMENT
(
  ID          NUMBER(10) CONSTRAINT TCOMMENT_ID_PK  PRIMARY KEY,--评论id
  REPLY       VARCHAR2(200),--回复
  CONTENT     VARCHAR2(200) not null,--评论
  CREATE_TIME DATE not null,--评论时间
  NICK_NAME   VARCHAR2(50) not null--昵称
);
--创建新闻表
create table TNEWS
(
  ID          NUMBER(10)  CONSTRAINT TNEWS_ID_PK   PRIMARY KEY,--新闻id
  TITLE       VARCHAR2(80) not null,--标题
  CONTENT     VARCHAR2(1000) not null,--内容
  CREATE_TIME DATE not null--增加时间
);
--订单表
create table TORDER
(
  ID           NUMBER(10)   CONSTRAINT TORDER_ID_PK  PRIMARY KEY,--订单id
  USER_ID      NUMBER(10),--用户ID
  USER_NAME    VARCHAR2(50) not null,--用户名
  USER_ADDRESS VARCHAR2(200) not null,--用户地址
  CREATE_TIME  DATE not null,--增加时间
  COST         NUMBER(10,2) not null,--东单金额
  STATUS       NUMBER(6) not null,--订单状态
  ORDER_TYPE   NUMBER(6) not null,--????
  constraint USER_ID_FK foreign key(USER_ID) references TUSER(ID)
);
--商品类别表
create table TPRODUCT_CATEGORY
(
  ID        NUMBER(10)   CONSTRAINT TPRODUCT_CATEGORY_ID_PK   PRIMARY KEY,--商品类别id
  NAME      VARCHAR2(50) not null,--商品类别名称
  PARENT_ID NUMBER(10) not null--父类ID,如果为0则为根目录
);
--商品表
create table TPRODUCT
(
  ID          NUMBER(10)   CONSTRAINT TPRODUCT_ID_PK  PRIMARY KEY,--商品id
  NAME        VARCHAR2(50) not null,--商品名称
  DESCRIPTION VARCHAR2(100),--商品描述
  PRICE       NUMBER(10,2) not null,--价格
  STOCK       NUMBER(10) not null,--库存
  PARENT_ID   NUMBER(10) ,--父类ID
  CHILD_ID    NUMBER(10) ,--子类ID
  PICTUREFILE_NAME   VARCHAR2(200) not null,--图片
  constraint PARENT_ID_ID_FK foreign key (PARENT_ID) references TPRODUCT_CATEGORY (ID),
  constraint CHILD_ID_FK foreign key (CHILD_ID) references TPRODUCT_CATEGORY (ID)
);
--订单详情表
create table ORDER_DETAIL
(
  ID       NUMBER(10)  CONSTRAINT ORDER_DETAIL_ID_PK PRIMARY KEY,--订单详情编号
  ORDER_ID        NUMBER(10),--订单编号
  PRODUCT_ID        NUMBER(10),--商品编号
  QUANTITY NUMBER(10) not null,--商品数量
  COST     NUMBER(10,2) not null,--总金额
  constraint ORDER_ID_FK foreign key (ORDER_ID) references TORDER(ID),
  constraint PRODUCT_ID_FK foreign key (PRODUCT_ID) references TPRODUCT(ID)
);
--购物车
CREATE TABLE CART 
   (ID NUMBER(10) CONSTRAINT CART_ID_PK PRIMARY KEY, --购物车id
	PRODUCT_ID NUMBER(10), --商品ID
	QUANTITY NUMBER(10), --商品数量
	USERID NUMBER(10)--用户ID
   );

 --插入用户表测试数据
insert into TUSER values (SEQ_USER_ID.NEXTVAL, '朱琦', '1234', '女', to_date('02-07-1989', 'dd-mm-yyyy'), '500235198907026299', 'sa@sina.com', '13011092066', '重庆', 1);
insert into TUSER values (SEQ_USER_ID.NEXTVAL, '朱琅', '1234', '男', to_date('02-07-1988', 'dd-mm-yyyy'), '500235198907026299', 'sa@sina.com', '13011092066', '重庆', 1);
insert into TUSER values (SEQ_USER_ID.NEXTVAL, '刁星辰', '1234', '男', to_date('02-09-1990', 'dd-mm-yyyy'), '123123123123123', 'web@sohu.com', '12312312312', '东北', 1);
insert into TUSER values (SEQ_USER_ID.NEXTVAL, '刘博', '1234', '女', to_date('02-07-1988', 'dd-mm-yyyy'), '500235198907026299', 'sa@sina.com', '13011092066', '北京', 1);
insert into TUSER values (SEQ_USER_ID.NEXTVAL, 'admin', '1234', '女', to_date('02-07-1988', 'dd-mm-yyyy'), '12345678912345612X', 'sa@sina.com', '13011092066', '上海', 1);

--插入评论数据
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '最新酷睿笔记本', 'i7超强配置，赶快下手啦!', to_date('08-03-2012 20:56:57', 'dd-mm-yyyy hh24:mi:ss'), '天天');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '团购无忧', '团购上拉手拉手上团购', to_date('08-03-2012 20:56:57','dd-mm-yyyy hh24:mi:ss'),'拉手');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '会员特惠月开始', '积分大返利，机不可失失不再来!', to_date('08-03-2012 20:56:57', 'dd-mm-yyyy hh24:mi:ss'),'会员');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '加入会员，赢千万大礼包', '我是会员我快乐啦啦啦啦啦', to_date('09-03-2012 16:49:14', 'dd-mm-yyyy hh24:mi:ss'),'我是神');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '赢双旦促销大酬宾', '元旦圣诞超级大礼包等你拿啦', to_date('09-03-2012 16:50:17', 'dd-mm-yyyy hh24:mi:ss'), '双蛋',);
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '新年不夜夏，通宵也是开张啦', '新年不夜夏，通宵也是开张啦', to_date('09-03-2012 16:53:11', 'dd-mm-yyyy hh24:mi:ss'),'新年');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '积分兑换开始了', '积分兑换开始了积分兑换开始了积分兑换开始了',to_date('09-03-2012 16:55:50', 'dd-mm-yyyy hh24:mi:ss'),'兑换');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '配货通知', '开始配货开始配货开始配货开始配货!',to_date('10-03-2012 16:56:50', 'dd-mm-yyyy hh24:mi:ss'),'配货');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '团购阿迪1折起', '团购阿迪1折起团购阿迪1折起团购阿迪1折起!',to_date('10-03-2012 16:54:11', 'dd-mm-yyyy hh24:mi:ss'),'团购');
insert into TCOMMENT values (SEQ_COMMENT_ID.NEXTVAL, '方便', '阿什顿', to_date('21-03-2012 09:22:04', 'dd-mm-yyyy hh24:mi:ss'),'飞飞');

--插入新闻
insert into TNEWS values (SEQ_NEWS_ID.nextval, '会员特惠月开始', '积分大返利，机不可失失不再来!', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into TNEWS values (SEQ_NEWS_ID.nextval, '加入会员，赢千万大礼包', '我是会员我快乐啦啦啦啦啦', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into TNEWS values (SEQ_NEWS_ID.nextval, '积分兑换开始了', '积分兑换开始了积分兑换开始了积分兑换开始了', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into TNEWS values (SEQ_NEWS_ID.nextval, '配货通知', '开始配货开始配货开始配货开始配货!', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into TNEWS values (SEQ_NEWS_ID.nextval, '团购阿迪1折起', '团购阿迪1折起团购阿迪1折起团购阿迪1折起！', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into TNEWS values (SEQ_NEWS_ID.nextval, '汇源果汁大甩卖', '甩卖甩卖甩卖甩卖甩卖甩卖', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into TNEWS values (SEQ_NEWS_ID.nextval, '苹果手机不要钱', '不要不要钱不要钱不要钱不要钱', to_date('08-03-2012 20:56:52', 'dd-mm-yyyy hh24:mi:ss'));

--插入订单信息
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1004', 'admin', '重庆', to_date('19-03-2012 11:18:52', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '朱琦', '重庆', to_date('20-03-2012 23:25:31', 'dd-mm-yyyy hh24:mi:ss'), 22191, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1001', '朱琅', '重庆', to_date('19-03-2012 11:18:53', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '朱琦', '重庆', to_date('19-03-2012 11:18:54', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '朱琦', '重庆', to_date('19-03-2012 11:18:55', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '朱琦', '重庆', to_date('19-03-2012 11:18:55', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '朱琦', '重庆', to_date('19-03-2012 11:18:56', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '朱琦', '重庆', to_date('19-03-2012 11:18:57', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '朱琦', '重庆', to_date('19-03-2012 11:18:58', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);
insert into TORDER values (SEQ_ORDER_ID.NEXTVAL, '1000', '朱琦', '重庆', to_date('19-03-2012 11:18:59', 'dd-mm-yyyy hh24:mi:ss'), 100, 1, 1);


--插入产品分类信息
insert into TPRODUCT_CATEGORY values (19, '服饰', 2);
insert into TPRODUCT_CATEGORY values (21, '品牌', 0);
insert into TPRODUCT_CATEGORY values (22, '团购', 0);
insert into TPRODUCT_CATEGORY values (1, '图音', 0);
insert into TPRODUCT_CATEGORY values (2, '百货', 0);
insert into TPRODUCT_CATEGORY values (28, 'qq', 1);
insert into TPRODUCT_CATEGORY values (7, '家居', 2);
insert into TPRODUCT_CATEGORY values (8, '美妆', 22);
insert into TPRODUCT_CATEGORY values (9, '母婴', 2);
insert into TPRODUCT_CATEGORY values (10, '食品', 2);
insert into TPRODUCT_CATEGORY values (11, '手机数码', 2);
insert into TPRODUCT_CATEGORY values (12, '家居首饰', 2);
insert into TPRODUCT_CATEGORY values (13, '手表饰品', 2);
insert into TPRODUCT_CATEGORY values (14, '鞋包', 21);
insert into TPRODUCT_CATEGORY values (15, '家电', 2);
insert into TPRODUCT_CATEGORY values (16, '电脑办公', 2);
insert into TPRODUCT_CATEGORY values (17, '玩具文具', 21);
insert into TPRODUCT_CATEGORY values (18, '汽车用品', 21);
insert into TPRODUCT_CATEGORY values (20, '彩票充值', 2);
insert into TPRODUCT_CATEGORY values (4, '音乐', 1);
insert into TPRODUCT_CATEGORY values (5, '运动健康', 0);
insert into TPRODUCT_CATEGORY values (23, '易买社区', 0);

--插入产品信息
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '乐扣普通型保鲜盒圣诞7件套', '圣诞7件套', 69, 2000, 2, 7, 'images/product/2.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '欧珀莱均衡保湿四件套', '均衡保湿四件套', 279, 50, 2, 8, 'images/product/3.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '联想笔记本电脑 高速独立显存', '高速独立显存 I7处理器', 4199, 50, 2, 16, 'images/product/4.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '德菲丝巧克力', '108.00', 100, 111, 1, 4, 'images/product/1.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'Genius925纯银施华洛世奇水晶吊坠', '华洛世奇水晶吊坠', 69, 50, 2, 12, 'images/product/6.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '利仁2018M福满堂电饼铛 好用实惠', '福满堂电饼铛 好用实惠', 268, 50, 2, 15, 'images/product/7.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '达派高档拉杆箱20寸 经典款式', '高档拉杆箱20寸 经典款式', 198, 50, 2, 14, 'images/product/8.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '爱国者MP4 全屏触摸多格式播放 4G', '全屏触摸多格式播放 4G', 289, 50, 2, 11, 'images/product/0.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '多美滋金装金盾3阶段幼儿配方奶粉', '金盾3阶段幼儿配方奶粉', 186, 50, 1, 10, 'images/product/10.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '德菲丝巧克力', '巧克力500g/盒', 108, 100, 1, 10, 'images/product/1.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '乐扣普通型保鲜盒圣诞7件套', '圣诞7件套', 69, 2000, 2, 7, 'images/product/2.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '欧珀莱均衡保湿四件套', '均衡保湿四件套', 279, 50, 2, 8, 'images/product/3.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '联想笔记本电脑 高速独立显存', '高速独立显存 I7处理器', 4199, 50, 2, 16, 'images/product/4.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '上衣', '红色上衣', 199, 100, 2, 19, 'images/product/clothes2.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'Genius925纯银施华洛世奇水晶吊坠', '华洛世奇水晶吊坠', 69, 50, 2, 12, 'images/product/6.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '利仁2018M福满堂电饼铛 好用实惠', '福满堂电饼铛 好用实惠', 268, 50, 2, 15, 'images/product/7.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '达派高档拉杆箱20寸 经典款式', '高档拉杆箱20寸 经典款式', 198, 50, 2, 14, 'images/product/8.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '爱国者MP4 全屏触摸多格式播放 4G', '全屏触摸多格式播放 4G', 289, 50, 2, 11, 'images/product/0.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '多美滋金装金盾3阶段幼儿配方奶粉', '金盾3阶段幼儿配方奶粉', 186, 50, 1, 10, 'images/product/10.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '上衣', '夹克', 99, 100, 2, 19, 'images/product/clothes3.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '上衣', '粉色上衣', 96, 100, 2, 19, 'images/product/clothes5.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '上衣', '灰色上衣', 299, 100, 2, 19, 'images/product/clothes6.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '上衣', '红色上衣', 199, 100, 2, 19, 'images/product/clothes7.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '上衣', '银色上衣', 599, 100, 2, 19, 'images/product/clothes8.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '上衣', '蓝色上衣', 399, 100, 2, 19, 'images/product/clothes9.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '上衣', '浅蓝色上衣', 499, 100, 2, 19, 'images/product/clothes10.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '上衣', '白色上衣', 68, 100, 2, 19, 'images/product/clothes4.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '皮鞋', '黑色皮鞋', 299, 100, 21, 14, 'images/product/shoes1.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '皮鞋', '灰色皮鞋', 299, 100, 21, 14, 'images/product/shoes2.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '皮鞋', '蓝色皮鞋', 299, 100, 21, 14, 'images/product/shoes3.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '皮鞋', '灰色皮鞋', 299, 100, 21, 14, 'images/product/shoes4.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '皮鞋', '棕色皮鞋', 299, 100, 21, 14, 'images/product/shoes5.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '皮鞋', '黑色皮鞋', 299, 100, 21, 14, 'images/product/shoes6.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '皮鞋', '黑色皮鞋', 299, 100, 21, 14, 'images/product/shoes7.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '皮鞋', '黑色皮鞋', 299, 100, 21, 14, 'images/product/shoes8.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '皮鞋', '黑色皮鞋', 299, 100, 21, 14, 'images/product/shoes9.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '皮鞋', '黑色皮鞋', 299, 100, 21, 14, 'images/product/shoes10.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass1.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass2.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass3.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass4.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass5.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass6.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass7.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass8.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass9.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass10.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '电视', '彩电', 1299, 100, 2, 15, 'images/product/television1.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '电视', '彩电', 1299, 100, 2, 15, 'images/product/television2.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '电视', '彩电', 2299, 100, 2, 15, 'images/products/television3.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '电视', '彩电', 2299, 100, 2, 15, 'images/product/television4.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '电视', '彩电', 3299, 100, 2, 15, 'images/product/television5.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '电视', '彩电', 2299, 100, 2, 15, 'images/product/television6.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '电视', '彩电', 4299, 100, 2, 15, 'images/product/television7.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '电视', '彩电', 5299, 100, 2, 15, 'images/product/television8.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '电视', '彩电', 2299, 100, 2, 15, 'images/product/television9.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '电视', '彩电', 6299, 100, 2, 15, 'images/product/television10.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '卡地亚', '见证你的爱情', 22122, 100, 2, 13, 'images/product/20.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '卡地亚', '见证你的爱情', 22122, 100, 22, 22, 'images/product/20.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '双色球', '来吧', 2, 1000, 2, 20, 'images/product/21.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '变形金刚', '大黄蜂', 222, 1000, 21, 17, 'images/product/23.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, 'GPS', '导航仪', 2222, 1000, 21, 18, 'images/product/24.jpg');
insert into TPRODUCT values (SEQ_PRODUCT_ID.NEXTVAL, '123', null, 100, 111, 2, 9, 'images\product\133214492473826.jpg');
