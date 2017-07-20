<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <style type="text/css" >
  #div1  
{position:relative;width:650px;height:210px;overflow:hidden; 
}
  #div2{position:absolute;}
  li{float:left;list-style-type:none;padding:5px;}
  img{border:none;}
  #div2 li a:hover{top:-10px;}
  a{position:relative;}
  </style>
 <script type="text/javascript" >
  window.onload=function()
  {
   var odiv2=document.getElementById('div2');
   var ali=odiv2.getElementsByTagName('li');
   var aspeed=-5;
   var timer=null;
   odiv2.innerHTML+=odiv2.innerHTML;
   odiv2.style.width=ali[0].offsetWidth*ali.length+'px';
odiv2.onmouseover=function(){clearInterval(timer);};
function a()
{
   timer=setInterval(function()    
     {
      odiv2.style.left=odiv2.offsetLeft+aspeed+'px';
      if (odiv2.offsetLeft<-odiv2.offsetWidth/2)
      {
       odiv2.style.left='0px';
       }
       },30);};
   odiv2.onmouseout=a;
   a();
   }
 </script>

<div id='div1'>
  <div id='div2'>
  
<div class="hot">
			<h2>热卖推荐</h2>	
			<ul class="product clearfix">		

				<li>
					<dl>
						<dt><a href="#" target="_self"><img src="images/product/0.jpg" /></a></dt>
						<dd class="title"><a href="#" target="_self">XXXX</a></dd>
						<dd class="price">￥12.34</dd>
					</dl>
				</li>
				
				<li>
					<dl>
						<dt><a href="#" target="_self"><img src="images/product/0.jpg" /></a></dt>
						<dd class="title"><a href="#" target="_self">XXXX</a></dd>
						<dd class="price">￥12.34</dd>
					</dl>
				</li>
				
			</ul>		
		</div>			
 </div>
 </div>