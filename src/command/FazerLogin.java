package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class FazerLogin implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		Usuario user = new Usuario(usuario, senha);
		RequestDispatcher view = null;
		HttpSession sessao = request.getSession();
		UsuarioService servico = new UsuarioService();

		if (servico.fazerLogin(user)) {
			sessao.setAttribute("logado", user);
			view = request.getRequestDispatcher("index.jsp");
		} else {
			view = request.getRequestDispatcher("Login.jsp");
		}

		view.forward(request, response);

	}

}
