<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'viewCars.jsp' starting page</title>

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
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}

a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}

a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}

a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.STYLE7 {
	font-size: 12
}
-->
</style>
<script>
		var  highlightcolor='#EEF2FB';
		//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
		var  clickcolor='red';
		function  changeto(){
		source=event.srcElement;
		if  (source.tagName=="TR"||source.tagName=="TABLE")
		return;
		while(source.tagName!="TD")
		source=source.parentElement;
		source=source.parentElement;
		cs  =  source.children;
		//alert(cs.length);
		if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
		for(i=0;i<cs.length;i++){
			cs[i].style.backgroundColor=highlightcolor;
		}
		}
		
		function  changeback(){
		if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
		return
		if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
		//source.style.backgroundColor=originalcolor
		for(i=0;i<cs.length;i++){
			cs[i].style.backgroundColor="";
		}
		}
		
		function  clickto(){
		source=event.srcElement;
		if  (source.tagName=="TR"||source.tagName=="TABLE")
		return;
		while(source.tagName!="TD")
		source=source.parentElement;
		source=source.parentElement;
		cs  =  source.children;
		//alert(cs.length);
		if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
		for(i=0;i<cs.length;i++){
			cs[i].style.backgroundColor=clickcolor;
		}
		else
		for(i=0;i<cs.length;i++){
			cs[i].style.backgroundColor="";
		}
		}
		
		
		
</script>
<script type="text/javascript">
	//分页
	function change(page,size){
		var carNumber = document.getElementById("carNumber").value;
		var color = document.getElementById("color").value;
		var carType = document.getElementById("carType").value;
		var price = document.getElementById("price").value;
		var rentPrice = document.getElementById("rentPrice").value;
		var deposit = document.getElementById("deposit").value;
		var isRenting = document.getElementById("isRenting").value;
		window.location.href = "car/car/getPageCars?page="+page+"&size="+size+"&carNumber="+carNumber+"&color="+color+"&carType="+carType+"&price="+price+"&rentPrice="+rentPrice+"&deposit="+deposit+"&isRenting="+isRenting;
	}
	//编辑
	function preUpdateCar(carNumber){
  	window.location.href = "car/car/getOneCar?carNumber="+carNumber;
  	}
  
  	//删除
  	 function deleteCar(carNumber){
  	if(window.confirm("您确定要这么做吗？")){
  	window.location.href = "car/car/deleteOne?carNumber="+carNumber;
  	}else{
  	return ;
  	}
  }
</script>
</head>

