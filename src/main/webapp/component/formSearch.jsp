<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.searchSection {
	background-color: green;
	height: 100vh;
}

.search {
	background-color: white;
	padding: 10px;
	width: 55%;
	border-radius: 10px;
	margin-left: 10%;
	position: absolute;
	margin-top: 10%;
}

.btn {
	background-color: green;
	border-radius: 5px;
	color: white;
	font-weight: bold;
	cursor: pointer;
	width: 120px;
	transition: 0.5s ease;
}

.btn:hover {
	border-color: white;
	color: black;
	background-color: #A6CF98;
}

input {
	padding: 10px;
	border-radius: 10px;
}

.input-label {
	display: flex;
	flex-direction: column;
	margin-right: 10px;;
}

form {
	display: flex;
	flex-direction: row;
}
</style>
</head>
<body>
	<div class="searchSection">
		<div class="search">
			<form action="medecinController" method="post">
				<div class="input-label">
					<label>Nom</label> <input type="text" name="name">
				</div>
				<div class="input-label">
					<label>Spécialité</label> <input type="text" name="specialite">
				</div>
				<div class="input-label">
					<label>Adresse</label> <input type="text" name="adresse">
				</div>
				<input type="submit" value="Recherche" class="btn">
			</form>
		</div>
	</div>
	<div></div>
</body>
</html>