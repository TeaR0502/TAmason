<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="scripts/jquery-2.1.0.js"></script>
<script type="text/javascript" src="scripts/sortList.js"></script>
<div class="box" id="fl">
	<h2>
		商品分类
	</h2>
	<c:forEach items="${sessionScope.firstCategory}" var="category">
		<dl name = "${category.getId()}">
		<dt>
		<a href="index.jsp?id=${category.getId()}&parent=true" name="${category.getId()}">${category.getName()}</a>
		
		<c:forEach items="${sessionScope.secCategory}" var="item">
			<c:if test="${item.parent_id == category.id}">
				<dd>
					<a href="index.jsp?id=${item.id}">${item.name}</a>
				</dd>
			</c:if>
			
		</c:forEach>
		</dl>
	</c:forEach>
</div>
