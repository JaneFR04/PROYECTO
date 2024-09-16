package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.EmpleadoDTO;
import interfaces.EmpleadoDAO;
import utils.MysqlDBConexion;

public class MySqlEmpleadoDAO implements EmpleadoDAO {

	@Override
	public EmpleadoDTO iniciarSesion(String login) {
		EmpleadoDTO em = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from tb_empleado where login_emp=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, login);
			rs = pstm.executeQuery();
			if (rs.next()) {
				em = new EmpleadoDTO();
				em.setCodigo(rs.getInt(1));
				em.setNombres(rs.getString(2));
				em.setApellidos(rs.getString(3));
				em.setLogin(rs.getString(4));
				em.setPassword(rs.getString(5));
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
		return em;
	}

}
