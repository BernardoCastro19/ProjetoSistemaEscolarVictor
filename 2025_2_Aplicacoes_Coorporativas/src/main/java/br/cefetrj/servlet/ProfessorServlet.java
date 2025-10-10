package br.cefetrj.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.dao.AlunoDAO;
import br.cefetrj.dao.ProfessorDAO;
import br.cefetrj.model.Usuario;
import br.cefetrj.model.Aluno;
import br.cefetrj.model.Professor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Professor")
public class ProfessorServlet extends HttpServlet {
    private static final long serialVersionUID = 3L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String nome = request.getParameter("nome");
        String documento = request.getParameter("documento");
        String diploma = request.getParameter("diploma");

        Professor professor = new Professor();
        professor.setNome(nome);
        professor.setDocumento(documento);
        professor.setDiploma(diploma);
        // Aqui você pode adicionar o cliente a um banco de dados ou a uma lista
        ProfessorDAO dao = new ProfessorDAO();
        dao.salvar(professor);
        RequestDispatcher rd = request.getRequestDispatcher("cadastro-sucesso.jsp");

        rd.forward(request, response);

    }

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ProfessorDAO dao = new ProfessorDAO();
        List<Professor> professores;
            professores = dao.listar();
            request.setAttribute("professores", professores);
            RequestDispatcher rd = request.getRequestDispatcher("lista-professores.jsp");
            rd.forward(request, response);
    }

}
