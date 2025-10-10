<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Turma" %>
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
                <th>Numero de Alunos</th>
                <th>Disciplina</th>
            </tr>
        </thead>
        <tbody>
            <%
    List<Turma> turmas = (List<Turma>) request.getAttribute("turmas");
    for (Turma turma : turmas) {
%>
    <tr>
        <td><%= turma.nome %></td>
        <td><%= turma.numeroAlunos %></td>
        <td><%= turma.disciplina %></td>
    </tr>
<%
    }
%>
        </tbody>
    </table>
</body>
</html>