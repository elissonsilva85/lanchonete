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


