package service;

import beans.EmpleadoDTO;
import dao.DAOFactory;
import interfaces.EmpleadoDAO;
import utils.Constantes;

public class EmpleadoService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	EmpleadoDAO objEmpDAO = fabrica.getEmpleado();
	
	public EmpleadoDTO iniciaSesion(String login) {
		return objEmpDAO.iniciarSesion(login);
	}
}
