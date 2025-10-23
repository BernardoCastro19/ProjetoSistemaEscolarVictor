<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Aluno" %>
<%
    Aluno aluno = (Aluno) request.getAttribute("entidade");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Aluno - Formulário</title>
</head>
<body>
    <h2><% if (aluno != null) { %>Editar Aluno<% } else { %>Cadastrar Aluno<% } %></h2>
    <form action="<%= request.getContextPath() %>/aluno" method="post">
    <input type="hidden" name="id" value="<%= aluno != null ? aluno.getId() : "" %>">
    <input type="hidden" name="acao" value="<%= aluno != null ? "editar" : "cadastrar" %>">

    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" value="<%= aluno != null ? aluno.getNome() : "" %>" required><br><br>

    <label for="documento">Documento:</label>
    <input type="text" id="documento" name="documento" value="<%= aluno != null ? aluno.getDocumento() : "" %>" required><br><br>   

    <button type="submit"><%= aluno != null ? "Editar Aluno" : "Cadastrar Aluno" %></button>
</form>
</body>
</html>