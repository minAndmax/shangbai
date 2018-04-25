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
	<input type="button" id="butt" value="登录"/>
	
</body>
	
	<script type="text/javascript">
	
		$("#butt").click(function(){
			
			var unm = $("#userName").val();
			var pwd = $("#passowrd").val();
			$.post("/user/login",
				   {
					userName : unm,
					userPassWord : pwd
				   },
				   function(data){
					   if(data.tipStatus == 1){
						   window.location.href = "${pageContext.request.contextPath}/page/index";
					   } else{
						   alert("登录" + data.tipStatusContent);
					   }
			})
			
		})
	
	</script>

</html>