<%@ page import="com.elissonsilva.lanchonete.estrutura.*"%>
<%@ page import="com.elissonsilva.lanchonete.negocio.*"%>
<%@ page import="com.elissonsilva.lanchonete.layout.*"%>

<%
LanEstrutura.preparaEstruturaInicial();

LanMontaLanche preparaLanche = new LanMontaLanche();

preparaLanche.defineIngredientes(request.getParameter("request"));

LanLayoutLanche lanchePersonalizado = new LanLayoutLanche(preparaLanche.retornaLanche());

%>

{ "preco": "<%= lanchePersonalizado.getPreco() %>", "desconto": "<%= lanchePersonalizado.getDesconto() %>" }
