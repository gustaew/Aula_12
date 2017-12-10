package webservice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpresaService;

@WebServlet("/excluirEmpresaWS")
public class ExcluirEmpresaWS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirEmpresaWS() {
		super();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		super.service(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cnpj = request.getParameter("cnpj");
		EmpresaService servico = new EmpresaService();
		servico.excluirEmpresa(cnpj);
	}

}
