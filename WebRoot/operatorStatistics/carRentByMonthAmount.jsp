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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>租车统计</title>

<style type="text/css">
#container {
	min-width: 310px;
	max-width: 800px;
	height: 400px;
	margin: 0 auto
}
</style>
</head>
<body>
	<script src="js/highcharts.js"></script>
	<script src="js/module/exporting.js"></script>
	<script src="js/module/series-label.js"></script>
	<script src="js/themes/gray.js"></script>
	<div id="container"></div>



	<script type="text/javascript">
		Highcharts.chart('container', {

			title : {
				text : '2019 年 各 月 份 汽 车 租 赁 情 况'
			},

			subtitle : {
				text : 'carRental.com'
			},

			yAxis : {
				title : {
					text : '租   借   次   数'
				}
			},
			legend : {
				layout : 'vertical',
				align : 'right',
				verticalAlign : 'middle'
			},

			plotOptions : {
				series : {
					label : {
						connectorAllowed : false
					},
					pointStart : 01
				}
			},

			series : ${strformat},

			responsive : {
				rules : [ {
					condition : {
						maxWidth : 500
					},
					chartOptions : {
						legend : {
							layout : 'horizontal',
							align : 'center',
							verticalAlign : 'bottom'
						}
					}
				} ]
			}

		});
	</script>
</body>
</html>
