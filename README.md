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

Se desejar recompilar o projeto Java:
1) Faça o build do projeto Java _(dentro pasta *lanchonete*)_: `mvn install`
2) Copie o arquivo `lanchonete.war` _(gerado na etapa anterior)_ para dentro da pasta `docker_lanchonete`

Para rodar os conteiners:
1) Faça o build das imagens docker: `docker-composer build`
2) Dispare os containers: `docker-composer up`
3) Acesse http://localhost/

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
* `LanMontaLanche` Classe utilizada para montar o lanche na seção *Monte seu lanche* e retornar o valor final após aplicada as promoções

Considerações sobre o projeto
------------------

* Aproveitei o projeto e pesquisei um pouco sobre AngularJS e apliquei alguns conceitos no layout.
* Estou usando AngularJS para atualizar os valores na parte do *Monte seu Lanche*.
* Optei por criar uma classe especifica para as promoções para isolar a regra de negocio da estrutura do lanche. Um possibilidade seria implementar herança nas classes de forma que o `LanLanche` fosse um filho da classe `LanPromocao`, dessa forma o lanche herdaria as propriedades de promoção.
* A classe de testes unitário verifica se a classe de estrutura dos Ingredientes e Lanche está funcionando corretamente, verifica o valor do lanche baseado nos ingredientes e verifica o valor dos lanches em cada uma das promoções.
* Comecei todas as classes com `Lan` apenas como uma boa pratica para organizar as classes do projeto.
* Gastei em torno de 13 horas nesse projeto entre pesquisas e desenvolvimento.

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
