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

1) Faça o build do projeto Java: `mvn build`
2) Faça o build das imagens docker: `docker-composer build`
3) Dispare os containers: `docker-composer up`
4) Acesse http://localhost/


