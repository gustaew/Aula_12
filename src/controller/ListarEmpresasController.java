package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Empresa;
import service.EmpresaService;

@WebServlet("/listaEmpresas")
public class ListarEmpresasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarEmpresasController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		String pesquisado = request.getParameter("empresaPesquisada");
		HttpSession sessao = request.getSession();
		ArrayList<Empresa> listaEmpresas = null;
		EmpresaService servico = new EmpresaService();

		if (acao.equals("buscar")) {

			if (pesquisado.isEmpty()) {
				listaEmpresas = servico.listar();
			} else {
				listaEmpresas = servico.listar(pesquisado);
			}

		} else if (acao.equals("reiniciar")) {
			sessao.setAttribute("empresas", null);
		}

		sessao.setAttribute("empresas", listaEmpresas);

		RequestDispatcher view = request.getRequestDispatcher("GerenciarEmpresas.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
