<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>省份和城市</title>
<script type="text/javascript">
	function refresh(){ // 省份下拉列表改变时，刷新页面
		document.forms[0].submit(); // 提交表单
	}
</script>
</head>
<body>
	<s:debug/>
	<s:form action="city" method="post" theme="simple">
		省份：<s:select name="provinceId" list="all_provinces" listKey="id" listValue="name" onchange="refresh()"/>
		城市：<s:select list="cities" listKey="id" listValue="name"/>
		<p />
		<hr />
	</s:form>
</body>
</html>