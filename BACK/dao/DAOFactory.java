package dao;

import interfaces.EmpleadoDAO;
import interfaces.ProductoDAO;

public abstract class DAOFactory {
	//los posibles origenes de datos
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int DB2 = 3;
	public static final int SQLSERVER = 4;
	public static final int XML = 5;
	
	/*
	 * Existirá un metodo get por cada DAO que exista en el sistema.
	 * Ejemplo:
	 * public abstract ArticuloDAO getArticuloDAO();
	 * registramos nuestros daos
	 */
	
	public abstract ProductoDAO getProducto();
	public abstract EmpleadoDAO getEmpleado();
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch(whichFactory){
		case MYSQL:
			return new MySqlDAOFactory();
		case XML:
			//return new XmlDAOFactory();
		case ORACLE:
			//return new OracleDAOFactory();
		}
		return null;
	}
}