<body>

	<input type="hidden" name="carNumber" value="${oldCar.carNumber }"
		id="carNumber">
	<input type="hidden" name="color" value="${oldCar.color }" id="color">
	<input type="hidden" name="carType" value="${oldCar.carType }"
		id="carType">
	<input type="hidden" name="price" value="${oldCar.price }" id="price">
	<input type="hidden" name="rentPrice" value="${oldCar.rentPrice }"
		id="rentPrice">
	<input type="hidden" name="deposit" value="${oldCar.deposit }"
		id="deposit">
	<input type="hidden" name="isRenting" value="${oldCar.isRenting }"
		id="isRenting">
	<input type="hidden" name="pageIndex" value="" id="pageIndex">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="17" valign="top" background="images/mail_leftbg.gif"><img
				src="images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="images/content-bg.gif"><table
					width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">显示汽车</div></td>
					</tr>
				</table></td>
			<td width="16" valign="top" background="images/mail_rightbg.gif"><img
				src="images/nav-right-bg.gif" width="16" height="29" /></td>
		</tr>
		<tr>
			<td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0"
					align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td colspan="2" valign="top">&nbsp;</td>
						<td>&nbsp;</td>
						<td valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" valign="top"><span class="left_bt"> <!-- startTable -->
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="30"><table width="100%" border="0"
												cellspacing="0" cellpadding="0">
												<tr>
													<td width="15" height="30"><img
														src="images/tab_03.gif" width="15" height="30" /></td>
													<td width="1101" background="images/tab_05.gif"><img
														src="images/311.gif" width="16" height="16" /> <span
														class="STYLE4">查询用户显示列表</span></td>
													<td width="281" background="images/tab_05.gif"><table
															border="0" align="right" cellpadding="0" cellspacing="0">
															<tr>
																<td width="60"><table width="87%" border="0"
																		cellpadding="0" cellspacing="0">
																		<tr>
																			<td class="STYLE1"><div align="center">
																					<input type="checkbox" name="checkbox62"
																						value="checkbox" id="all" onClick="checkAll()" />
																				</div></td>
																			<td class="STYLE1"><div align="center">全选</div></td>
																		</tr>
																	</table></td>
																<td width="60"><table width="90%" border="0"
																		cellpadding="0" cellspacing="0">
																		<tr>
																			<td class="STYLE1"><div align="center">
																					<img src="images/001.gif" width="14" height="14" />
																				</div></td>
																			<td class="STYLE1"><div align="center">新增</div></td>
																		</tr>
																	</table></td>
																<td width="60"><table width="90%" border="0"
																		cellpadding="0" cellspacing="0">
																		<tr>
																			<td class="STYLE1"><div align="center">
																					<img src="images/114.gif" width="14" height="14" />
																				</div></td>
																			<td class="STYLE1"><div align="center">修改</div></td>
																		</tr>
																	</table></td>
																<td width="52"><table width="88%" border="0"
																		cellpadding="0" cellspacing="0">
																		<tr>
																			<td class="STYLE1"><div align="center">
																					<img src="images/083.gif" width="14" height="14" />
																				</div></td>
																			<td class="STYLE1"><div align="center">删除</div></td>
																		</tr>
																	</table></td>
															</tr>
														</table></td>
													<td width="14"><img src="images/tab_07.gif" width="14"
														height="30" /></td>
												</tr>
											</table></td>
									</tr>
									<tr>
										<td><table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="9" background="images/tab_12.gif">&nbsp;</td>
													<td bgcolor="#f3ffe3"><table width="99%" border="0"
															align="center" cellpadding="0" cellspacing="1"
															bgcolor="#c0de98" onmouseover="changeto()"
															onmouseout="changeback()">
															<tr>
																<td width="4%" height="26"
																	background="images/tab_14.gif" class="STYLE1"><div
																		align="center" class="STYLE2 STYLE1">选择</div></td>
																<td width="8%" height="18"
																	background="images/tab_14.gif" class="STYLE1"><div
																		align="center" class="STYLE2 STYLE1">序号</div></td>
																<td width="10%" height="18"
																	background="images/tab_14.gif" class="STYLE1"><div
																		align="center" class="STYLE2 STYLE1">车号</div></td>
																<td width="18%" height="18"
																	background="images/tab_14.gif" class="STYLE1"><div
																		align="center" class="STYLE2 STYLE1">颜色</div></td>
																<td width="10%" height="18"
																	background="images/tab_14.gif" class="STYLE1"><div
																		align="center" class="STYLE2 STYLE1">价格</div></td>
																<td width="6%" height="18"
																	background="images/tab_14.gif" class="STYLE1"><div
																		align="center" class="STYLE2">租金</div></td>
																<td width="12%" height="18"
																	background="images/tab_14.gif" class="STYLE1"><div
																		align="center" class="STYLE2">押金</div></td>
																<td width="8%" height="18"
																	background="images/tab_14.gif" class="STYLE1"><div
																		align="center" class="STYLE2">租用情况</div></td>
																<td width="7%" height="18"
																	background="images/tab_14.gif" class="STYLE1"><div
																		align="center" class="STYLE2">编辑</div></td>
																<td width="7%" height="18"
																	background="images/tab_14.gif" class="STYLE1"><div
																		align="center" class="STYLE2">删除</div></td>
															</tr>
															<c:forEach var="car"
																items="${requestScope.pageBean.list}" varStatus="st">
																<tr>
																	<td height="18" bgcolor="#FFFFFF"><div
																			align="center" class="STYLE1">
																			<input name="dels" type="checkbox" class="STYLE2"
																				value="checkbox" />
																		</div></td>

																	<td height="18" bgcolor="#FFFFFF" class="STYLE2"><div
																			align="center" class="STYLE2 STYLE1">${st.count }</div></td>
																	<td height="18" bgcolor="#FFFFFF"><div
																			align="center" class="STYLE2 STYLE1">${car.carNumber }</div></td>
																	<td height="18" bgcolor="#FFFFFF"><div
																			align="center" class="STYLE2 STYLE1">${car.color }</div></td>
																	<td height="18" bgcolor="#FFFFFF"><div
																			align="center" class="STYLE2 STYLE1">${car.price }</div></td>
																	<td height="18" bgcolor="#FFFFFF"><div
																			align="center" class="STYLE2 STYLE1">${car.rentPrice }</div></td>
																	<td height="18" bgcolor="#FFFFFF"><div
																			align="center" class="STYLE2 STYLE1">${car.deposit }</div></td>
																	<td height="18" bgcolor="#FFFFFF"><div
																			align="center" class="STYLE2 STYLE1">
																			<c:choose>
																				<c:when test="${car.isRenting eq '1'}">已出租</c:when>
																				<c:otherwise>未出租</c:otherwise>
																			</c:choose>
																		</div></td>
																	<td height="18" bgcolor="#FFFFFF"><div
																			align="center">
																			<img src="images/037.gif" width="9" height="9" /><span
																				class="STYLE1"> [</span><a
																				onclick="preUpdateCar('${car.carNumber }')"
																				style="font-size: 10px; cursor: hand; color: blue; ">编辑</a><span
																				class="STYLE1">]</span>
																		</div></td>
																	<td height="18" bgcolor="#FFFFFF"><div
																			align="center">
																			<span class="STYLE2"><img src="images/010.gif"
																				width="9" height="9" /> </span><span class="STYLE1">[</span><a
																				onclick="deleteCar('${car.carNumber }')"
																				style="font-size: 10px; cursor: hand; color: blue; ">删除</a><span
																				class="STYLE1">]</span>
																		</div></td>
																</tr>
															</c:forEach>
														</table></td>
													<td width="9" background="images/tab_16.gif">&nbsp;</td>
												</tr>
											</table></td>
									</tr>
									<tr>
										<td height="29"><table width="100%" border="0"
												cellspacing="0" cellpadding="0">
												<tr>
													<td width="15" height="29"><img
														src="images/tab_20.gif" width="15" height="29" /></td>
													<td background="images/tab_21.gif"><table width="100%"
															border="0" cellspacing="0" cellpadding="0">
															<tr>
																<td width="25%" height="29" nowrap="nowrap"><span
																	class="STYLE1">共${requestScope.pageBean.totalCount }条纪录，当前第${requestScope.pageBean.index }页，每页
																		<select onchange="change('',this.value)">
																			<c:forEach begin="2" end="10" step="2" var="size">
																				<c:if test="${pageBean.size == size}">
																					<option selected="selected">${size}</option>
																				</c:if>
																				<c:if test="${pageBean.size != size}">
																					<option>${size}</option>
																				</c:if>
																			</c:forEach>
																	</select> 条信息
																</span></td>
																<td width="75%" valign="top" class="STYLE1"><div
																		align="right">
																		<table width="352" height="20" border="0"
																			cellpadding="0" cellspacing="0">
																			<tr>
																				<c:if test="${requestScope.pageIndex > 1}">
																					<td width="62" height="22" valign="middle"><div
																							align="right">
																							<a onclick="subForm('${1}')"
																								style="cursor: hand;"><img
																								src="images/first.gif" width="37" height="15" /></a>
																						</div></td>
																					<td width="50" height="22" valign="middle"><div
																							align="right">
																							<a
																								onclick="subForm('${requestScope.pageIndex -1 }')"
																								style="cursor: hand;"><img
																								src="images/back2.gif" width="43" height="15" /></a>
																						</div></td>
																				</c:if>
																				<c:if
																					test="${requestScope.pageIndex < requestScope.page.totalPage}">
																					<td width="54" height="22" valign="middle"><div
																							align="right">
																							<a
																								onclick="subForm('${requestScope.pageIndex +1 }')"
																								style="cursor: hand;"><img
																								src="images/next.gif" width="43" height="15" /></a>
																						</div></td>
																					<td width="49" height="22" valign="middle"><div
																							align="right">
																							<a
																								onclick="subForm('${requestScope.page.totalPage}')"
																								style="cursor: hand;"><img
																								src="images/last.gif" width="37" height="15" /></a>
																						</div></td>
																				</c:if>
																				<td width="300" height="22" valign="middle"><div
																						align="right" class="STYLE2 STYLE1">

																						<a href="javaScript:change(1,${pageBean.size})">首页</a>
																						<!--上一页的处理  -->
																						<c:if test="${pageBean.index != 1}">
																							<a
																								href="javaScript:change(${pageBean.index-1},${pageBean.size})">上一页</a>
																						</c:if>
																						<c:if test="${pageBean.index == 1}">
																				       	上一页
																				       </c:if>

																						<!--底部的导航数字  -->
																						<c:forEach items="${pageBean.numbers }" var="num">
																							<c:if test="${num == pageBean.index}">
																						       [<a
																									href="javaScript:change(${num},${pageBean.size})">${num}</a>]
																						       </c:if>
																							<c:if test="${num != pageBean.index}">
																								<a
																									href="javaScript:change(${num},${pageBean.size})">${num}</a>
																							</c:if>
																						</c:forEach>
																						<!--下一页的处理  -->
																						<c:if
																							test="${pageBean.index != pageBean.totalPageCount}">
																							<a
																								href="javaScript:change(${pageBean.index + 1},${pageBean.size})">下一页</a>
																						</c:if>
																						<c:if
																							test="${pageBean.index == pageBean.totalPageCount}">
																					       	下一页
																					       </c:if>
																						<a
																							href="javaScript:change(${pageBean.totalPageCount},${pageBean.size})">尾页</a>



																						转到第
																					</div></td>
																				<td width="25" height="22" valign="middle"><span
																					class="STYLE7"> <input name="textfield"
																						type="text" class="STYLE1"
																						style="height:20px; width:25px;" size="5"
																						onchange="change(this.value,${pageBean.size})"
																						id="goPage" />
																				</span></td>
																				<td width="23" height="22" valign="middle"
																					class="STYLE2 STYLE1">页</td>
																				<td width="30" height="22" valign="middle"><a
																					onclick="" style="cursor: hand;"><img
																						src="images/go.gif" width="37" height="15" /></a></td>
																			</tr>
																		</table>
																	</div></td>
															</tr>
														</table></td>
													<td width="14"><img src="images/tab_22.gif" width="14"
														height="29" /></td>
												</tr>
											</table></td>
									</tr>
								</table> <!-- endTable -->


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
</body>
</html>
