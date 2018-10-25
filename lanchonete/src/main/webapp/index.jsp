<%@ page import="com.elissonsilva.lanchonete.estrutura.*"%>
<%@ page import="com.elissonsilva.lanchonete.layout.*"%>
<% LanEstrutura.preparaEstruturaInicial(); %>
<% LanLayout layout = new LanLayout(); %>
<!doctype html>
<html lang="pt-BR">
<head>
	<title>Lanchonete</title>
	<link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="./css/bootstrap-grid.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="./js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./js/bootstrap.bundle.min.js"></script>
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
    <h6 class="display-4">Monte seu lanche:</h6>
  </div>
  <div class="row mt-3">
    <table class="table">
	    <thead>
		    <tr>
  		      <th>Ingrediente</th>
		      <th>Valor</th>
		      <th><button type="button" class="btn btn-outline-success">Adicionar Ingrediente</button></th>
		    </tr>
	    </thead>
	    <tbody>
		    <tr>
		      <td>
			    <div class="row">
			    <form>
				    <div class="col-12"><input type="number" class="form-control" id="quantidade"></div>
				    <div class="col-12"><label class="col-form-label">x</label></div>
				    <div class="col-12"><select id="ingrediente" class="form-control">
				      <%= layout.mostraOpcoesIngredientes() %>
				    </select></div>
				</form>
				</div>
			  </td>
		      <td>R$ 3,00</td>
		      <td><button type="button" class="btn btn-outline-danger">Remover Ingrediente</button></td>
		    </tr>
	    </tbody>
	    <tfoot>
		    <tr>
		      <td>X, Y, Z</td>
		      <td>R$ 30,00</td>
		      <td><button type="button" class="btn btn-secondary">PEDIR LANCHE</button></td>
		    </tr>
	    </tfoot>
    </table>
  </div>

</div>
</body>
</html>