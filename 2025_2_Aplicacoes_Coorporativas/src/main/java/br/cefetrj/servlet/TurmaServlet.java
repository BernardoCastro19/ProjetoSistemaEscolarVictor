package br.cefetrj.servlet;

import br.cefetrj.model.Turma;
import br.cefetrj.servlet.GenericServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/turma")
public class TurmaServlet extends GenericServlet<Turma> {

    @Override
    protected Turma preencherEntidade(HttpServletRequest request) {
    Turma turma = new Turma();
    String idParam = request.getParameter("id");
    if (idParam != null && !idParam.isEmpty()) {
        turma.setId(Integer.parseInt(idParam));
    }
    turma.setNome(request.getParameter("nome"));
    turma.setNumeroAlunos( Integer.parseInt(request.getParameter("numeroAlunos")));
    turma.setDisciplina(request.getParameter("disciplina"));
    return turma;
    }
}