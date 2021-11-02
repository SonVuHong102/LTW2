<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="SvlHomePage">Shoes</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
			<ul class="navbar-nav m-auto">
				<c:if test="${sessionScope.nguoidung != null}">
					<li class="nav-item"><a class="nav-link" href="#">Hello ${sessionScope.nguoidung.name}</a></li>
					<li class="nav-item"><a class="nav-link" href="SvlDangXuat">Logout</a></li>
				</c:if>
				<c:if test="${sessionScope.nguoidung == null}">
					<li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a>
				</c:if>
				</li>
			</ul>

		</div>
	</div>
</nav>
<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">Siêu thị giày chất lượng cao</h1>
	</div>
</section>
<!--end of menu-->
