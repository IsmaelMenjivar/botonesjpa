package com.ismael.controladordedatos;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;
import javax.swing.text.html.parser.Entity;

import com.google.gson.Gson;
import com.ismael.DAO.ProductoDao;
import com.ismael.model.Productos1;


/**
 * Servlet implementation class ServeleteControler
 */
public class ServeleteControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeleteControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Productos1 pr = new Productos1(); 
		ProductoDao prd = new ProductoDao();
		String id = null;
		String nombrepr = null;
		String preciopr = null;
		String cantidadpr = null;
		String totalpr = null;
		try {
			id = request.getParameter("Id");
			nombrepr = request.getParameter("Nproductos");
			preciopr = request.getParameter("Pproductos");
			cantidadpr = request.getParameter("Cproductos");
			totalpr = request.getParameter("Tproductos");
			
			pr.setId(Integer.parseInt(id));
			pr.setNombre_Producto(nombrepr);
			pr.setPrecio_Producto(Double.parseDouble(preciopr));
			pr.setCantidad_Producto(Integer.parseInt(cantidadpr));
			pr.setTotal_Producto(Double.parseDouble(totalpr));
		}
		catch (Exception e) {
				// TODO: handle exception
			}
			
			String acction = request.getParameter("btn");
			
			if (acction.equals("GUARDAR")) {
				pr.setId(Integer.parseInt(id));
				pr.setNombre_Producto(nombrepr);
				pr.setPrecio_Producto(Double.parseDouble(preciopr));
				pr.setCantidad_Producto(Integer.parseInt(cantidadpr));
				pr.setTotal_Producto(Double.parseDouble(totalpr));
				 
				prd.agregardatos(pr);
			}
			 
			else if(acction.equals("ACTUALIZAR")){
				pr.setId(Integer.parseInt(id));
				pr.setNombre_Producto(nombrepr);
				pr.setPrecio_Producto(Double.parseDouble(preciopr));
				pr.setCantidad_Producto(Integer.parseInt(cantidadpr));
				pr.setTotal_Producto(Double.parseDouble(totalpr));
				 
				prd.actualizarDatos(pr);
			}else if(acction.equals("ELIMINAR")) {
				 
				pr.setId(Integer.parseInt(id));
				
				prd.eliminarDatos(pr);
			}
			response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductoDao prdao = new ProductoDao();
		
		Gson json = new Gson();
		
		try {
			response.getWriter().append(json.toJson(prdao.productoLista()));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
            
	}

}
