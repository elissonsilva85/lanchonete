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

  <div class="row mt-5">
    <h5 class="display-4">Lanchonete</h5>
  </div>	
	
  <div class="row mt-5">
    <div class="col-sm">
      <%= layout.mostraIngredientes() %>
    </div>
    <div class="col-sm">
      <%= layout.mostraLanches() %>
    </div>
  </div>	
  
  <div class="row mt-5">
    <h6 class="display-4">Pedido</h6>
  </div>
  <div class="row">
	<form>
	  <div class="form-group row">
	    <label for="quantidade" class="col-sm-2 col-form-label">Quantidade</label>
	    <div class="col-sm-10">
	      <input type="number" class="form-control" id="quantidade">
	    </div>
	  </div>
	  <div class="form-group row">
	    <label for="lanche" class="col-sm-2 col-form-label">Lanche</label>
	    <div class="col-sm-10">
	      <select id="lanche" class="form-control form-control-lg">
		    <option>Large select</option>
		  </select>
	    </div>
	  </div>
	</form>
  </div>
	
	


</div>


</body>
</html>