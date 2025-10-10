package br.cefetrj.servlet;

import br.cefetrj.model.Turma;
import br.cefetrj.servlet.GenericServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/Turma")
public class TurmaServlet extends GenericServlet<Turma> {

    @Override
    protected Turma preencherEntidade(HttpServletRequest request) {
        Turma turma = new Turma();
        turma.setId(request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0);
        turma.setNome(request.getParameter("nome"));
        turma.setNumeroAlunos( Integer.parseInt(request.getParameter("numeroAlunos")));
        turma.setNome(request.getParameter("disciplina"));
        return turma;
    }
}