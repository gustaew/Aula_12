package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {

	public boolean buscar(Usuario usuario){

		String sql = "SELECT usuario,senha from usuario WHERE usuario = ? and senha = ?";
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			try (PreparedStatement stm = conn.prepareStatement(sql);) {
				stm.setString(1, usuario.getNomeUsuario());
				stm.setString(2, usuario.getSenha());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;

	}

}
