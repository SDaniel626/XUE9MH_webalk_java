<html>
<head>
	<title>Calculator</title>
</head>
<body>
<%
// ha servlettol jott, akkor van, ha elso keres, akkor nincs
szamologepszervlet.ResultDto result = (request.getAttribute("result") != null) ?
			(szamologepszervlet.ResultDto) request.getAttribute("result") :
			new szamologepszervlet.ResultDto();

String resultText = (result==null) ?
			"" : "result " + result.toString(); 
%>

ver: 0.3
<form method="post" action="szamologepservlet/szamologep.do">
	<input type="text" name="a" value="<%= result.getA() %>"/><br>
	<input type="text" name="b" value="<%= result.getB() %>"/><br>
	<select name="operator">
		<option value="+" /> +
		<option value="-" /> -
		<option value="*" /> *
		<option value="/" /> /
	</select><br>
</form>
</body>
</html>
