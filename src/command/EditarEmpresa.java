package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Empresa;
import service.EmpresaService;

public class EditarEmpresa implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		EmpresaService servico = new EmpresaService();
		Empresa empresa = new Empresa();
		RequestDispatcher view = null;
		HttpSession sessao = request.getSession();

		String cnpj = request.getParameter("cnpj");
		empresa.setCNPJ(cnpj);

		Empresa emp = servico.ConsultarEmpresa(empresa.getCNPJ());
		sessao.setAttribute("empresa", emp);
		view = request.getRequestDispatcher("AtualizarEmpresa.jsp");

		view.forward(request, response);
	}

}
