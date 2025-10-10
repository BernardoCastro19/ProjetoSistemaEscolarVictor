<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Aluno" %>
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
            </tr>
        </thead>
        <tbody>
            <%
    List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
    for (Aluno aluno : alunos) {
%>
    <tr>
        <td><%= aluno.nome %></td>
        <td><%= aluno.documento %></td>
    </tr>
<%
    }
%>
        </tbody>
    </table>
</body>
</html>