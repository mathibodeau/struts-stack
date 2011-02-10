<!DOCTYPE html PUBLIC
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>SLAC - Insurance Policies</title>
</head>
<body>
<table>
    <tr>
        <th>Number</th>
    </tr>
    <s:iterator value="model">
    <tr id="policy-${number}">
        <td>${number}</td>
    </tr>
    </s:iterator>
</table>
</body>
</html>