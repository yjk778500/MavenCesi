<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap.css">
    <title>玩家信息</title>
    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div align="center" style="margin-top: 130px;" class="input-group" id="aa" >
    	<table border="1">
    	<tr>
    		<td>玩家名称</td>
    		<td>玩家住址</td>
    		<td>玩家电话</td>
    		<td>玩家大区</td>
    	</tr>
    	<c:forEach items="${list }" var="user">
    		<tr>
    			<td>${user.user_name }</td>
    			<td>${user.user_address }</td>
    			<td>${user.user_tel }</td>
    			<td>${user.wana.zname }</td>
    			<td><input type="button" class="btn btn-info" onclick="dele(${user.id})" value="删除" /></td>
				<td><input type="button" class="btn btn-warning" onclick="update(${user.id})" value="修改" /></td>
    		</tr>
    	<input type="button" class="btn btn-warning" style="color: blue;" id="add" onclick="tiao()" value="添加用户">
    	
    	</c:forEach>
    	
    	
    	</table>
    </div>
  </body>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
  <script type="text/javascript">
  //跳转添加页面
  function tiao(){
  	location.href="<%=path%>/addtiao";
  }
  
  //跳转修改页面
  function update(id){
  	location.href="<%=path%>/uptiao?id="+id;
  }
  
  //删除玩家
  	function dele(id){
  		var flag = window.confirm("是否确认删除该用户?");
		if(flag){
    			$.ajax({
				url		:"deluser",
				type	:"post",
				data	:"id="+id,
				success	:function(data){
					 if(data.type=="success"){
					 alert(data.msg);
					 	$(".input-group").removeClass();
					 	$("#aa").load("index .input-group");
						
						
					}else{
					alert(data.msg);
					}
				},
				error:function(){
					alert("系统出现异常！");
    				}
    			});
    	
    			}else{
			return false;
		}
		};
  
  </script>
</html>
