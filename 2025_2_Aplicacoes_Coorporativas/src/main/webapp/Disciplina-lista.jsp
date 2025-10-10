<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Disciplina" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Horas</th>
            </tr>
        </thead>
        <tbody>
            <%
    List<Disciplina> disciplinas = (List<Disciplina>) request.getAttribute("disciplinas");
    for (Disciplina disciplina : disciplinas) {
%>
    <tr>
        <td><%= disciplina.nome %></td>
        <td><%= disciplina.horas %></td>
    </tr>
<%
    }
%>
        </tbody>
    </table>
</body>
</html>