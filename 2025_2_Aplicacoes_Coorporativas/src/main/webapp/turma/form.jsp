<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Turma" %>
<%
    Turma turma = (Turma) request.getAttribute("entidade");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Turma - Formulário</title>
</head>
<body>
    <h2><%= turma != null ? "Editar Turma" : "Cadastrar Turma" %></h2>

    <form action="<%= request.getContextPath() %>/turma" method="post">
        <input type="hidden" name="id" value="<%= turma != null ? turma.getId() : "" %>">
        <input type="hidden" name="acao" value="<%= turma != null ? "editar" : "cadastrar" %>">

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="<%= turma != null ? turma.getNome() : "" %>" required><br><br>

        <label for="numeroAlunos">Número de Alunos:</label>
        <input type="number" id="numeroAlunos" name="numeroAlunos" value="<%= turma != null ? turma.getNumeroAlunos() : "" %>" required><br><br>

        <label for="disciplina">Disciplina:</label>
        <input type="text" id="disciplina" name="disciplina" value="<%= turma != null ? turma.getDisciplina() : "" %>" required><br><br>   


        <button type="submit"><%= turma != null ? "Editar Turma" : "Cadastrar Turma" %></button>
    </form>
</body>
</html>
