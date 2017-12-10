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

public class ExcluirEmpresa implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		EmpresaService servico = new EmpresaService();
		Empresa empresa = new Empresa();
		RequestDispatcher view = null;
		HttpSession sessao = request.getSession();
		String cnpj = request.getParameter("cnpj");
		empresa.setCNPJ(cnpj);

		try {

			servico.excluirEmpresa(empresa.getCNPJ());
			ArrayList<Empresa> lista = (ArrayList<Empresa>) sessao.getAttribute("empresas");
			lista.remove(buscar(lista, empresa));
			sessao.setAttribute("empresas", lista);
			view = request.getRequestDispatcher("ExcluirEmpresa.jsp");

		} catch (Exception e) {
			view = request.getRequestDispatcher("ExcluirEmpresaErro.jsp");
		}

		view.forward(request, response);

	}

	public Empresa buscar(ArrayList<Empresa> lista, Empresa empresa) {
		for (int d = 0; d < lista.size(); d++) {
			if (lista.get(d).getCNPJ().equals(empresa.getCNPJ())) {
				return lista.get(d);
			}
		}
		return null;
	}

}
