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

@WebServlet("/empresaControle")
public class EmpresaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String SALVAR_EMPRESA = "Salvar";
	private static final String CONSULTAR_EMPRESA = "Consultar";
	private static final String ATUALIZAR_EMPRESA = "Atualizar";
	private static final String EDITAR_EMPRESA = "Editar";
	private static final String EXCLUIR_EMPRESA = "Excluir";

	public EmpresaController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("opcao");

		EmpresaService servico = new EmpresaService();
		Empresa empresa = new Empresa();
		RequestDispatcher view = null;
		HttpSession sessao = request.getSession();

		if (acao.equals(SALVAR_EMPRESA)) {

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
		}

		if (acao.equals(EDITAR_EMPRESA)) {

			String cnpj = request.getParameter("cnpj");
			empresa.setCNPJ(cnpj);

			Empresa emp = servico.ConsultarEmpresa(empresa.getCNPJ());
			sessao.setAttribute("empresa", emp);
			view = request.getRequestDispatcher("AtualizarEmpresa.jsp");
		}

		if (acao.equals(CONSULTAR_EMPRESA)) {

			String cnpj = request.getParameter("cnpj");
			empresa.setCNPJ(cnpj);

			empresa = servico.ConsultarEmpresa(cnpj);

			if (!empresa.getCNPJ().isEmpty()) {

				request.setAttribute("empresa", empresa);
				view = request.getRequestDispatcher("ConsultarEmpresa.jsp");

			} else {
				view = request.getRequestDispatcher("ConsultarEmpresaErro.jsp");
			}

		}
		if (acao.equals(ATUALIZAR_EMPRESA)) {

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
					view = request.getRequestDispatcher("AtualizarEmpresaErro.jsp");
				} else {

					if (servico.atualizarEmpresa(empresa)) {

						empresa = servico.ConsultarEmpresa(cnpj);
						request.setAttribute("empresa", empresa);
						view = request.getRequestDispatcher("ConsultarEmpresa.jsp");
					} else {
						view = request.getRequestDispatcher("AtualizarEmpresaErro.jsp");
					}

				}
			} catch (Exception e) {
				view = request.getRequestDispatcher("AtualizarEmpresaErro.jsp");
			}

		}

		if (acao.equals(EXCLUIR_EMPRESA)) {

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
