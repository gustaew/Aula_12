package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Empresa;
import service.EmpresaService;

public class GerenciarEmpresa implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpSession sessao = request.getSession();
		sessao.setAttribute("empresas", null);

		RequestDispatcher view = request.getRequestDispatcher("GerenciarEmpresas.jsp");
		view.forward(request, response);
	}

}
