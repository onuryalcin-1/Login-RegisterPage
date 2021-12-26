<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Kayıt Formu Sayfası</title>
</head>
<body>
	
	<h3>Kayıt Formu</h3>
	
	<form action="registerServlet" method="post">
	
		<table align="center" cellpadding="10">
			<tr>
				<td>Ad : </td>
				<td><input type="text" name="firstName" maxlength="50"/></td>
			</tr>
			<tr>
				<td>Soyad : </td>
				<td><input type="text" name = "lastName" maxlength="50"/></td>
			</tr>
			<tr>
				<td>E-posta : </td>
				<td><input type="text" name="email" maxlength="50"/></td>
			</tr>
			<tr>
				<td>Parola : </td>
				<td><input type="password" name="password" maxlength="20"/></td>
			</tr>
			<tr>
				<td>Kullanıcı Adı : </td>
				<td><input type="text" name="userId" maxlength="60"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Kaydet"/>
					<input type="reset" vqlue="Temizle"/>
				</td>
			</tr>
		</table>
	</form>
	</body>
</html>