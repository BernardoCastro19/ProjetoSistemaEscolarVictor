package br.cefetrj.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.dao.AlunoDAO;
import br.cefetrj.dao.TurmaDAO;
import br.cefetrj.model.Usuario;
import br.cefetrj.model.Aluno;
import br.cefetrj.model.Disciplina;
import br.cefetrj.model.Turma;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Turma")
public class TurmaServlet extends HttpServlet {
    private static final long serialVersionUID = 3L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String nome = request.getParameter("nome");
        Integer numeroAlunos = Integer.parseInt(request.getParameter("numeroAlunos"));
        String disciplina = request.getParameter("disciplina");

        Turma turma = new Turma(null, nome, numeroAlunos, disciplina);
        // Aqui você pode adicionar a turma a um banco de dados ou a uma lista
        TurmaDAO dao = new TurmaDAO();
        try {
            dao.inserir(turma);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("cadastro-sucesso.jsp");

        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        TurmaDAO dao = new TurmaDAO();
        List<Turma> turmas;
        try {
            turmas = dao.listarTodos();
            request.setAttribute("turmas", turmas);
            RequestDispatcher rd = request.getRequestDispatcher("lista-turma.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private List<Turma> criaTurmas() {
        List<Turma> turmas = new ArrayList<>();
        Turma turma1 = new Turma(1, "Turma 1", 20,"Matematica");
        Turma turma2 = new Turma(2, "Turma 2",30, "Portugues");
        Turma turma3 = new Turma(3, "Turma 3",15, "Geografia");
        turmas.add(turma1);
        turmas.add(turma2);
        turmas.add(turma3);
        return turmas;
    }
}
