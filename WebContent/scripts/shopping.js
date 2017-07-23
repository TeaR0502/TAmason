// JavaScript Document
$(function() {
	// 获取当前购物车中的商品信息
	//

	$
			.ajax({
				url : "getProduct?action=getShoppingProduct",
				data : {},
				type : "post",
				dataType : "json",
				success : function(data) {
					var temp = "";
					if (data == null || data.length == 0) {
						$("#reh1").show(1500);
					} else {

						var temp = "<tr>" + "<th>商品名称</th>" + "<th>商品价格</th>"
							+"<th>购买数量</th>"+"<th>操作</th>"+"</tr>";

						for (var i = 0; i < data.length; i++) {
							// alert(data[i].pictureFile_name);

							temp += "<tr id="
									+ data[i].id
									+ ">"
									+ "<td class='thumb'> <img style='width: 100px; height: 100px;' src='"
									+ data[i].pictureFile_name
									+ "' />"
									+ "<a href='product_view.jsp?id="
									+ data[i].id
									+ "'>"
									+ data[i].name
									+ "</a>"
									+ "<td class='price' id='price_id_1'> ￥<span id='span_1'>"
									+ data[i].price
									+ "</span>"
									+ "<input type='hidden' id='subPrice' value='' /> </td>"
									+ "<td class='number'>"
									+ "<dl>"
									+ "<dt><input id='number_id_1' type='text' name='number' "
									+ " value=" + data[i].stock + " /></dt>"
									+ " <dd onclick='" + "#" + "'>修改</dd> "
									+ "</dl>" + " </td> "
									+ " <td class='delete'><a href='" + "#"
									+ "'>删除</a></td> " + "</tr>";

						}
						$("#rediv").html(temp);
					}
				},
				error : function() {
					alert("请刷新页面!");
				}
			});
	//

	$("#reh1").hide(0);
	
	
});
