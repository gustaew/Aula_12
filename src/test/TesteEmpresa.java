package test;

import model.Empresa;
import service.EmpresaService;

public class TesteEmpresa {
	public static void main(String[] args) {

		Empresa empresatest = new Empresa();

		empresatest.setCNPJ("47.231.884/2318-80");
		empresatest.setRazaoSocial("Studio MixFhoto");
		empresatest.setTemperatura(20);
		empresatest.setHorarioInicio("10:00:00");
		empresatest.setHorarioFim("20:00:00");
		empresatest.setHorarioArInicio("10:00:00");
		empresatest.setHorarioArFim("20:00:00");

		EmpresaService novoServico = new EmpresaService();
		novoServico.criarEmpresa(empresatest);

		Empresa novo = novoServico.ConsultarEmpresa("47.231.884/2318-80");

		System.out.println(novo.toString());
		
		
		empresatest.setCNPJ("47.231.884/2318-80");
		empresatest.setRazaoSocial("Portland CIA");
		empresatest.setTemperatura(24);
		empresatest.setHorarioInicio("10:00:00");
		empresatest.setHorarioFim("20:00:00");
		empresatest.setHorarioArInicio("10:00:00");
		empresatest.setHorarioArFim("20:00:00");
		
		novoServico.atualizarEmpresa(empresatest);
		Empresa novo2 = novoServico.ConsultarEmpresa("47.231.884/2318-80");
		
		System.out.println(novo2.toString());

		novoServico.excluirEmpresa("47.231.884/2318-80");
		
	}
}
