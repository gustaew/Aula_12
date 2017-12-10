package webservice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpresaService;
import util.JSONConverter;

@WebServlet("/listarEmpresaWS")
public class ListarEmpresaWS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarEmpresaWS() {
		super();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		EmpresaService servico = new EmpresaService();

		if (nome.length() > 0 && nome != null) {
			response.getWriter().println(JSONConverter.listEmpresaToJSON(servico.listar(nome)));
		} else {
			response.getWriter().println(JSONConverter.listEmpresaToJSON(servico.listar()));
		}

	}

}
