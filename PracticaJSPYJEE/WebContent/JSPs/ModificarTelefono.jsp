<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Telefono</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Bienvenido</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/PracticaJSPYJEE/ModificarTelefonoServlet?accion=Listar" >Listar Telefono</a>
      </li>
         <li class="nav-item">
        <a class="nav-link" href="/PracticaJSPYJEE/ModificarTelefonoServlet?accion=Registrar">Registrar Telefono</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="/PracticaJSPYJEE/ModificarTelefonoServlet?accion=Eliminar">Eliminar Telefono</a>
      </li>
     
    </ul>
  </div>
</nav>
<form  method="POST" action="/PracticaJSPYJEE/ModificarTelefonoServlet">

		<label for="numero">Id:(*)</label>
		 <input type="text" id="id" name="id"  placeholder="Ingrese el numero telefono ..."/>
		<br>
		
		 <label for="numero">Numero:(*)</label>
		 <input type="text" id="numerom" name="numerom" minlength="10" maxlength="10" 
		 placeholder="Ingrese el numero telefono ..."/>
		<br>
		<a>${telefono}</a>
		<label for="tipo">Tipo:(*)</label>
		<input type="text" id="tipom" name="tipom"  placeholder="Ingrese tipo de telefono ..."/>
		<br>
		 <label for="operadora">Operadora:(*)</label>
		 <input type="text" id="operadoram" name="operadoram" 
		 placeholder="Ingrese la operadora ..."/>
		<br>
		<input type="submit" id="modificar" name="accion" value="Modificar" />
		<input type="reset" id="cancelar" name="cancelar" value="Cancelar" />
</form>
</body>
</html>