<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar Telefono</title>
</head>
<body>
<form id="formulario01" method="POST" action="../../controladores/user/modificar.php"><input type="hidden" id="codigo" name="codigo" value="<?php echo $codigo ?>" />
 <label for="numero">Numero:(*)</label>
 <input type="text" id="numero" name="numero" minlength="10" maxlength="10" 
required placeholder="Ingrese el numero telefono ..."/>
<br>

<label for="tipo">Tipo:(*)</label>
<input type="text" id="tipo" name="tipo"  required placeholder="Ingrese tipo de telefono ..."/>
<br>
 <label for="operadora">Operadora:(*)</label>
 <input type="text" id="operadora" name="operadora" 
required placeholder="Ingrese la operadora ..."/>
<br>
<input type="submit" id="modificar" name="modificar" value="Modificar" />
<input type="reset" id="cancelar" name="cancelar" value="Cancelar" /></form>

</body>
</html>