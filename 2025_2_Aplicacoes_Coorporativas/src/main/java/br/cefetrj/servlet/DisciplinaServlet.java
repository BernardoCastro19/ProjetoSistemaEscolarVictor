package br.cefetrj.servlet;

import br.cefetrj.model.Disciplina;
import br.cefetrj.servlet.GenericServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/disciplina")
public class DisciplinaServlet extends GenericServlet<Disciplina> {

    @Override
    protected Disciplina preencherEntidade(HttpServletRequest request) {
    Disciplina disciplina = new Disciplina();
    String idParam = request.getParameter("id");
    if (idParam != null && !idParam.isEmpty()) {
        disciplina.setId(Integer.parseInt(idParam));
    }
    disciplina.setNome(request.getParameter("nome"));
    disciplina.setHoras( Integer.parseInt(request.getParameter("horas")));
    return disciplina;
}
}