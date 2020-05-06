<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Usuario</title>
</head>
<body>
   <h1>Formulario</h1>
          <form action="../InsertarTelefonoServlet" method="post" >
                <label for="numero">Numero:</label>
                <input type="text" id="numero" name="numero" minlength="10" maxlength="10" "/>
                <br>

                  <label for="tipo">Tipo:</label>
                  <input type="text" id="tipo" name="tipo" />
                  <br>

                  <label for="operadora">Operadora:</label>
                  <input type="text" id="operadora" name="operadora" />
                        
                <br>
                  <input type="submit" id="crear" value="Aceptar" name="crear"/>
                  <br>
                  <input type="reset" id="cancelar" name="cancelar" name="cancelar" value="Cancelar" />

                  <br>
                 
          </form>
</body>
</html>