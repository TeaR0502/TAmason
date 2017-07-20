<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" 
					import="java.io.*,
									 java.util.*,
									 com.sun.image.codec.jpeg.*,
									 java.awt.*,
									 java.awt.image.*"%>
<%
		//0.选择颜色
		int color = 0;
		if ((new Random()).nextInt(99) > 50){
			color = 1;
		}



		//1. 验证码内容文本生成
		String s = "";
		
        int intCount = 0;
		
        intCount = (new Random()).nextInt(9999);// 
		
        
		
        /*原先的方法,会导致产生的数字不会有1000以下的
        if (intCount < 1000)	// 数字位数补全
            intCount += 1000;
		*/
		if(intCount < 1000){
			s = "0";
		}
        s += intCount + "";
        // 保存入session,用于与用户的输入进行比较.
        // 注意比较完之后清除session.
       
        
      //1.1 验证码混乱测试
      		String mixs = "";
      		int mixCount = 0;
      		mixCount = (new Random()).nextInt(9999);
      		
      		if(mixCount < 1000){
      			mixs = "0";
    		}
    		
            mixs += mixCount + "";
       //1.3 选择哪个为验证码
       session.setAttribute("color",color);
       if (color == 0){
    	   session.setAttribute("validateCode", s);
           
       } else {
    	   session.setAttribute("validateCode", mixs);
       }

		//2. 通过Java2D绘图API将验证码文本转换为图片
        BufferedImage image = new BufferedImage(70, 14,	// 指定宽，高
                BufferedImage.TYPE_INT_RGB);

		// 绘图对象Graphics
        Graphics gra = image.getGraphics();
        Graphics gra2 = image.getGraphics();
        // 设置背景色
        gra.setColor(Color.white);
        gra.fillRect(1, 1, 33, 12);
        gra2.setColor(Color.white);
        gra2.fillRect(1, 1, 33, 12);
        
        // 设置字体色
        gra.setColor(Color.red);
        gra.setFont(new Font("宋体", Font.PLAIN, 12));	// 指定字体、样式、字号大小
        gra2.setColor(Color.green);
        gra2.setFont(new Font("宋体", Font.PLAIN, 12));	// 指定字体、样式、字号大小
        
        // 输出数字
        char c;
		char d;
        for (int i = 0; i < 4; i++) {
            c = s.charAt(i);
			d = mixs.charAt(i);
			if (i%2 == 0){
				gra.drawString(c + "", i * 14 + 4, 9); // 7为宽度，11为上下高度位置
				gra2.drawString(d + "", i * 14 + 4 + 4, 12); // 7为宽度，11为上下高度位置
			} else{
				gra.drawString(c + "", i * 14 + 8, 12); // 7为宽度，11为上下高度位置
				gra2.drawString(d + "", i * 14 + 12, 9); // 7为宽度，11为上下高度位置
			}
            

        }

		//3.动态生成的图片输出到客户端
		response.setContentType("image/jpeg");
		
		OutputStream toClient = response.getOutputStream();	// 图片数据要通过2进制流方式传送
		
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(toClient); // 具体图片格式编码转换器

        encoder.encode(image);	// 转换并输出到客户端

		toClient.close();

        out.clear();

		out = pageContext.pushBody();
%>