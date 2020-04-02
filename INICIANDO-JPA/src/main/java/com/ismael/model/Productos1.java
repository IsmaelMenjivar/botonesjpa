package com.ismael.model;

import java.io.Serializable;
import javax.persistence.*;


/**1
 * The persistent class for the productos1 database table.
 * 
 */
@Entity
@NamedQuery(name="Productos1.findAll", query="SELECT p FROM Productos1 p")
public class Productos1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cantidad_Producto;

	private String nombre_Producto;

	private double precio_Producto;

	private double total_Producto;

	public Productos1() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad_Producto() {
		return this.cantidad_Producto;
	}

	public void setCantidad_Producto(int cantidad_Producto) {
		this.cantidad_Producto = cantidad_Producto;
	}

	public String getNombre_Producto() {
		return this.nombre_Producto;
	}

	public void setNombre_Producto(String nombre_Producto) {
		this.nombre_Producto = nombre_Producto;
	}

	public double getPrecio_Producto() {
		return this.precio_Producto;
	}

	public void setPrecio_Producto(double precio_Producto) {
		this.precio_Producto = precio_Producto;
	}

	public double getTotal_Producto() {
		return this.total_Producto;
	}

	public void setTotal_Producto(double total_Producto) {
		this.total_Producto = total_Producto;
	}

}