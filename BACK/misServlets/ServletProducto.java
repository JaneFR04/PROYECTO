package misServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductoDTO;
import service.ProductoService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoService serviProducto = new ProductoService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String xtipo = request.getParameter("tipo");
		if (xtipo.equals("listar")) {
			listar(request, response);
		} else if (xtipo.equals("buscar"))
			buscar(request, response);
		else if (xtipo.equals("registrar"))
			registrar(request, response);
		else if (xtipo.equals("actualizar"))
			actualizar(request, response);
		else if (xtipo.equals("eliminar"))
			eliminar(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviProducto.listaProducto());
		request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		serviProducto.EliminaProducto(cod);
		listar(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Producto", serviProducto.buscaProducto(cod));
		request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int posicion, edad, cod;
		cod = Integer.parseInt(request.getParameter("txt_cod"));
		String nom = request.getParameter("txt_nom");
		String ape = request.getParameter("txt_ape");
		String apo = request.getParameter("txt_apo");
		String naci = request.getParameter("txt_naci");
		String club = request.getParameter("txt_club");
		edad = Integer.parseInt(request.getParameter("txt_edad"));
		double sue = Double.parseDouble(request.getParameter("txt_sue"));
		posicion = Integer.parseInt(request.getParameter("cbo_posicion"));
		ProductoDTO obj = new ProductoDTO();
		obj.setCodigo(cod);
		obj.setNombre(nom);
		obj.setApellido(ape);
		obj.setApodo(apo);
		obj.setNacionalidad(naci);
		obj.setClub(club);
		obj.setEdad(edad);
		obj.setSueldo(sue);
		obj.setCodPosicion(posicion);
		serviProducto.actualizaProducto(obj);
		listar(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int posicion, edad;
		String nom = request.getParameter("txt_nom");
		String ape = request.getParameter("txt_ape");
		String apo = request.getParameter("txt_apo");
		String naci = request.getParameter("txt_naci");
		String club = request.getParameter("txt_club");
		edad = Integer.parseInt(request.getParameter("txt_edad"));
		double sue = Double.parseDouble(request.getParameter("txt_sue"));
		posicion = Integer.parseInt(request.getParameter("cbo_posicion"));
		ProductoDTO obj = new ProductoDTO();
		obj.setNombre(nom);
		obj.setApellido(ape);
		obj.setApodo(apo);
		obj.setNacionalidad(naci);
		obj.setClub(club);
		obj.setEdad(edad);
		obj.setSueldo(sue);
		obj.setCodPosicion(posicion);
		serviProducto.registraProducto(obj);
		listar(request, response);
	}

}
