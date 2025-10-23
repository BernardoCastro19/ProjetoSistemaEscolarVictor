<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erro</title>
</head>
<body>
    <h2>Ocorreu um erro ao processar a requisição.</h2>
    <p>Verifique o log do servidor para mais detalhes.</p>
    <a href="<%= request.getContextPath() %>/aluno?acao=listar">Voltar</a>
</body>
</html>
