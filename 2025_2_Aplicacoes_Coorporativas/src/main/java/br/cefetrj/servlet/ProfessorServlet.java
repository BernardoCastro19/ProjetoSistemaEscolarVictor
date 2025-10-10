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

        Professor professor = new Professor(null,nome, documento, diploma);
        // Aqui você pode adicionar o cliente a um banco de dados ou a uma lista
        ProfessorDAO dao = new ProfessorDAO();
        try {
            dao.inserir(professor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("cadastro-sucesso.jsp");

        rd.forward(request, response);

    }

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ProfessorDAO dao = new ProfessorDAO();
        List<Professor> professores;
        try {
            professores = dao.listarTodos();
            request.setAttribute("professores", professores);
            RequestDispatcher rd = request.getRequestDispatcher("lista-professores.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private List<Professor> criaProfessores() {
        List<Professor> professores = new ArrayList<>();
        Professor professor1 = new Professor(1, "Professor 1", "134515616","Graduado em SI");
        Professor professor2 = new Professor(2, "Professor 2", "132251511","Mestrado em Fisica");
        Professor professor3 = new Professor(3, "Professor 3", "433564363","Graduado em ADS");
        professores.add(professor1);
        professores.add(professor2);
        professores.add(professor3);
        return professores;
    }
}
