<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Turma" %>
<%
    List<Turma> turmas = (List<Turma>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Turmas</title>
    <style>
        table { border-collapse: collapse; width: 60%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f2f2f2; }
        a { margin-right: 8px; }
    </style>
</head>
<body>
    <h2>Lista de Turmas</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Número de Alunos</th>
            <th>Disciplina</th>
            <th colspan="2">Ações</th>
        </tr>
        <%
            if (turmas != null && !turmas.isEmpty()) {
                for (Turma turma : turmas) {
        %>
        <tr>
            <td><%= turma.getId() %></td>
            <td><%= turma.getNome() %></td>
            <td><%= turma.getNumeroAlunos() %></td>
            <td><%= turma.getDisciplina() %></td>
            <td>
                <a href="<%= request.getContextPath() %>/turma?acao=buscar&id=<%= turma.getId() %>">Editar</a>
            </td>
            <td>
                <a href="<%= request.getContextPath() %>/turma?acao=deletar&id=<%= turma.getId() %>"
                   onclick="return confirm('Tem certeza que deseja remover?');">Remover</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6">Nenhuma turma encontrada.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>