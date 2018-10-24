Lanchonete
------------------

Programa de avaliação de código desenvolvido em Java rodando em um conteiner Docker com Tomcat 8.0. Para expor o Tomcat, foi utilizado um outro container Docker com NGINX configurado para realizar o proxy reverso da porta 80 para o Tomcat.

O que precisa para rodar o projeto?
------------------
_Essas versões foram as utilizadas no desenvolvimento_

* JDK 1.8.0_121
* Apache Maven 3.3.9
* Docker 18.06.1-ce
* Docker Compose 1.22.0

Como executar o projeto
------------------

1) Faça o build do projeto Java _(dentro pasta *lanchonete*)_: `mvn install`
2) Copie o arquivo `lanchonete.war` _(gerado na etapa anterior)_ para dentro da pasta `docker_lanchonete`
3) Faça o build das imagens docker: `docker-composer build`
4) Dispare os containers: `docker-composer up`
5) Acesse http://localhost/

Considerações sobre arquivos e classes
------------------

    .
    ├── docker_lanchonete
    │   └── Dockerfile
    ├── docker_reverseproxy
    │   └── Dockerfile
    ├── lanchonete
    │   ├── pom.xml
    │   ├── src/main/java
    │   ├── src/main/webapp
    │   └── src/test/java
    ├── docker-compose.yml
    ├── .env
    └── ...	
	

* `.env` Contém apenas uma veriável de ambiente para parametrizar a porta de saída na hora de subir o docker que vai rodar o NGINX
* `LanException` Apenas uma classe padrão de Exception para organizar os erros tratados na lógica desse programa.
* `LanIngrediente` Classe responsável por armazenar o nome e o valor de 1 ingrediente.
* `LanLanche` Contem o nome do lanche e um ArrayList de ```LanIngredientes``` que compoe o lanche.
* `LanEstrutura` Classe com métodos estaticos que preparam os dados inicias do programa (veja [Estrutura Inicial](#estrutura-inicial))
* `LanPromocao` Classe com 1 metodo que recebe 1 lanche por parametro e calcula o valor final considerando as regras das promoções.
* `LanMontaLanche` ...

Considerações sobre o projeto
------------------

* Optei por cirar uma classe especifica para as promoções para isolar a regra de negocio da estrutura do lanche. Caberia até uma implementação de herança de forma que a regra de promoção fosse uma base para a classe do Lanche.
* A classe de testes unitário verifica se a classe de estrutura dos Ingredientes e Lanche está funcionando corretamente, verifica o valor do lanche baseado nos ingredientes e verifica o valor dos lanches em cada uma das promoçoes.
* 

Estrutura Inicial
------------------

Ao iniciar o Tomcat, o contexto irá executar o método estático `LanEstrutura.preparaEstruturaInicial()`. Esse método irá carregar a lanchonete da seguinte forma:

INGREDIENTE | VALOR
------------ | -------------
Alface | R$ 0,40
Bacon | R$ 2,00
Hamburguer | R$ 3,00
Ovo | R$ 0,80
Queijo | R$ 1,50

LANCHE | INGREDIENTES
------------ | -------------
X-Bacon | Bacon, hamurguer e queijo
X-Burguer | Hamburguer e queijo
X-Egg | Ovo, hamburguer e queijo
X-Egg Bacon | Ovo, bacon, hamburguer e queijo
