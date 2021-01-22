package ec.ups.edu.g2.appdis.ExamenWSCuji.cliRest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import ec.ups.edu.g2.appdis.ExamenWSCuji.modelo.Cliente;
import ec.ups.edu.g2.appdis.ExamenWSCuji.modelo.Compra;
import ec.ups.edu.g2.appdis.ExamenWSCuji.modelo.Producto;


public class CompraREST {
	
	private String WS_GET_CREARPERSONA = "http://localhost:8080/ExamenWSCuji/rest/compra/guardarCliente";
	private String WS_GET_BUSCAPRODCUTO = "http://localhost:8080/ExamenWSCuji/rest/compra/buscarProducto";
	private String WS_GET_CREARCOMPRA = "http://localhost:8080/ExamenWSCuji/rest/compra/guardarCompra";

	
	public Producto buscarProducto(String codigo) {
		Client c =  ClientBuilder.newClient();
		WebTarget target = c.target(WS_GET_BUSCAPRODCUTO).queryParam("codigo", codigo);
		Producto p = target.request().get(Producto.class);
		c.close();
		return p;
	} 
	
	public Respuesta crearCLiente(String cedula, String nombres, String apellidos, String correo) {
		Cliente c = new Cliente();
		c.setCedula(cedula);
		c.setNombres(nombres);
		c.setApellidos(apellidos);
		c.setCorreo(correo);
		Client cb = ClientBuilder.newClient();
		WebTarget target = cb.target(WS_GET_CREARPERSONA);
		Respuesta res = target.request().post(Entity.json(c), Respuesta.class);
		return res;

	}
	
	public Respuesta crearCompra(double total, Cliente cliente, Producto producto) {
		Compra c = new Compra();
		c.setTotal(total);
		c.setCliente(cliente);
		c.setProducto(producto);
		Client cb = ClientBuilder.newClient();
		WebTarget target = cb.target(WS_GET_CREARCOMPRA);
		Respuesta res = target.request().post(Entity.json(c), Respuesta.class);
		return res;

	}
}
