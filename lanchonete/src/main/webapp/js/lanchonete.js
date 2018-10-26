angular.module('lanchoneteApp', [])
.controller('LanchoneteController', ['$scope', '$q', '$http', function($scope, $q, $http) {

  let formatoPreco = new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL', minimumFractionDigits: 2 });
	
  $scope.ingredientes = [ ];

  $scope.lanchePersonalizado = [ ];
  
  $scope.precoFinal = "";
  $scope.descontoFinal = "";
  
  $scope.buscaPrecoLanche = function() {
        let deferred = $q.defer();
        let params   = JSON.stringify($scope.lanchePersonalizado) ;
        $http({
		  method: 'GET',
		  url: 'retornaPrecoLanche.jsp',
		  params: { request: params }
		}).then(
	        function(data, status, headers, config) {
                 deferred.resolve({Server_Response:data, Server_Status: status});
            },
            function(data, status, headers, config) {
                 deferred.resolve(status);
            }
        );

        return deferred.promise;
  };
  
  $scope.atualizaPrecoFinal = function() {
    //
	$scope.precoFinal = "...";
    //
    // Chama a função que vai processar o valor final do lanche 
    let retornoBuscaPreco = $scope.buscaPrecoLanche();
    //
    // Trata o retorno
    retornoBuscaPreco.then(function(retorno) {
    	let preco = retorno.Server_Response.data.preco;
        let desconto = retorno.Server_Response.data.desconto; 
    	$scope.precoFinal = preco;
    	$scope.descontoFinal = desconto;
    });
  };
  
  $scope.adicionaIngrediente = function() {
    
	  $scope.lanchePersonalizado.push({ "nome": "", "qtde": null });

  };
  
  $scope.removerIngrediente = function(index) {
  
	  $scope.lanchePersonalizado.splice(index, 1);
  
  };
  
  $scope.calculaPrecoIngrediente = function(index) {
	  
	  let qtde = $scope.lanchePersonalizado[index].qtde;
	  let nome = $scope.lanchePersonalizado[index].nome;
	  let ingrediente = $scope.ingredientes.find(function(element) {
		  return element.nome == ingrediente;
	  }); 
	  
	  return qtde * ingrediente.valor;
	  
  }
  
  $scope.buscaPreco = function(qtde, nome) {
	  let localizado = $scope.ingredientes.find(function(elem) { return elem.nome == nome });
	  return formatoPreco.format((qtde > 0 ? qtde : 0) * (localizado ? localizado.valor : 0));
  }
  
  $http({
	  method: 'GET',
	  url: 'retornaListaIngredientes.jsp'
  }).then(
       function(data, status, headers, config) {
    	   $scope.ingredientes = data.data;
    	   $scope.adicionaIngrediente();
       }
  );

}]);