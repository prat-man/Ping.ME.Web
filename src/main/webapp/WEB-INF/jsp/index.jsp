<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="tk.pratanumandal.pingme.util.PingMEConstants"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
	<title>Ping.ME</title>
	
	<link rel="icon" type="image/x-icon" href="favicon.ico">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.min.js"></script>
	
	<link href="css/style.css" rel="stylesheet" type="text/css">
	
	<style>
.inverted-border-radius {
  position: relative;
  /*height: 100px;*/
  /*width: 325px;*/
  display: inline-block;
  background-color: #F66969;
  border-radius: 25px 25px 25px 0;
}

.inverted-border-radius::before {
  content: "";
  position: absolute;
  
  background-color: transparent;
  bottom: -50px;
  height: 50px;
  width: 25px;
  border-top-left-radius: 25px;
  box-shadow: 0 -25px 0 0 #F66969;
}
	</style>
</head>
<body>

	<h1>Ping.ME</h1>
	<h3 style="margin-top: -10px;">Pratanu Mandal</h3>
	<div style="text-align: right; border: none; margin-top: -45px; padding-bottom: 10px;">
		<a href="logout"><button style="padding: 5px 15px 5px 15px;">Logout</button></a>
	</div>
	<hr>
	<br>

	<div id="browser" class="bordered">
		<c:choose>
			<c:when test="${empty chat}">
				<p style="text-align: center;">Chat is empty</p>
			</c:when>
			<c:otherwise style="height: 500px;">
				<table>
					<c:forEach items="${chat}" var="message">
						<tr style="background-color: white !important;">
							<td style="vertical-align: top; padding: 0; padding-bottom: 1px;">
								<div class="inverted-border-radius">
									<div style="padding: 10px 25px 10px 25px; position: relative;">
										${message.getClient().getUsername()}<br>
										${message.getText()}
									</div>
								</div>
							</td>
							<!--<c:choose>
								<c:when test="${file.isDirectory()}">
									<td width="99%"><a href="?path=${file.getEncodedPath()}">${file.getName()}</a></td>
								</c:when>
								<c:otherwise>
									<td width="99%"><c:out value="${file.getName()}" /></td>
								</c:otherwise>
							</c:choose>
							<td style="text-align: right;"><span style="white-space: nowrap;">${file.getSize()}</span></td>
							<c:if test="${FtsConstants.DELETE}">
								<td><a onclick="deleteFile('${file.getName()}', '${file.getEncodedPath()}')">Delete</a></td>
							</c:if>
							<td><a href="/download?path=${file.getEncodedPath()}">Download</a></td>-->
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div style="text-align: center; border: none; font-size: 14px; padding-top: 8px; padding-bottom: 5px;">
		<span>Please consider using <b>Mozilla Firefox</b> or <b>Google Chrome</b> for the best experience</span>
	</div>

	<script src="js/script.js"></script>

</body>

</html>
