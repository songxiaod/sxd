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
		<form action="list" method="post">
				<input type="hidden" name="pageNum">
				商品名称:<input type="text" name="name">
				<input type="submit" value="查询">				
		</form>
		<table>
				<tr>
					<td colspan="11">
						<input type="button" value="添加">
						<input type="button" value="批量删除">
					</td>
				</tr>
				<tr>
					<td>全选/全不选<input type="checkbox" value="${ls.gid}" class="cks"></td>
					<td>商品编号</td>
					<td>商品名称</td>
					<td>英文名称</td>
					<td>尺寸</td>
					<td>单价</td>
					<td>数量</td>
					<td>图片</td>
					<td>品牌</td>
					<td>类型</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${page.list}" var="ls">
				<tr>
					<td><input type="checkbox" value="${ls.gid}" class="cks"></td>
					<td>${ls.gid}</td>
					<td>${ls.gname}</td>
					<td>${ls.gnames}</td>
					<td>${ls.size}</td>
					<td>${ls.money}</td>
					<td>${ls.num}</td>
					<td><img src="image/${ls.image}" style="width:30px;height:35px"></td>
					<td>${ls.bname}</td>
					<td>${ls.kname}</td>
					<td><input type="button" value="详情" onclick="show(${ls.gid})">
						<input type="button" value="商品编辑" onclick="update(${ls.gid})">
						<input type="button" value="删除" onclick="deleteOne(${ls.gid})">
					</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="11">
						当前第${page.pageNum}/${page.pages}页
						<input type="button" value="首页" onclick="fy(${page.firstPage})">
						<input type="button" value="上一页" onclick="fy(${page.pageNum==page.firstPage?page.firstPage:page.prePage})">
						<input type="button" value="下一页" onclick="fy(${page.pageNum==page.lastPage?page.lastPage:page.nextPage})">
						<input type="button" value="尾页" onclick="fy(${page.lastPage})">
					</td>
				</tr>
		</table>
</body>

<script type="text/javascript">

		//单删
		function deleteOne(id){
			
			if(confirm("你确认要删除"+id+"条商品吗?")){
				
				$.post(
						"deletesGoods",
						{ids:id},
						function(obj){
							
							if(obj){
								alert("删除成功~！")
								
								location="list"
							}else{
								alert("删除失败~！")
							}
						},
						"json"
				)
			}else{
				
				alert("不删不要乱点哦~！")
			}
		}

		//批量删除
		$("[value=批量删除]").click(function(){
			
			var ids ="";
			
			$(".cks:checked").each(function(){
				
				ids +=","+$(this).val()
			})
			
			ids = ids.substring(1)
			
			if(confirm("你确认要删除"+ids+"条商品吗?")){
				
				$.post(
						"deletesGoods",
						{ids:ids},
						function(obj){
							
							if(obj){
								alert("删除成功~！")
								
								location="list"
							}else{
								alert("删除失败~！")
							}
						},
						"json"
				)
			}else{
				
				alert("不删不要乱点哦~！")
			}
		})

		//添加
		$("[value=添加]").click(function(){
			
			location="addGoods.jsp"
		})
		
		//详情
		function show(id){
			
			location="show.jsp?id="+id;
		}
		
		//修改
		function update(id){
			
			location="updateGoods.jsp?id="+id;
		}
			
		
		function fy(pageNum){
			$("[name=pageNum]").val(pageNum)
			
			$("form").submit();
		}
</script>
</html>