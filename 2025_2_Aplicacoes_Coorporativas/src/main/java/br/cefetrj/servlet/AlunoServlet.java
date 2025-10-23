package br.cefetrj.servlet;

import br.cefetrj.model.Aluno;
import br.cefetrj.utils.DateUtils;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/aluno")
public class AlunoServlet extends GenericServlet<Aluno> {

    @Override
    protected Aluno preencherEntidade(HttpServletRequest request) {
    Aluno aluno = new Aluno();
    String idParam = request.getParameter("id");
    if (idParam != null && !idParam.isEmpty()) {
        aluno.setId(Integer.parseInt(idParam));
    }
    aluno.setNome(request.getParameter("nome"));
    aluno.setDocumento(request.getParameter("documento"));
    return aluno;
}
}