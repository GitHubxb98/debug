<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'rentManager.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>css/public.css">
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
	function subForm() {
		document.forms[0].submit();
	}
</script>
</head>

<body>
	<form action="car/rentTable/findRentalTableByIf" method="post">
		<h5>
			<font color="red">${requestScope.msg }</font>
		</h5>
		<input type="hidden" name="method" value="findRenttable" />
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="17" valign="top" background="images/mail_leftbg.gif"><img
					src="images/left-top-right.gif" width="17" height="29" /></td>
				<td valign="top" background="images/content-bg.gif"><table
						width="100%" height="31" border="0" cellpadding="0"
						cellspacing="0" class="left_topbg" id="table2">
						<tr>
							<td height="31"><div class="titlebt">出租单管理</div></td>
						</tr>
					</table></td>
				<td width="16" valign="top" background="images/mail_rightbg.gif"><img
					src="images/nav-right-bg.gif" width="16" height="29" /></td>
			</tr>
			<tr>
				<td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
				<td valign="top" bgcolor="#F7F8F9"><table width="98%"
						border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td colspan="2" valign="top">&nbsp;</td>
							<td>&nbsp;</td>
							<td valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2" valign="top"><span class="left_bt">
									<table class="maintable" width="97%" border="0" cellspacing="0">
										<tr>
											<td width="14%"><div align="center" class="left_txt">出租单编号</div></td>
											<td width="23%"><input type="text" name="tableid"
												id="tableId"></td>
											<td width="15%"><div align="center" class="left_txt">起租日期</div></td>
											<td width="48%"><input class="Wdate" type="text"
												name="begindate" id="beginDate"
												onFocus="WdatePicker({isShowClear:false,readOnly:true})" /></td>
										</tr>
										<tr>
											<td><div align="center" class="left_txt">应归还日期</div></td>
											<td><input class="Wdate" type="text"
												name="shouldreturndate" id="shouldReturnDate"
												onFocus="WdatePicker({isShowClear:false,readOnly:true})" /></td>
											<td><div align="center" class="left_txt">归还日期</div></td>
											<td><input class="Wdate" type="text" name="returndate"
												id="returnDate"
												onFocus="WdatePicker({isShowClear:false,readOnly:true})" /></td>

										</tr>
										<tr>
											<td><div align="center" class="left_txt">客户号</div></td>
											<td><input type="text" name="custid" id="identity"></td>
											<td><div align="center" class="left_txt">车号</div></td>
											<td><input type="text" name="carid" id="carNumber"></td>
										</tr>
										<tr>
											<td><div align="center" class="left_txt">出租单状态</div></td>
											<td><select name="rentflag" id="rentFlag"
												style="width: 80px;">
													<option value="0" class="left_txt">出租中</option>
													<option value="1" class="left_txt">已入库</option>
											</select></td>
											<td><div align="center" class="left_txt">服务人员编号</div></td>
											<td><input type="text" name="usersid" id="userName"></td>
										</tr>
									</table>
									<table align="left" width="100%">
										<tr>
											<td height="107">
												<div align="center">
													<a href="#" style="cursor: hand;"> <img
														src="<%=basePath%>images/carimg/ok.gif"
														onclick="subForm()" style="cursor: hand;"></a>
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
														href="#" style="cursor: hand;"> <img
														src="<%=basePath%>images/carimg/reset.gif"
														onclick="reset()" style="cursor: hand;"></a>
												</div>
											</td>
										</tr>
										<tr>
											<td height="30" background="<%=basePath%>images/tab/bg.gif"></td>
										</tr>
									</table>
							</span></td>
						</tr>

						<tr>

							<td valign="top"><table width="100%" height="144" border="0"
									cellpadding="0" cellspacing="0" class="line_table">
								</table></td>
						</tr>
					</table></td>
				<td background="images/mail_rightbg.gif">&nbsp;</td>
			</tr>
			<tr>
				<td valign="bottom" background="images/mail_leftbg.gif"><img
					src="images/buttom_left2.gif" width="17" height="17" /></td>
				<td background="images/buttom_bgs.gif"><img
					src="images/buttom_bgs.gif" width="17" height="17"></td>
				<td valign="bottom" background="images/mail_rightbg.gif"><img
					src="images/buttom_right2.gif" width="16" height="17" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
