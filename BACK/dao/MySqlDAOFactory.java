package dao;

import interfaces.EmpleadoDAO;
import interfaces.ProductoDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public ProductoDAO getProducto() {
		// TODO Auto-generated method stub
		//yo le hubiera puesto getProductoDAO, el nombre como esta da la idea que se va a retornar un producto
		return new MySqlProductoDAO();
	}

	@Override
	public EmpleadoDAO getEmpleado() {
		// TODO Auto-generated method stub
		return new MySqlEmpleadoDAO();
	}

}
