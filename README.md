# TAmason
一个仿照亚马孙的学习项目
 
主要 模块有用户登录注册,商品浏览,分页浏览,分类浏览,商品添加购物车,结算(订单以及订单详情的生成和提交到数据库当中)
1,原先的数据库设计不合理存在.现改变了订单表的结构,采用订单表加订单详情表的操作
2,原先的前端验证逻辑不合理,用AJAX做了部分调整.
3,对原先的界面做了逻辑判断,并不是登录前和登陆后保持一致.在用户登录之后是INDEX-TOP做出不同的显示效果
 