<html>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js">
</script>

<script type="text/javascript">
	$(document).ready(function (){
		
			var btn = $('#carga').val();
			$.post('ServeleteControler',{

			}, function(respose){
			let datos = JSON.parse(respose);
			//  console.log(datos);
			var tabladatos = document.getElementById('tablaDatos');
			for(let item of datos){
/* 				console.log(item.id);			
 */				tabladatos.innerHTML +=`
					<tr>
					<td>${item.id}</td>
					<td>${item.cantidad_Producto}</td>
					<td>${item.nombre_Producto}</td>
					<td>${item.precio_Producto}</td>
					<td>${item.total_Producto}</td>
					<td>
					<a href="ServeleteControler?btn=ELIMINAR&Id=${item.id}" class="btn btn-warning">ELIMINAR</a>
					<a href="funciones.jsp?idBus=${item.id}&Npr=${item.nombre_Producto}&PrecioPr=${item.precio_Producto}&CantidadPr=${item.cantidad_Producto}&TotalPr=${item.total_Producto}" class="btn btn-danger">ACTUALIZAR</a>
					</td>
					
					</tr>
					 
					`
					}
			
			});
	});
</script>
<body>
	
 	<a href="funciones.jsp" class="btn btn-info">AGREGAR</a>
 
	
	<table class="table table-dark" id="tablaDatos">
		<thead>
			<th>ID</th>
			<th>NOMBRE</th>
			<th>PRECIO</th>
			<th>CANTIDAD</th>
			<th>TOTAL</th>
			<th>OPCIONES</th>
		</thead>
		
		<tbody></tbody>
	</table>
</body>
</html>