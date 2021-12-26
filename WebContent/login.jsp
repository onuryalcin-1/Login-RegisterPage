<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="css/main.css" rel=stylesheet type="text/css"/>
<meta charset="utf-8">
<title>Giriş Sayfası</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div style="padding: 250px 0 0 0"class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <img class="profile-img" src="images/login-logo.png"
                    alt="">
                <form method="post" action="loginServlet" class="form-signin">
                <input type="text" name="userId" class="form-control" placeholder="Kullanıcı Adı" required autofocus>
                <input type="password" name="password" class="form-control" placeholder="Parola" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Giriş</button>
                <label class="checkbox pull-left">
                </label>
                </form>
            </div>
            <a href="register.jsp" class="text-center new-account">Hesap Oluştur! </a>
        </div>
    </div>
</div>











</body>
</html>