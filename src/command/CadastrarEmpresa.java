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

public class CadastrarEmpresa implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		EmpresaService servico = new EmpresaService();
		Empresa empresa = new Empresa();
		RequestDispatcher view = null;
		HttpSession sessao = request.getSession();

		try {

			String cnpj = request.getParameter("cnpj");
			String razaoSocial = request.getParameter("razao_social");
			String horarioInicio = request.getParameter("horario_Inicio");
			String horarioFim = request.getParameter("horario_Fim");
			String horarioArInicio = request.getParameter("horario_ArInicio");
			String horarioArFim = request.getParameter("horario_ArFim");
			int temperatura = -1;

			try {
				temperatura = Integer.parseInt(request.getParameter("Artemperatura"));
			} catch (Exception e) {
				e.printStackTrace();
			}

			empresa.setCNPJ(cnpj);
			empresa.setRazaoSocial(razaoSocial);
			empresa.setHorarioFim(horarioFim);
			empresa.setHorarioInicio(horarioInicio);
			empresa.setHorarioArInicio(horarioArInicio);
			empresa.setHorarioArFim(horarioArFim);
			empresa.setTemperatura(temperatura);

			if (empresa.getCNPJ().equals("") || empresa.getHorarioArFim().equals("")
					|| empresa.getHorarioArInicio().equals("") || empresa.getHorarioFim().equals("")
					|| empresa.getHorarioInicio().equals("") || empresa.getRazaoSocial().equals("")
					|| empresa.getTemperatura() == -1) {
				view = request.getRequestDispatcher("EmpresaCadastradaErro.jsp");
			} else {

				if (servico.criarEmpresa(empresa)) {
					ArrayList<Empresa> listaEmpresas = new ArrayList<>();
					listaEmpresas.add(empresa);
					sessao.setAttribute("empresas", listaEmpresas);
					view = request.getRequestDispatcher("EmpresaCadastrada.jsp");

				}

			}
		} catch (Exception e) {
			view = request.getRequestDispatcher("EmpresaCadastradaErro.jsp");
		}

		view.forward(request, response);
	}

}
