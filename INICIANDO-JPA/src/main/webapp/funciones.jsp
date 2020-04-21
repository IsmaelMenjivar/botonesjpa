<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String idBus = request.getParameter("idBus");
String nombrePr = request.getParameter("Npr");
String cantidadPr = request.getParameter("CantidadPr");
String precioPr = request.getParameter("PrecioPr");
String totalPr = request.getParameter("TotalPr");
if(idBus==null){
	
	idBus="";
	nombrePr="";
	cantidadPr="";
	precioPr="";
	totalPr="";
	
}
%>
<body>

 <form action="ServeleteControler">
<table align="center">	
		<thead>
			
		</thead>
		<tbody>
			<tr>
				<td>
					
						<p>id</p><input type="text" name="Id" value="<%=idBus %>">
						<p>Nombre producto</p><input type="text" name="Nproductos" value="<%=nombrePr %>">
						<p>Precio producto</p><input type="text" name="Pproductos" value="<%=precioPr %>">
						<p>Cantidad de producto</p><input type="text" name="Cproductos" value="<%=cantidadPr %>">
						<p>Total de producto</p><input type="text" name="Tproductos" value="<%=totalPr %>">
						<br>
						<br>
				</td>
			</tr>
		</tbody>
	</table>
<input type="submit" class="btn btn-info" value="GUARDAR" name="btn">
<input type="submit" class="btn btn-info" value="ACTUALIZAR" name="btn">
</form>
</body>
</html>