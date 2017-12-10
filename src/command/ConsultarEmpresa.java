package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Empresa;
import service.EmpresaService;

public class ConsultarEmpresa implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		EmpresaService servico = new EmpresaService();
		Empresa empresa = new Empresa();
		RequestDispatcher view = null;

		String cnpj = request.getParameter("cnpj");
		empresa.setCNPJ(cnpj);

		empresa = servico.ConsultarEmpresa(cnpj);

		if (!empresa.getCNPJ().isEmpty()) {

			request.setAttribute("empresa", empresa);
			view = request.getRequestDispatcher("ConsultarEmpresa.jsp");

		} else {
			view = request.getRequestDispatcher("ConsultarEmpresaErro.jsp");
		}
		view.forward(request, response);
	}

}
