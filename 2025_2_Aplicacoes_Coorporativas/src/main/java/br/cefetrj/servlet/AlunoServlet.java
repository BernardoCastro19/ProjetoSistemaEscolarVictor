package br.cefetrj.servlet;

import br.cefetrj.model.Aluno;
import br.cefetrj.servlet.GenericServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/Aluno")
public class AlunoServlet extends GenericServlet<Aluno> {

    @Override
    protected Aluno preencherEntidade(HttpServletRequest request) {
        Aluno aluno = new Aluno();
        aluno.setId(request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0);
        aluno.setNome(request.getParameter("nome"));
        aluno.setDocumento(request.getParameter("documento"));
        return aluno;
    }
}