<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Disciplina" %>
<%
    Disciplina disciplina = (Disciplina) request.getAttribute("entidade");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Disciplina - Formulário</title>
</head>
<body>
    <h2><% if (disciplina != null) { %>Editar Disciplina<% } else { %>Cadastrar Disciplina<% } %></h2>
    <form action="<%= request.getContextPath() %>/disciplina" method="post">
        <input type="hidden" name="id" value="<%= disciplina != null ? disciplina.getId() : "" %>">
        <input type="hidden" name="acao" value="<%= disciplina != null ? "editar" : "cadastrar" %>">

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="<%= disciplina != null ? disciplina.getNome() : "" %>" required><br><br>

        <label for="horas">Horas:</label>
        <input type="number" id="horas" name="horas" value="<%= disciplina != null ? disciplina.getHoras() : "" %>" required><br><br>

        <button type="submit"><%= disciplina != null ? "Editar Disciplina" : "Cadastrar Disciplina" %></button>
    </form>
</body>
</html>
