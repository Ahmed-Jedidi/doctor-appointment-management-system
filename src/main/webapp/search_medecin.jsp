<%@page import="dao.MedecinDao"%>
<%@page import="entity.Medecin"%>
<%@page import="dao.MedecinDaoImpl"%>
<%@page import="entity.Specialite"%>
<%@page import="java.util.List"%>
<%@page import="connection.SingletonConnection"%>
<%@page import="dao.SpecialiteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- for jstl tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- end of jstl tag -->

<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor page</title>
<%@include file="../component/allcss.jsp"%>

<!-- customs css for this page -->
<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px maroon;
	/*box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);*/
}
</style>
<!-- end of customs css for this page -->

</head>
<body>
	<%@include file="component/navbar.jsp"%>


	<div class="sectionSearch justify-content-center h-100 d-flex align-items-center justify-content-center ">
		<form action="SearchMedecinServlet" method="post">
			<div>
				<label>Nom</label><br> <input type="text" value="${model.nom}" name="nom">
			</div>
			<div>
				<label>Spécialité</label><br> <input type="text" value="${model.specialite}" name="specialite">
			</div>
			<div>
				<label>Adresse</label><br> <input type="text" value="${model.adresse}" name="adresse">
			</div>
			<p></p>
			<!-- <input type="submit" value="Recherche" class="btn">  -->
			<button type="submit" class="btn btn-primary mb-2">Recherche</button>
		</form>
	</div>

	<div class="container-fluid p-3">
		<div class="row">
			
			<div class="col-md-12">
				<div class="card my-card">
					<div class="card-body">
						<p class="fs-3 text-center text-danger">Liste des medecins</p>

						<!-- message print -->
						<!-- for success msg -->
						<c:if test="${not empty successMsg }">
							<p class="text-center text-success fs-3">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<!-- for error msg -->
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-3">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<!-- End of message print -->

						<!-- table for doctor list -->

						<table class="table table-striped">
							<thead>
								<tr class="table-info">
									<!-- <th scope="col">ID</th> -->
									<th scope="col">Nom</th>
									<th scope="col">Spécialité</th>
									<th scope="col">Ville</th>
									<th scope="col">Adresse</th>
									<th scope="col">Email</th>
									<th scope="col">Téléphone</th>
									<th colspan="2" class="text-center" scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${ modele.medecins }" var="m">
								<tr>
									<%-- <th scope="row"><%= doctorLst.getId()%></th> --%>
									<th>${ m.getNom() }</th>
									<td>${ m.getSpecialite() }</td>
									<td>${ m.getVille() }</td>
									<td>${ m.getAdresse() }</td>
									<td>${ m.getEmail() }</td>
									<td>${ m.getPhone() }</td>


									<td><a class="btn btn-sm btn-success" href="user_rdv.jsp?id=${m.getId()}">Prend Rendus-vous</a></td>



								</tr>
								</c:forEach>


							</tbody>
						</table>

						<!-- end table for doctor list -->


					</div>

				</div>
			</div>
		</div>
	</div>









</body>
</html>