package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ProductoDTO;
import interfaces.ProductoDAO;
import utils.MysqlDBConexion;

/*
 * Esta clase tiene los metodos necesarios para manipular los productos
 */
public class MySqlProductoDAO implements ProductoDAO {

	@Override
	public List<ProductoDTO> listarProducto() {
		List<ProductoDTO> data = new ArrayList<ProductoDTO>();
		ProductoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select j.cod_ju, j.nom_ju, j.ape_ju, j.apo_ju, j.naci_ju, j.club_ju, j.edad_ju, j.sue_ju, p.nom_po from tb_jugador j inner join tb_posicion p on j.cod_po=p.cod_po";
			System.out.println("before executing query: " + sql);
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				obj = new ProductoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setApellido(rs.getString(3));
				obj.setApodo(rs.getString(4));
				obj.setNacionalidad(rs.getString(5));
				obj.setClub(rs.getString(6));
				obj.setEdad(rs.getInt(7));
				obj.setSueldo(rs.getDouble(8));
				obj.setNomPosicion(rs.getString(9));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int registrarProducto(ProductoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into tb_jugador values(null,?,?,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setString(3, obj.getApodo());
			pstm.setString(4, obj.getNacionalidad());
			pstm.setString(5, obj.getClub());
			pstm.setInt(6, obj.getEdad());
			pstm.setDouble(7, obj.getSueldo());
			pstm.setInt(8, obj.getCodPosicion());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int actualizarProducto(ProductoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update tb_jugador set nom_ju=?, ape_ju=?, apo_ju=?, naci_ju=?, club_ju=?, edad_ju=?, sue_ju=?, cod_po=? where cod_ju=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setString(3, obj.getApodo());
			pstm.setString(4, obj.getNacionalidad());
			pstm.setString(5, obj.getClub());
			pstm.setInt(6, obj.getEdad());
			pstm.setDouble(7, obj.getSueldo());
			pstm.setInt(8, obj.getCodPosicion());
			pstm.setInt(9, obj.getCodigo());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int eliminarProducto(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from tb_jugador where cod_ju=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public ProductoDTO buscarProducto(int cod) {
		ProductoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from tb_jugador where cod_ju=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new ProductoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setApellido(rs.getString(3));
				obj.setApodo(rs.getString(4));
				obj.setNacionalidad(rs.getString(5));
				obj.setClub(rs.getString(6));
				obj.setEdad(rs.getInt(7));
				obj.setSueldo(rs.getDouble(8));
				obj.setNomPosicion(rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return obj;
	}

}
