<%@page import="entity.Medecin"%>
<%@page import="dao.MedecinDao"%>
<%@page import="dao.MedecinDaoImpl"%>

<%@page import="entity.User"%>
<%@page import="entity.Rdv"%>
<%@page import="java.util.List"%>
<%@page import="connection.SingletonConnection"%>
<%@page import="dao.RdvDao"%>
<%@page import="dao.RdvDaoImpl"%>
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
<!-- for responsive -->
<!-- <meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!-- for responsive -->
<title>Consulter Rendus-vous</title>

<!-- all css include -->
<%@include file="../component/allcss.jsp"%>

<!-- customs css for this page -->
<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px maroon;
	/*box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);*/
}

/* backgournd image css */
.my-bg-img {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/hospital1.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}

/* backgournd image css */
</style>
<!-- end of customs css for this page -->


</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<!-- if not login then log in first -->
	<c:if test="${empty userObj }">

		<c:redirect url="/user_login.jsp"></c:redirect>

	</c:if>

	<!-- start 1st Div -->

	<div class="container-fluid my-bg-img p-5">
		<!-- css background image -->
		<p class="text-center fs-2 text-white"></p>

	</div>

	<!-- end of 1st Div -->

	<!-- 2nd Div -->

	<div class="container-fluid p-3">
		<p class="fs-2"></p>

		<div class="row">



			<!-- col-2 -->
			<div class="col-md-9">
				<div class="card my-card">
					<div class="card-body">
						<p class="fw-bold text-center myP-color fs-4">Liste Rendus-vous</p>

						<%-- <!-- message print -->
						<!-- for success msg -->
						<c:if test="${not empty successMsg }">
							<p class="text-center text-success fs-5">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<!-- for error msg -->
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<!-- End of message print --> --%>

						<table class="table table-striped">
							<thead>
								<tr class="my-bg-color text-white">
									<!-- <th scope="col">Id</th> -->
									<th scope="col">Nom</th>
									<th scope="col">Gendre</th>
									<th scope="col">Age</th>
									<th scope="col">Date</th>
									<th scope="col">Horaire</th>
									<!-- <th scope="col">Email</th> -->
									<th scope="col">Phone</th>
									<th scope="col">Diseases</th>
									<th scope="col">Nom Medecin</th>
									<!-- <th scope="col">Addressz</th> -->
									<!-- <th scope="col">User Id</th> -->
									<th scope="col">Status</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								User user = (User) session.getAttribute("userObj");
								
								// Create Connection with DB
								SingletonConnection singleton = SingletonConnection.getInstance();

								

								MedecinDao dDAO = new MedecinDaoImpl(singleton.getConnection());

								RdvDao appDAO = new RdvDaoImpl(singleton.getConnection());

								List<Rdv> list = appDAO.getAllRdvsByUser(user.getId());
								for (Rdv apptList : list) {
									Medecin medecin = dDAO.getMedecinById(apptList.getMedcinId());
								%>


								<tr>
									<%-- <th scope="row"><%= apptList.getId() %></th> --%>
									<td><%=apptList.getNom()%></td>
									<td><%=apptList.getGendre()%></td>
									<td><%=apptList.getAge()%></td>
									<td><%=apptList.getDate()%></td>
									<td><%=apptList.getTemps()%></td>
									<%-- <td><%= apptList.getEmail()%></td> --%>
									<td><%=apptList.getPhone()%></td>
									<td><%=apptList.getDiseases()%></td>
									<td><%=medecin.getNom()%></td>
									<%-- <td><%= apptList.getAddress()%></td> --%>
									<%-- <td><%= apptList.getUserId()%></td> --%>
									<td>
										<%
										if ("Pending".equals(apptList.getStatus())) {
										%> <a href="confirmRdv?id=<%=apptList.getId()%>&mail=<%=apptList.getEmail()%>" class="btn btn-sm btn-warning">Pending</a> <%
 } else if ("Confirmed".equals(apptList.getStatus())) {
		%> <a href="" class="btn btn-sm btn-success" >Confirmed</a> <%
}  else {
 %> <%=apptList.getStatus()%> <%
 }
 %>
									</td>
									<td><a class="btn btn-sm btn-danger" href="deleteRdv?id=<%=apptList.getId()%>">Supprimer</a></td>


								</tr>


								<%
								}
								%>


							</tbody>
						</table>




					</div>
				</div>

			</div>

			<!-- col-1 -->
			<div class="col-md-3 p-3">
				<!-- for Background image -->
				<!-- <img alt="" src="img/picDoc.jpg" width="500px" height="400px"> -->
				<img alt="" src="img/wdoc.jpg" width="250" height="">
			</div>



		</div>


	</div>

	<!-- 2nd Div -->




</body>
</html>