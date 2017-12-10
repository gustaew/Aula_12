<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema Controle Predial - Atualizar Empresa</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<style>
#formularioAtualizar {
	margin: 20px;
}

h4 {
	margin: 18px;
}
</style>

</head>

<body>
	<c:import url="Menu.jsp"></c:import>

	<div class="panel panel-primary" id="formularioAtualizar">
		<div class="panel-heading">
			<h3 class="panel-title" id="tituloForm">Atualizar Empresa -
				#${empresa.CNPJ }</h3>
		</div>

		<div class="panel-body">
			<form action="controller" method="post">

				<!--Campos dados sociais-->

				<div class="row">

					<h4>Dados Sociais</h4>

					<input class="form-control" id="Cnpj" name="cnpj" type="hidden"
						value="${empresa.CNPJ }" />

					<div class="form-group col-md-6">
						<label for="razaoSocial">Nome:</label> <input class="form-control"
							id="razaoSocial" name="razao_social"
							value="${empresa.razaoSocial}" type="text" />
					</div>

				</div>

				<!-- Fecha campos sociais -->

				<div class="row">

					<h4>Dados Funcionamento</h4>

					<div class="form-group col-md-6">
						<label for="horarioInicio">Início:</label> <input
							class="form-control" value="${empresa.horarioInicio}"
							id="horarioInicio" name="horario_Inicio" type="Time" />
					</div>

					<div class="form-group col-md-6">
						<label for="horarioFim">Fim:</label> <input class="form-control"
							id="horarioFim" value="${empresa.horarioFim}" name="horario_Fim"
							type="Time" />
					</div>

				</div>

				<div class="row">

					<h4>Dados Temperatura</h4>

					<div class="form-group col-sm-4">
						<label for="horarioArInicio">Início do Funcionamento(Ar):</label>
						<input class="form-control" id="horarioArInicio"
							name="horario_ArInicio" value="${empresa.horarioArInicio}"
							type="Time" />
					</div>

					<div class="form-group col-sm-4">
						<label for="horarioArFim">Fim do Funcionamento(Ar):</label> <input
							class="form-control" value="${empresa.horarioArFim}"
							id="horarioArFim" name="horario_ArFim" type="Time" />
					</div>

					<div class="form-group col-sm-4">
						<label for="temperaturaAr">Temperatura: </label> <input
							class="form-control" value="${empresa.temperatura}"
							id="temperaturaAr" name="Artemperatura" type="number" />
					</div>

				</div>

				<button class="btn btn-primary" id="atualizarEmpresa" type="submit"
					name="command" value="AtualizarEmpresa">Atualizar</button>
				<a href="controller?command=PesquisarEmpresa&empresaPesquisada="
					class="btn btn-default">Cancelar</a>

			</form>
		</div>
	</div>


	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>