<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Professor" %>
<%

    List<Professor> professores = (List<Professor>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Professores</title>
    <style>
        table { border-collapse: collapse; width: 60%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f2f2f2; }
        a { margin-right: 8px; }
    </style>
</head>
<body>
    <h2>Lista de Professores</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Documento</th>
            <th>Diploma</th>
            <th colspan="2">Ações</th>
        </tr>
        <%
            if (professores != null && !professores.isEmpty()) {
                for (Professor professor : professores) {
        %>
        <tr>
            <td><%= professor.getId() %></td>
            <td><%= professor.getNome() %></td>
            <td><%= professor.getDocumento() %></td>
            <td><%= professor.getDiploma() %></td>
            <td>
                <a href="<%= request.getContextPath() %>/professor?acao=buscar&id=<%= professor.getId() %>">Editar</a>
            </td>
            <td>
                <a href="<%= request.getContextPath() %>/professor?acao=deletar&id=<%= professor.getId() %>"
                onclick="return confirm('Tem certeza que deseja remover?');">Remover</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">Nenhum professor encontrado.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>