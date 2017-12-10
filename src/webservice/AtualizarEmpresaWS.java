package webservice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empresa;
import service.EmpresaService;
import util.JSONConverter;


@WebServlet("/atualizarEmpresaWS")
public class AtualizarEmpresaWS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AtualizarEmpresaWS() {
        super();
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("application/json");
    	response.setCharacterEncoding("utf-8");
    	super.service(request, response);
    }

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = JSONConverter.criarJSON(request);
		Empresa empresa = JSONConverter.jsonToEmpresa(json);
		EmpresaService servico = new EmpresaService();
		servico.atualizarEmpresa(empresa);
	}

}
