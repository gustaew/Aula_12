<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device=width, initial-scale=1">
<title>Sistema Controle Predial - Consultar Empresa</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<style>
#formularioConsultar {
	margin: 20px;
}

#tituloGrupo{
	margin:20px;
}

</style>
</head>
<body>
<c:import url="Menu.jsp" />
	<div class="panel panel-info" id="formularioConsultar">
		<div class="panel-heading">
			<h3 class="panel-title" id="tituloForm">Dados da Empresa</h3>
		</div>
		<div class="panel-body">


			<div class="row">
				<h4 id="tituloGrupo" >Dados Sociais</h4>
				<div class="form-group col-sm-6">


					<label for='Cnpj'>CNPJ:</label> <input class="form-control"
						id='Cnpj' type='text' value=" ${empresa.CNPJ}" disabled />
				</div>

				<div class="form-group col-sm-6">

					<label for='razaoSocial'>Nome:</label> <input class="form-control"
						id='razaoSocial' type='text' value=" ${empresa.razaoSocial}"
						disabled />
				</div>
			</div>

			<div class="row">
				<h4 id="tituloGrupo">Dados Funcionamento</h4>
				<div class="form-group col-sm-6">
					<label for='horarioInicio'>Início:</label> <input
						class="form-control" id='horarioInicio'
						 type='text' value=" ${empresa.horarioInicio}" disabled />
				</div>

				<div class="form-group col-sm-6">
					<label for='horarioFim'>Fim:</label> <input class="form-control"
						id='horarioFim' type='text' value=" ${empresa.horarioFim} "
						disabled />
				</div>
			</div>

			<div class="row">
				<h4 id="tituloGrupo">Dados Temperatura</h4>
				<div class="form-group col-sm-4">
					<label for='horarioArInicio'>Início do Funcionamento(Ar):</label> <input
						class="form-control" id='horarioArInicio' type='text'
						value="${empresa.horarioArInicio}" disabled />
				</div>

				<div class="form-group col-sm-4">

					<label for='horarioArFim'>Fim do Funcionamento(Ar):</label> <input
						class="form-control" id='horarioArFim' type='text'
						value=" ${empresa.horarioArFim}" disabled />
				</div>

				<div class="form-group col-sm-4">


					<label for='temperaturaAr'>Temperatura: </label> <input
						class="form-control" id='temperaturaAr' type='text'
						value=" ${empresa.temperatura}" disabled />
				</div>
			</div>
			<br> <a href="controller?command=PesquisarEmpresa&empresaPesquisada="
					class="btn btn-default">Voltar</a>

		</div>
	</div>

</body>
</html>

