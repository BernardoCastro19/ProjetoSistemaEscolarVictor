package br.cefetrj.servlet;

import br.cefetrj.model.Professor;
import br.cefetrj.servlet.GenericServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/Professor")
public class ProfessorServlet extends GenericServlet<Professor> {

    @Override
    protected Professor preencherEntidade(HttpServletRequest request) {
        Professor professor = new Professor();
        professor.setId(request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0);
        professor.setNome(request.getParameter("nome"));
        professor.setDocumento(request.getParameter("documento"));
        professor.setDiploma(request.getParameter("diploma"));
        return professor;
    }
}