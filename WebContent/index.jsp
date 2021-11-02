<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item active" aria-current="#">${}</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<jsp:include page="Left.jsp"></jsp:include>
			<div class="col-sm-9">
				<div class="row">
					<c:forEach items="${listSanPham}" var="o">
						<div class="col-12 col-md-6 col-lg-4">
							<div class="card">
								<a href="SvlChiTiet?id=${o.id}"> <img class="card-img-top"
									src="${o.hinhanh}" alt="Card image cap">
								</a>
								<div class="card-body">
									<h4 class="card-title show_txt">
										<a href="SvlChiTiet?id=${o.id}" title="${o.ten}">${o.ten}</a>
									</h4>
									<p class="card-text show_txt">${o.tieude}</p>
									<div class="row">
										<div class="col">
											<p class="btn btn-danger btn-block">${o.gia}</p>
										</div>
										<div class="col">
											<a href="#" class="btn btn-success btn-block">Add to cart</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<jsp:include page="Footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>

