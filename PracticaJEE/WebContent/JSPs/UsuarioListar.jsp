<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Persona</title>
</head>
<body>
 <form action="../PersonaServlet"  method="post">

 <input type="submit" name="accion" value="Listar">
 
 </form>
 
 <table>
 	<thead>
 	<tr>
 		<th>Cedula  </th> 
 		<th> Nombre </th> 
 		<th> Apellido </th> 
 		<th> Correo  </th> 
 		<th> Contraseña </th> 
 	</tr>
 	
 	</thead>
 	<tbody>
 		
 		<c:forEach var="dato" items="${lista}">
 			<tr>
 				<td>${dato.getCedula()}</td> 
 				<td>${dato.getNombre()}  </td> 
 				<td>${dato.getApellido()} </td> 
 				<td>${dato.getCorreo()} </td>  
 				<td>${dato.getContrasena()} </td> 
 			</tr>
 	</c:forEach>
 	
	 
 	
 	</tbody>
 
 </table>
</body>
</html>