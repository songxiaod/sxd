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
				<h2>商品信息展示</h2>
				<form action="#">
					商品编号:<input type="text" name="gid"><br><br>
					商品名称:<input type="text" name="gname"><br><br>
					英文名称:<input type="text" name="gnames"><br><br>
					尺寸:<input type="text" name="size"><br><br>
					单价:<input type="text" name="money"><br><br>
					数量:<input type="text" name="num"><br><br>
					图片:<img src="" style="width:30px;height:35px"><br><br>
					品牌:<input type="text" name="bname"><br><br>
					类型:<input type="text" name="kname"><br><br>
				</form>
				<input type="button" value="返回">
		</center>
</body>
<script type="text/javascript">
		
		var id = ${param.id}
		
		$.post(
				"show",		
				{id:id},		
				function(obj){
					$("[name=gid]").val(obj.gid)
					$("[name=gname]").val(obj.gname)
					$("[name=gnames]").val(obj.gnames)
					$("[name=size]").val(obj.size)
					$("[name=num]").val(obj.num)
					$("[name=money]").val(obj.money)
					$("[name=bname]").val(obj.bname)
					$("[name=kname]").val(obj.kname)
					$("img").attr("src","image/"+obj.image)
				},		
				"json"
		)
		
		$("[value=返回]").click(function(){
			location="list"
		})
</script>
</html>