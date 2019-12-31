<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/index_work.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
</head>
<body>
		<center>
				<h2>添加页面</h2>
				<form action="addGoods" method="post" enctype="multipart/form-data">
					商品名称:<input type="text" name="gname"><br><br>
					英文名称:<input type="text" name="gnames"><br><br>
					尺寸:<input type="text" name="size"><br><br>
					单价:<input type="text" name="money"><br><br>
					数量:<input type="text" name="num"><br><br>
					产品概述:<input type="text" name="inss"><br><br>
					图片:<input type="file" name="multipartResolver" ><br><br>
					品牌:<select name="bid">
					
					</select><br><br>
					类型:<select name="kid">
						
					</select><br><br>
					<input type="submit" value="添加">
				</form>
		</center>
</body>
<script type="text/javascript">
		
		$.post(
				"findBrand",
				{},
				function(obj){
					
					var str = "<option>------请选择------</option>"
					
					for(var i in obj){
						
						str+="<option value="+obj[i].bid+">"+obj[i].bname+"</option>"
					}
					
					$("[name=bid]").html(str)
				},
				"json"
		)
		$.post(
				"findkinds",
				{},
				function(obj){
					
					var str = "<option>------请选择------</option>"
					
					for(var i in obj){
						
						str+="<option value="+obj[i].kid+">"+obj[i].kname+"</option>"
					}
					
					$("[name=kid]").html(str)
				},
				"json"
		)
</script>
</html>