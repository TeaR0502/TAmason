// JavaScript Document

	// 获取当前购物车中的商品信息
	//
	function getAllCart(username) {
		//alert(username);
		$.ajax({
			async : false,
			url : "getProduct?action=getShoppingProduct",
			data : {"username":username},
			type : "post",
			dataType : "json",
			success : function(data) {
				var temp = "";
				// alert(data);
				if (data == null || data.length == 0) {
					$("#reh1").html("还没有添加任何物品到购物车!");
					$("#reh1").show(1500);
				} else {
					$("#reh1").hide(0);
					var temp = "<tr>" + "<th>商品名称</th>" + "<th>商品价格</th>"
							+ "<th>购买数量</th>" + "<th>操作</th>" + "</tr>";

					for (var i = 0; i < data.length; i++) {
						// alert(data[i].pictureFile_name);

						temp += "<tr id='"
								+ data[i].id
								+ "'>"
								+ "<td class='thumb'> <img style='width: 100px; height: 100px;' src='"
								+ data[i].pictureFile_name
								+ "' />"
								+ "<a href='product_view.jsp?id="
								+ data[i].id
								+ "'>"
								+ data[i].name
								+ "</a>"
								+ "<td class='price' > ￥<span >"
								+ data[i].price
								+ "</span>"
								+ "<input type='hidden'  value='' /> </td>"
								+ "<td class='number'>"
								+ "<dl>"
								+ "<dt><input type='text' name='number' "
								+ " value = "
								+ data[i].stock
								+ " /></dt>"
								+ " <dd class='modifyButten' name='"
								+ data[i].id
								+ "' >修改</dd> "
								+ "</dl>"
								+ " </td> "
								+ " <td class='delete'><a class='deleteButten' name='"
								+ data[i].id + "' >删除</a></td> " + "</tr>";

					}
					$("#rediv").html(temp);
				}
			},
			error : function() {
				$("#reh1").html("还没有添加任何物品到购物车!");
				$("#reh1").show(1500);
			}
		});
//
		
		
		
		
		
		// 修改按钮的点击事件
		
		$(".modifyButten").click(function() {
		//	alert("1");
			var productId = $(this).attr("name");
			var stock = $(this).prev().find("input").val();
			//alert(stock);
			
			
			// ////

			$.ajax({
				url : "addCartServlet?action=modifyCart",
				data : {
					"username":username,
					"id" : productId,
					"stock" : stock
				},
				type : "post",
				dataType : "html",
				success : function(data) {
					// alert(data);
					// alert(data == '0');
					if (data == null || data == "" || data == 1) {
						// alert(data);
						$("#reh1").html("修改失败");
						$("#reh1").show(500);
						$("#" + productId).show(1500);
					} else if (data == 0) {
						$("#reh1").html("修改成功");
						$("#reh1").show(1000);
						$("#" + productId).show(1500);
					} else if (data == 2) {
						$("#reh1").html("获取购物车信息失败!");
						$("#reh1").show(1000);
						$("#reh1").hide(2000);
					}

					// setTimeout($("#reh1").hide(1000), 3000);
				},
				error : function() {
					$("#reh1").html("出现异常,请刷新重新");
					$("#reh1").show(500);
				}
			});
			setTimeout($("#reh1").hide(1000), 3000);
			// ////

		});

		// 删除按钮点击事件
		$(".deleteButten").click(function() {
			//alert("1");
			var productId = $(this).attr("name");
			alert(username);
			// ////

			$.ajax({
				url : "addCartServlet?action=deleteCart",
				data : {
					"username":username,
					"id" : productId
				},
				type : "post",
				dataType : "html",
				success : function(data) {
					// alert(data);
					// alert(data == '0');
					$("#" + productId).hide(1500);
					if (data == null || data == "" || data == 1) {
						// alert(data);
						$("#reh1").html("删除失败");
						$("#reh1").show(500);
						$("#" + productId).show(1500);
					} else if (data == 0) {
						$("#reh1").html("删除成功");
						$("#reh1").show(1000);

					} else if (data == 2) {
						$("#reh1").html("购物车中无此商品,请不要重复删除!");
						$("#reh1").show(1000);
					}

					// setTimeout($("#reh1").hide(1000), 3000);
				},
				error : function() {
					$("#reh1").html("出现异常,请刷新重新");
					$("#reh1").show(500);
					$("#" + productId).show(1500);
				}
			});
			setTimeout($("#reh1").hide(1000), 3000);
			// ////
		});

		$("#reh1").hide(0);

		
		
		
		
		
	}
	



	
