package br.cefetrj.servlet;

import br.cefetrj.model.Disciplina;
import br.cefetrj.servlet.GenericServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/Disciplina")
public class DisciplinaServlet extends GenericServlet<Disciplina> {

    @Override
    protected Disciplina preencherEntidade(HttpServletRequest request) {
        Disciplina disciplina = new Disciplina();
        disciplina.setId(request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0);
        disciplina.setNome(request.getParameter("nome"));
        disciplina.setHoras( Integer.parseInt(request.getParameter("horas")));
        return disciplina;
    }
}