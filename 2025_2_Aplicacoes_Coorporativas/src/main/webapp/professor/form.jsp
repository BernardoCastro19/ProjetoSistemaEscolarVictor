<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Professor" %>
<%
    Professor professor = (Professor) request.getAttribute("entidade");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Professor - Formulário</title>
</head>
<body>
    <h2><% if (professor != null) { %>Editar Professor<% } else { %>Cadastrar Professor<% } %></h2>
    <form action="<%= request.getContextPath() %>/professor" method="post">
    <input type="hidden" name="id" value="<%= professor != null ? professor.getId() : "" %>">
    <input type="hidden" name="acao" value="<%= professor != null ? "editar" : "cadastrar" %>">

    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" value="<%= professor != null ? professor.getNome() : "" %>" required><br><br>

    <label for="documento">Documento:</label>
    <input type="text" id="documento" name="documento" value="<%= professor != null ? professor.getDocumento() : "" %>" required><br><br>   
    
    <label for="diploma">Diploma:</label>
    <input type="text" id="diploma" name="diploma" value="<%= professor != null ? professor.getDiploma() : "" %>" required><br><br>   
    <button type="submit"><%= professor != null ? "Editar Professor" : "Cadastrar Professor" %></button>
</form>
</body>
</html>