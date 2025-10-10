<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Professor" %>
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
                <th>Documento</th>
                <th>Diploma</th>
            </tr>
        </thead>
        <tbody>
            <%
    List<Professor> professores = (List<Professor>) request.getAttribute("professores");
    for (Professor professor : professores) {
%>
    <tr>
        <td><%= professor.nome %></td>
        <td><%= professor.documento %></td>
        <td><%= professor.diploma %></td>
    </tr>
<%
    }
%>
        </tbody>
    </table>
</body>
</html>