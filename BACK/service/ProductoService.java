package service;

import java.util.List;

import beans.ProductoDTO;
import dao.DAOFactory;
import interfaces.ProductoDAO;
import utils.Constantes;

public class ProductoService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ProductoDAO objPro = fabrica.getProducto();

	public List<ProductoDTO> listaProducto() {
		return objPro.listarProducto();
	}

	public ProductoDTO buscaProducto(int cod) {
		return objPro.buscarProducto(cod);
	}

	public int registraProducto(ProductoDTO obj) {
		return objPro.registrarProducto(obj);
	}

	public int actualizaProducto(ProductoDTO obj) {
		return objPro.actualizarProducto(obj);
	}

	public int EliminaProducto(int cod) {
		return objPro.eliminarProducto(cod);
	}
}
