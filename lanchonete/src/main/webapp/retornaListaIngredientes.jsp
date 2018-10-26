<%@ page import="com.elissonsilva.lanchonete.estrutura.*"%>
<%@ page import="com.elissonsilva.lanchonete.layout.*"%>
<% LanEstrutura.preparaEstruturaInicial(); %>
<% LanLayout layout = new LanLayout(); %>
<%= layout.mostraOpcoesIngredientes() %>