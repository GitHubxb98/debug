<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chengeCustomersPwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="images/skin.css" rel="stylesheet" type="text/css" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
			background-color: #EEF2FB;
		}
	</style>
	<script type="text/javascript">
		function subForm(){
		    var obj = document.getElementById('custPwd');
		    var newPwd = document.getElementById('newCustPwd');
   			var okNewPwd = document.getElementById('okNewPwd');
   			var oldPwd = document.getElementById('oldPwd');
   			if(oldPwd.value == null || oldPwd.value == ""){
   				alert("请输入旧密码");
   				oldPwd.select();
   				return false;
   			}else if(newPwd.value == null || newPwd.value == ""){
   				alert("请输入新密码");
   				newPwd.select();
   				return false;
   			}else if(okNewPwd.value == null || okNewPwd.value == ""){
   				alert("请再次输入密码");
   				okNewPwd.select();
   				return false;
   			}else{
	   			if(newPwd.value == okNewPwd.value){
	   				if(oldPwd.value == obj.value){
	   				document.forms[0].submit();
	   				}else{
	   				alert("旧密码有误请重新输入");
	   				oldPwd.select();
   				    return false;
	   				}
	   				
	   			}else{
	   				alert("您输入的密码不一致，请重新输入。");
	   				newPwd.value = "";
	   				okNewPwd.value = "";
	   				return ;
	   			}
   		}
		}
		
	//自己写的判断代码
		//测试旧密码和原来的密码是否一致
		function test_oldpassword(oldPassword,th){
			//var inp = document.getElementById("oldPwd");
			
			if(th.value!=oldPassword){
				alert("旧密码输入错误！");
			//	return false;
			}
		}
		
		
		//测试确认密码
		function test_newpassword(th){
		
			var inp = document.getElementById("newCustPwd");
			
			if(th.value!=inp.value){
				alert("两次输入不匹配！");
			}
		
		}
		//确认提交
		function subForm(){
		
			document.forms[0].submit();
		
		}
		
	</script>
  </head>
  
  <body>
  <%-- <%
  		String custpwd = request.getParameter("haha");
  		request.setAttribute("custpwd", custpwd);
   %> --%>
<form action="car/user/updateCust" method="post">

   <%-- <input type="hidden" name="method" value="changeCustomersPwd"/>
   <input type="hidden" name="userPwd" value="${cust.custpwd }" id="custPwd"/> --%>
<!-- 所需属性1 -->   
<input type="hidden" name="identity" value="${cust.identity }" id="identity"/>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">修改密码</div></td>
      </tr>
    </table></td>
     <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2" valign="top">&nbsp;</td>
        <td>&nbsp;</td>
        <td valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2" valign="top"><span class="left_bt">
     	<table class="maintable" width="100%" border="0" cellspacing="0">
				<tr>
					<td width="104"><div align="right" class="left_txt">旧密码：</div>	</td>
				  <td width="201" height="24">
				  <input  name="oldPwd" type="password" onblur="test_oldpassword(${cust.custpwd },this)" class="inputcontent" id="oldPwd" size="20"maxlength="16" /></td>
				
				 <td width="473" height="24">
				 	 <div id="test_password" class="left_txt">
					 <font color="#FF0000">密码不能小于4位</font>
					</div>
				 </td>
				</tr>
			
				<tr>
					<td width="104">
						<div align="right" class="left_txt">
							新密码：</div></td>
				  <td height="24"><label></label><label>
				    <input	name="newCustPwd" type="password" class="inputcontent"id="newCustPwd" size="20"maxlength="16" />
				  </label></td>
					<td height="24">
						<div id="test_password" style="display:none" class="left_txt">
						<font color="#FF0000">密码不能小于4位</font></div>	</td>
				</tr>
				
				<tr>
					<td width="104">
						<div align="right" class="left_txt">
							确认密码：</div></td>
				  <td height="24">
<!-- 所需属性2 -->
<input name="custpwd" type="password" onblur="test_newpassword(this)" class="inputcontent"id="okNewPwd"  size="20" maxlength="16" /></td>
					<td height="24">
						<div id="test_password" style="display:none">
						<font color="#FF0000" class="left_txt">密码不能小于4位</font></div></td>
				</tr>
			</table>
    <table align="left" width="100%">
	<tr>
		<td height="107">
		<div align="center">
		<img  src="<%=basePath%>images/carimg/ok.gif" onclick="subForm()" style="cursor: hand;">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <img  src="<%=basePath%>images/carimg/reset.gif" onclick="reset()" style="cursor: hand;">
		</div>
	  </td>
	</tr>
	<tr>
		<td height="30" background="<%=basePath%>images/tab/bg.gif"></td>
	</tr>
</table>
</span>
	</td>
      </tr>
     
      <tr>
        
        <td valign="top"><table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
        </table></td>
      </tr>
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
   </form>
  </body>
</html>
