package br.cefetrj.servlet;

import br.cefetrj.model.Professor;
import br.cefetrj.servlet.GenericServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/professor")
public class ProfessorServlet extends GenericServlet<Professor> {

    @Override
    protected Professor preencherEntidade(HttpServletRequest request) {
    Professor professor = new Professor();
    String idParam = request.getParameter("id");
    if (idParam != null && !idParam.isEmpty()) {
        professor.setId(Integer.parseInt(idParam));
    }
    professor.setNome(request.getParameter("nome"));
    professor.setDocumento(request.getParameter("documento"));
    professor.setDiploma(request.getParameter("diploma"));
    return professor;
}
}