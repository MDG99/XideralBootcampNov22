<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Patient Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Patient</h3>
	
		<form:form action="savePatient" modelAttribute="patient" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Full name:</label></td>
						<td><form:input path="fullName" /></td>
					</tr>
				
					<tr>
						<td><label>Patient Number:</label></td>
						<td><form:input path="patientNumber" /></td>
					</tr>

					<tr>
						<td><label>Personal that registered (Role):</label></td>
						<td><form:input path="personal" /></td>
					</tr>
					
					<tr>
						<td><label>Hospital:</label></td>
						<td><form:input path="hospital" /></td>
					</tr>
					
					<tr>
						<td><label>Temperature:</label></td>
						<td><form:input path="temperature" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/patient/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










