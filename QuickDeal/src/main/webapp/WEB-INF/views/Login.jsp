<%@ page language="java" contentType="text/html" %>
<%@ include file="Header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html lang="zxx">

<head>
	<title>Quick Deal</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content="Quick Deal"
	/>
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- Meta tag Keywords -->
	<!-- css files -->
	<link rel="stylesheet" href="resources/login/css/style.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link rel="stylesheet" href="resources/login/css/fontawesome-all.css">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->
	<!-- web-fonts -->
	<link href="//fonts.googleapis.com/css?family=Reem+Kufi&amp;subset=arabic" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<!-- //web-fonts -->
</head>

<!-- title -->
	<h1>
		<span>Q</span>ucikDeal
		<span>L</span>ogin
		<span>I</span>n
		<span>P</span>age</h1>
		<!-- content -->
	<div class="sub-main-w3">
<form action="perform_login" method="post">
	<div class="form-style-agile">
				<label>
					Username
					<i class="fas fa-user"></i>
				</label>
				<input placeholder="Username" name="username" type="text" required="true">
			</div>
			<div class="form-style-agile">
				<label>
					Password
					<i class="fas fa-unlock-alt"></i>
				</label>
				<input placeholder="Password" name="password" type="password" required="true">
			</div>
			<!-- checkbox -->
			<div class="wthree-text">
				<ul>
					<li>
						<!-- switch -->
						<div class="checkout-w3l">
							<div class="demo5">
								<div class="switch demo3">
									<input type="checkbox">
									<label>
										<i></i>
									</label>
								</div>
							</div>
							<a href="#">Stay Signed In</a>
						</div>
						<!-- //checkout -->
					</li>
					<li>
						<a href="#">Forgot Password?</a>
					</li>
				</ul>
			</div>
			<!-- //switch -->
			<input type="submit" value="Login">
</form>

</div>
	<!-- //content -->

	<!-- copyright -->
	<div class="footer">
		<p>&copy; 2019 QuickDeal Sign In Form. All rights reserved | Design by
			<a href="/">ARAVIND&CO</a>
		</p>
	</div>
	<!-- //copyright -->

</body>

</html>
