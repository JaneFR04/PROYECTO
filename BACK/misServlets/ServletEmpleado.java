package misServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.EmpleadoDTO;
import service.EmpleadoService;

/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpleadoService servicio = new EmpleadoService();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String xtipo = request.getParameter("tipo");
		if (xtipo.equals("sesion"))
			iniciarSesion(request, response);
		else if (xtipo.equals("cerrarSesion"))
			cerrarSesion(request, response);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEmpleado() {
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

	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.setAttribute("msg", "Iniciar sesión");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String xlogin = request.getParameter("txt_login");
		String xpass = request.getParameter("txt_pass");
		System.out.println("login: " + xlogin);
		System.out.println("pass: " + xpass);
		EmpleadoDTO obj = servicio.iniciaSesion(xlogin);
		if (obj != null) {
			if (obj.getPassword().equals(xpass)) {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("datos", obj);
				request.getRequestDispatcher("encabezado.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Contraseña incorrecta...");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("msg", "Usuario no existe...");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
