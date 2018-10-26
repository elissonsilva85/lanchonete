<%@ page import="com.elissonsilva.lanchonete.estrutura.*"%>
<%@ page import="com.elissonsilva.lanchonete.layout.*"%>
<% LanEstrutura.preparaEstruturaInicial(); %>
<% LanLayout layout = new LanLayout(); %>
<!doctype html>
<html lang="pt-BR" ng-app="lanchoneteApp" ng-controller="LanchoneteController">
<head>
	<title>Lanchonete</title>
	<link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="./css/bootstrap-grid.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="./js/angular.min.js"></script>
	<script type="text/javascript" src="./js/lanchonete.js"></script>
	<style>
	.ocultar { display: none }
	</style>
</head>
<body>

<div class="container p-4">

  <div class="row">
    <h5 class="display-4">Lanchonete</h5>
  </div>	
	
  <div class="row mt-3">
    <div class="col-sm">
      <%= layout.mostraIngredientes() %>
    </div>
    <div class="col-sm">
      <%= layout.mostraLanches() %>
    </div>
  </div>	
  
  <div class="row mt-5">
    <h6 class="display-4">Monte seu lanche</h6>
  </div>
  <div class="row mt-3">
    <table class="table table-hover">
	    <thead>
		    <tr>
  		      <th>Ingrediente</th>
		      <th>Valor</th>
		      <th><button type="button" class="btn btn-outline-success" ng-click="adicionaIngrediente()">Adicionar Ingrediente</button></th>
		    </tr>
	    </thead>
	    <tbody>
		    <tr ng-repeat="ing in lanchePersonalizado" >
		      <td>
			    <form class="form-inline">
				    <div class="form-group mb-2"><input type="number" class="form-control" id="quantidade" ng-model="ing.qtde" placeholder="Qtde" style="width: 5em"></div>
				    <div class="form-group mx-sm-3 mb-2"><label class="col-form-label">x</label></div>
				    <div class="form-group mb-2"><select id="ingrediente" class="form-control" ng-model="ing.nome">
				      <option ng-repeat="opcao in ingredientes">{{opcao.nome}}</option>
				    </select></div>
				</form>
			  </td>
		      <td><div class="pt-2"><span ng-bind="buscaPreco(ing.qtde, ing.nome)"></span></div></td>
		      <td><button type="button" class="btn btn-outline-danger" ng-class="{ ocultar: lanchePersonalizado.length <= 1 }" ng-click="removerIngrediente($index)">Remover Ingrediente</button></td>
		    </tr>
	    </tbody>
	    <tfoot>
		      <td></td>
		      <td><strong ng-bind="precoFinal">-</strong><small ng-class="{ 'text-muted': true, ocultar: descontoFinal == '' }" ><br>(desconto <span ng-bind="descontoFinal"></span>)</small></td>
		      <td><button type="button" class="btn btn-secondary" ng-click="atualizaPrecoFinal()">PEDIR LANCHE</button></td>
		    </tr>
	    </tfoot>
    </table>
  </div>

</div>
</body>
</html>