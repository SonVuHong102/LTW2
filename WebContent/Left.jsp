<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
	<div class="card bg-light mb-3">
		<div class="card-header bg-primary text-white text-uppercase">
			<i class="fa fa-list"></i> Categories
		</div>
		<ul class="list-group category_block">
			<li class="list-group-item text-white"><a href="SvlHomePage">Tất cả</a></li>
			<c:forEach items="${listDanhMuc}" var="o">
				<li class="list-group-item text-white"><a href="SvlDanhMuc?id=${o.id}">${o.ten}</a></li>
			</c:forEach>

		</ul>
	</div>
	<div class="card bg-light mb-3">
		<div class="card-header bg-success text-white text-uppercase">Sản phẩm bán chạy</div>
		<div class="card-body">
			<c:forEach items="${listDeNghi}" var="o"> 
				<a href="SvlChiTiet?id=${o.id}"> <img class="img-fluid" src="${o.hinhanh}" /> </a>
				<h5 class="card-title"><a href="SvlChiTiet?id=${o.id}">${o.ten}</a></h5>
				<p class="card-text">${o.mota}</p>
				<p class="bloc_left_price">Đã bán : ${o.tieuthu}</p>
			</c:forEach>
		</div>
	</div>
</div>