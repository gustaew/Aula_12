package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
	private UsuarioDAO dao;

	public UsuarioService() {
		dao = new UsuarioDAO();
	}

	public boolean fazerLogin(Usuario usuario) {
		return dao.buscar(usuario);
	}

}
