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

public class PesquisarEmpresa implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String pesquisado = request.getParameter("empresaPesquisada");
		HttpSession sessao = request.getSession();
		ArrayList<Empresa> listaEmpresas = null;
		EmpresaService servico = new EmpresaService();

		if (pesquisado.isEmpty()) {
			listaEmpresas = servico.listar();
		} else {
			listaEmpresas = servico.listar(pesquisado);
		}

		sessao.setAttribute("empresas", listaEmpresas);

		RequestDispatcher view = request.getRequestDispatcher("GerenciarEmpresas.jsp");
		view.forward(request, response);
	}

}
