<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Disciplina" %>
<%

    List<Disciplina> disciplinas = (List<Disciplina>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Disciplinas</title>
    <style>
        table { border-collapse: collapse; width: 60%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f2f2f2; }
        a { margin-right: 8px; }
    </style>
</head>
<body>
    <h2>Lista de Disciplinas</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Horas</th>
            <th colspan="2">Ações</th>
        </tr>
        <%
            if (disciplinas != null && !disciplinas.isEmpty()) {
                for (Disciplina disciplina : disciplinas) {
        %>
        <tr>
            <td><%= disciplina.getId() %></td>
            <td><%= disciplina.getNome() %></td>
            <td><%= disciplina.getHoras() %></td>
            <td>
                <a href="<%= request.getContextPath() %>/disciplina?acao=buscar&id=<%= disciplina.getId() %>">Editar</a>
            </td>
            <td>
                <a href="<%= request.getContextPath() %>/disciplina?acao=deletar&id=<%= disciplina.getId() %>"
                onclick="return confirm('Tem certeza que deseja remover?');">Remover</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">Nenhuma disciplina encontrado.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>