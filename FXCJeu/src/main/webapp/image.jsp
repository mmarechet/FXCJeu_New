<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="TeleversementServlet"  enctype="multipart/form-data" method="POST" name="formulaireTeleversement">
<input type="file" name="NOM_IMAGE" multiple>
<br>
<input type="submit" name="submit"
								id="sumbit" value="Se connecter">
</form>
</body>
</html>