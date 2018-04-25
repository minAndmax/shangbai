<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-2.1.1.js"></script>
</head>
<body>
	
	<input type="text" id="userName"/>
	<input type="password" id="passowrd"/>
	<input type="text" id="realname"/>
	<input type="button" id="butt" value="提交"/>
	
</body>
	
	<script type="text/javascript">
	
		$("#butt").click(function(){
			
			var unm = $("#userName").val();
			var pwd = $("#passowrd").val();
			var realname = $("#realname").val();
			$.post("/user/register",
				   {
					userName : unm,
					userPassWord : pwd,
					realName : realname
				   },
				   function(data){
					alert(data);
			})
			
		})
	
	</script>

</html>