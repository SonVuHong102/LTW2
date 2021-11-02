<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>

<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="shopping-cart">
		<div class="px-4 px-lg-0">

			<div class="pb-5">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

							<!-- Shopping cart table -->
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th scope="col" class="border-0 bg-light">
												<div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Đơn Giá</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Số Lượng</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Xóa</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${sessionScope.listDC}" var="o">
											<tr>
												<th scope="row">
													<div class="p-2">
														<img src="${o.hinhanh}" alt="" width="70"
															class="img-fluid rounded shadow-sm">
														<div class="ml-3 d-inline-block align-middle">
															<h5 class="mb-0">
																<a href="SvlChiTiet?id=${o.id}" class="text-dark d-inline-block">${o.ten}</a>
															</h5>
															<span class="text-muted font-weight-normal font-italic"></span>
														</div>
													</div>
												</th>
												<td class="align-middle">
													<strong><fmt:formatNumber type="number" maxFractionDigits="3" value="${o.gia}" /></strong></td>
												<td class="align-middle">
													<a href="SvlGiam?sanphamID=${o.id}"> <button class="btnSub">-</button></a> 
													<strong>${o.soluong}</strong> 
													<a href="SvlTang?sanphamID=${o.id}"><button class="btnAdd">+</button></a></td>
												<td class="align-middle"><a href="SvlXoa?id=${o.id}" class="text-dark">
														<button type="button" class="btn btn-danger">Delete</button>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- End -->
						</div>
					</div>

					<div class="row py-5 p-4 bg-white rounded shadow-sm">
						<div class="col-lg-6">
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
							<div class="p-4">
								<ul class="list-unstyled mb-4">
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tổng tiền hàng</strong><strong>
										<fmt:formatNumber type="number" maxFractionDigits="3" value="${tongtien}" /> VND</strong>
									</li>
									<li class="d-flex justify-content-between py-3 border-bottom">
										<strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom">
										<c:set var="VAT" value="${tongtien/10}"/>
										<strong class="text-muted">VAT</strong><strong>${VAT} VND</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom">
										<strong class="text-muted">Tổng thanh toán</strong>
										<h5 class="font-weight-bold">
											<fmt:formatNumber type="number" maxFractionDigits="3" value="${tongtien + VAT}" /> VND </h5>
									</li>
								</ul>
								<a href="SvlMuaHang" class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</a>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>

</html>
</html>
